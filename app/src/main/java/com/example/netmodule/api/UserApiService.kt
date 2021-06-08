package com.example.netmodule.api

import com.example.netmodule.base.BaseRep
import com.example.netmodule.bean.LoginBean
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * create by Admin in 2021/6/8
 *
 * @Description : retrofit抽象接口
 **/
interface UserApiService {
    //登录接口
    @FormUrlEncoded
    @POST("user/login")
    fun login(@Field("userName") userName: String,
              @Field("password") password: String): Observable<BaseRep<LoginBean>>
}