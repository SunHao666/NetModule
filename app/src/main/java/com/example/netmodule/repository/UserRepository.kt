package com.example.netmodule.repository

import com.example.netmodule.RetrofitFactory
import com.example.netmodule.api.UserApiService
import com.example.netmodule.base.BaseRep
import com.example.netmodule.bean.LoginBean
import io.reactivex.rxjava3.core.Observable

/**
 * create by Admin in 2021/6/8
 *
 * @Description : 实际网络请求类
 **/
class UserRepository {

    fun login(userName: String, pwd: String):Observable<BaseRep<LoginBean>>{
        return RetrofitFactory.instance.create(UserApiService::class.java).login(userName, pwd)
    }

}