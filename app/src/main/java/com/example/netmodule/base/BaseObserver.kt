package com.example.netmodule.base

import com.example.netmodule.bean.LoginBean
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlin.math.log

/**
 * create by Admin in 2021/6/8
 *
 * @Description : 返回数据统一处理
 **/
open class BaseObserver<T> : Observer<T> {
    override fun onSubscribe(d: Disposable?) {

    }

    override fun onNext(t: T?) {
    }

    override fun onError(e: Throwable?) {
        if(e is BaseException){
            println(e.errorMsg)
        }
        println("loading结束")
    }

    override fun onComplete() {
        println("loading结束")
    }
}