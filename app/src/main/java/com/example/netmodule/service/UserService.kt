package com.example.netmodule.service

interface UserService {
    fun login(userName:String,pwd:String)
    fun register(userName:String,pwd:String)
}