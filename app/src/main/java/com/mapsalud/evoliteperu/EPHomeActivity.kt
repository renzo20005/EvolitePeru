package com.mapsalud.evoliteperu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mapsalud.evoliteperu.databinding.ActivityEpHomeBinding
import com.mapsalud.evoliteperu.databinding.ActivityEpLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class EPHomeActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityEpHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityEpHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://dev.mapsalud.com/clientes/pesqueradiamante/services/public/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                Log.d("exitoso","onResponse:{${response.body()!![0].name}}")
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("falla","onFailures")
            }

        })
        
    }


        private fun showData(users: List<User>){
            mBinding.rvUser.apply {
                layoutManager =  LinearLayoutManager(this@EPHomeActivity)
                adapter = UserAdapter(users)
            }
        }

    }
