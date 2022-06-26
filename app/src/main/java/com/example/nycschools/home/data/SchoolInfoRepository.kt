package com.example.nycschools.home.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nycschools.network.ApiClient
import com.example.nycschools.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchoolInfoRepository {

    private var apiInterface:ApiInterface?=null

    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    }

    fun fetchSchoolInfo(dbn: String):LiveData<List<SchoolInfoModel>>{
        val data = MutableLiveData<List<SchoolInfoModel>>()

        apiInterface?.fetchSchoolInfo(dbn)?.enqueue(object : Callback<List<SchoolInfoModel>>{

            override fun onFailure(call: Call<List<SchoolInfoModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<SchoolInfoModel>>,
                response: Response<List<SchoolInfoModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }

            }
        })

        return data

    }


//    fun fetchAllPosts():LiveData<List<PostModel>>{
//        val data = MutableLiveData<List<PostModel>>()
//
//        apiInterface?.fetchAllPosts()?.enqueue(object : Callback<List<PostModel>>{
//
//            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
//                data.value = null
//            }
//
//            override fun onResponse(
//                call: Call<List<PostModel>>,
//                response: Response<List<PostModel>>
//            ) {
//
//                val res = response.body()
//                if (response.code() == 200 &&  res!=null){
//                    data.value = res
//                }else{
//                    data.value = null
//                }
//
//            }
//        })
//
//        return data
//
//    }
//
//    fun createPost(postModel: PostModel):LiveData<PostModel>{
//        val data = MutableLiveData<PostModel>()
//
//        apiInterface?.createPost(postModel)?.enqueue(object : Callback<PostModel>{
//            override fun onFailure(call: Call<PostModel>, t: Throwable) {
//                data.value = null
//            }
//
//            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
//                val res = response.body()
//                if (response.code() == 201 && res!=null){
//                    data.value = res
//                }else{
//                    data.value = null
//                }
//            }
//        })
//
//        return data
//
//    }
//
//    fun deletePost(id:Int):LiveData<Boolean>{
//        val data = MutableLiveData<Boolean>()
//
//        apiInterface?.deletePost(id)?.enqueue(object : Callback<String>{
//            override fun onFailure(call: Call<String>, t: Throwable) {
//                data.value = false
//            }
//
//            override fun onResponse(call: Call<String>, response: Response<String>) {
//                data.value = response.code() == 200
//            }
//        })
//
//        return data
//
//    }

}