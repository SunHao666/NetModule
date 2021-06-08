package com.example.netmodule.common

import com.example.netmodule.base.BaseException
import com.example.netmodule.base.BaseObserver
import com.example.netmodule.base.BaseRep
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.Exception
import java.util.*

/*
*  Observable扩展
*/
fun <T> Observable<T>.execute(observer:BaseObserver<T>){
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)
}

/*
*  返回数据转换
*/
fun <T> Observable<BaseRep<T>>.covert():Observable<T>{
    return this.flatMap(object :Function<BaseRep<T>,Observable<T>>{
        override fun apply(t: BaseRep<T>): Observable<T> {
            if(t.errorCode != 0){
                return Observable.error(BaseException(t.errorCode,t.errorMsg))
            }else{
                return Observable.just(t.data)
            }
        }
    })
}