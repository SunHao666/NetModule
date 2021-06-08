package com.example.netmodule.service

import com.example.netmodule.RetrofitFactory
import com.example.netmodule.api.UserApiService
import com.example.netmodule.base.BaseObserver
import com.example.netmodule.base.BaseRep
import com.example.netmodule.bean.LoginBean
import com.example.netmodule.common.covert
import com.example.netmodule.common.execute
import com.example.netmodule.repository.UserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * create by Admin in 2021/6/8
 *
 * @Description : 用户模块接口请求
 **/
class UserServiceImpl : UserService {
    val userResposity by lazy { UserRepository() }
    override fun login(userName: String, pwd: String) {
        println("loading开始")
        userResposity.login(userName, pwd).covert()
            .execute(object : BaseObserver<LoginBean>() {
                override fun onNext(t: LoginBean?) {
                    super.onNext(t)
                    println("登录成功")
                }
            })
    }

    override fun register(userName: String, pwd: String) {

    }
}