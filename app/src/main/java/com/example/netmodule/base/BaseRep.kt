package com.example.netmodule.base
/**
 * create by Admin in 2021/6/8
 *
 * @Description : 接口返回格式
 **/
data class BaseRep<T>(val data:T,val errorCode:Int,val errorMsg:String)