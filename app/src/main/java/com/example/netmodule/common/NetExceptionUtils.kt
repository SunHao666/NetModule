package com.example.netmodule.common

import org.json.JSONException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.ParseException

/**
 * create by Admin in 2021/6/9
 *
 * @Description : 异常信息封装
 **/
object NetExceptionUtils {

    fun exceptionHandler(e: Throwable): String {
        var errorMsg = "未知错误"
        when (e) {
            is UnknownHostException -> {
                errorMsg = "网络不可用"
            }
            is SocketTimeoutException -> {
                errorMsg = "请求网络超时"
            }
            is HttpException -> {
                val httpException = e as HttpException
                errorMsg = covertStatusCode(httpException)
            }
            is ParseException,
            is JSONException -> {
                errorMsg = "数据解析错误"
            }
        }
        return errorMsg
    }

    private fun covertStatusCode(httpException: HttpException): String {
        var msg = ""
        when (httpException.code()) {
            in 500 until 600 -> {
                msg = "服务器处理请求错误"
            }
            in 400 until 500 -> {
                msg = "服务器无法处理请求"
            }
            in 300 until 400 -> {
                msg = "请求被重定向到其他界面"
            }
            else -> {
                msg = httpException.message()
            }
        }
        return msg
    }
}