package com.desire.figmadatabaseapi.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.desire.figmadatabaseapi.R
import com.desire.figmadatabaseapi.databinding.ActivityHomePageBinding
import com.desire.figmadatabaseapi.main.MainActivity
import com.desire.figmadatabaseapi.retrofit.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    lateinit var rcvAdapter: RcvAdapter
    var arrayListOfData = arrayListOf<RcvModel>()

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
        getProducts()
    }

    private fun ivBack() {
        binding.ivBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }



    private fun getProducts() {
        val call: Call<ArrayList<RcvModel>> = Retrofit.api.getData()
        call.enqueue(object : Callback<ArrayList<RcvModel>> {
            override fun onResponse(
                call: Call<ArrayList<RcvModel>>,
                response: Response<ArrayList<RcvModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        arrayListOfData.addAll(it)
                        setAdapter()
                    }
                }
            }
            override fun onFailure(call: Call<ArrayList<RcvModel>>, t: Throwable) {
                Log.i("Test", "Fail")
            }
        })
    }
    private fun setAdapter() {
        binding.rcvItems.layoutManager = GridLayoutManager(this, 2)
        binding.rcvItems.adapter = RcvAdapter(arrayListOfData)
    }
}







