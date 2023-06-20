package com.desire.figmadatabaseapi.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.util.Log
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import com.desire.figmadatabaseapi.databinding.ActivityHomePageBinding
import com.desire.figmadatabaseapi.main.MainActivity
import com.desire.figmadatabaseapi.main.pass.ProductAdapter
import com.desire.figmadatabaseapi.retrofit.Retrofit
import com.desire.figmadatabaseapi.retrofit.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    lateinit var adapter: Adapter
    var productArray = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*        arrayListOfData = ArrayList<RcvModel>()

                arrayListOfData.add(RcvModel("TSHIRT", "BRAND NAME: POLO", R.drawable.img_tshirt))
                arrayListOfData.add(RcvModel("SHIRT", "BRAND NAME: ZUDIO", R.drawable.img_shirt))
                arrayListOfData.add(RcvModel("TROUSER", "BRAND NAME: POLO", R.drawable.img_trouser))
                arrayListOfData.add(RcvModel("CAP", "BRAND NAME: POLO", R.drawable.img_cap))

                setAdapter()*/

        ivBack()
        getData()
    }

    private fun ivBack() {
        binding.ivBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun getData(){
        var call : Call<ArrayList<User>> = Retrofit.apiInterface.getData()
        call.enqueue(object : Callback<ArrayList<User>>{

            override fun onResponse(
                call: Call<ArrayList<User>>,
                response: Response<ArrayList<User>>
            ) {
                if (response.isSuccessful){
                    response.body()?.let {
                        productArray.addAll(it)

                        binding.rcvItems.layoutManager= GridLayoutManager(this@HomePageActivity,2)
                        binding.rcvItems.adapter = ProductAdapter(productArray)

                    }
                }
            }
            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                Log.i("test", "Fail")
            }

        })
    }

}





