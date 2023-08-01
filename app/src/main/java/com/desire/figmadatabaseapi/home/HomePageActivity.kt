package com.desire.figmadatabaseapi.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.desire.figmadatabaseapi.api.User
import com.desire.figmadatabaseapi.databinding.ActivityHomePageBinding
import com.desire.figmadatabaseapi.main.MainActivity
import com.desire.figmadatabaseapi.response.DeleteProductResponce
import com.desire.figmadatabaseapi.retrofit.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    private lateinit var userAdapter: UserAdapter
    var arrayList = ArrayList<User>()

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

    private fun getData() {
        var call: Call<ArrayList<User>> = Retrofit.api.getData()
        call.enqueue(object : Callback<ArrayList<User>> {

            override fun onResponse(
                call: Call<ArrayList<User>>,
                response: Response<ArrayList<User>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        arrayList.addAll(it)
                     //   arrayList = response.body()!!
                        userAdapter = UserAdapter(arrayList)
                        binding.rcvItems.adapter = userAdapter
                        binding.rcvItems.layoutManager =
                            GridLayoutManager(this@HomePageActivity, 2)

                        userAdapter.onItemClick = { item -> Log.i("test","${item.id}")
                            onClickDeleteBtn(item.id)

                            var index = userAdapter.arrayList.indexOfFirst { it.id == item.id }
                            userAdapter.deleteItem(index)
                        }

                    }
                }
            }
            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable?) {
                Log.i("test", "Fail")
            }
        })
    }


    private fun onClickDeleteBtn(id: Int){
        var call : Call<Unit> = Retrofit.api.deleteProduct(id)
        call.enqueue(object : Callback<Unit>{

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful){
                    Toast.makeText(this@HomePageActivity,"Deleted",Toast.LENGTH_SHORT).show()
                } else
                {
                    Toast.makeText(this@HomePageActivity,"Not Deleted",Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Toast.makeText(this@HomePageActivity,"Not Deleted",Toast.LENGTH_SHORT).show()

            }
        })
    }
    private fun ivBack() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}





