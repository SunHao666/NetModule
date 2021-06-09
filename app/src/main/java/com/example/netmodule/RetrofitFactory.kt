
package com.example.netmodule

import android.os.Environment
import com.example.netmodule.interceptor.NetCacheInterceptor
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


/**
 * create by Admin in 2021/6/8
 *
 * @Description : retrofit封装
 **/
class RetrofitFactory {
    private lateinit var retrofit:Retrofit
    companion object{
        //单例
        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitFactory()
        }
    }

    /**
     * 组装retrofit对象
     */
    init {
        retrofit = Retrofit.Builder()
            .baseUrl(NetContants.BASE_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    /**
     * 组装client
     */
    private fun getClient(): OkHttpClient {
        val file = File(Environment.getExternalStorageDirectory(),"cache")
        val cacheSize = 10*1024 * 1024L

        return OkHttpClient.Builder()
            .cache(Cache(file,cacheSize))
            .writeTimeout(10,TimeUnit.SECONDS)
            .readTimeout(10,TimeUnit.SECONDS)
            .connectTimeout(10,TimeUnit.SECONDS)
            .addNetworkInterceptor(NetCacheInterceptor())
            .addInterceptor(getLogInterceptor())
            .build()

    }

    /**
     * log 拦截器
     */
    private fun getLogInterceptor(): Interceptor {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logInterceptor
    }

    /**
     * service
     */
    fun <T> create(service:Class<T>):T{
        return retrofit.create(service)
    }

}