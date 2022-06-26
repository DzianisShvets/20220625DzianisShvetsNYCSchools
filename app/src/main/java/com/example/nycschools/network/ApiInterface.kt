package com.example.nycschools.network

import com.example.nycschools.home.data.PostModel
import com.example.nycschools.home.data.SchoolInfoModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

//    @GET("posts")
//    fun fetchAllPosts(): Call<List<PostModel>>

    @GET("s3k6-pzi2.json")
    fun fetchAllPosts(): Call<List<PostModel>>

//    @GET("f9bf-2cp4.json")
//    fun fetchSchoolInfo(): Call<SchoolInfoModel>

    @GET("f9bf-2cp4.json")
    fun fetchSchoolInfo(@Query("dbn") dbn:String): Call<List<SchoolInfoModel>>

//    @POST("posts")
//    fun createPost(@Body postModel: PostModel):Call<PostModel>
//
//    @DELETE("posts/{id}")
//    fun deletePost(@Path("id") id:Int):Call<String>

}