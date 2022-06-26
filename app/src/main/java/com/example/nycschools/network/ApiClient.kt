package com.example.nycschools.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//    API Key Secret = 1vibzdc5vutz04i5vz06vq5qwabzw0ybho6aprwta08v8u7svz
//    API Key ID = 3yz4cizzz0rgztf9qx617thha

//const val BASEURL = "https://jsonplaceholder.typicode.com/"
const val BASEURL = "https://data.cityofnewyork.us/resource/"
class ApiClient {


    companion object{

        private var retrofit:Retrofit?=null

        fun getApiClient(): Retrofit {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100, TimeUnit.SECONDS)
                .build()
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }

            return retrofit!!
        }
    }

}