package com.example.netmodule.interceptor

import okhttp3.Interceptor
import okhttp3.Response
/**
 * create by Admin in 2021/6/8
 * 
 * @Description : 配置Cache-Control
 **/
class NetCacheInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        //设置响应的缓存时间为60秒，即设置Cache-Control头，并移除pragma消息头，因为pragma也是控制缓存的一个消息头属性
        val build = chain.proceed(request).newBuilder().removeHeader("pragma")
            .header("Cache-Control", "max-age=5")
            .build()
        return build
    }
}