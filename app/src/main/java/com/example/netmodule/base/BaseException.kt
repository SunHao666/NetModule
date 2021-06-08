package com.example.netmodule.base

data class BaseException(val errorCode:Int,val errorMsg:String): Throwable() {
}