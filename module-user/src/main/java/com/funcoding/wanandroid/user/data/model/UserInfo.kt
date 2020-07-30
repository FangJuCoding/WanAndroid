package com.funcoding.wanandroid.user.data.model

data class UserInfo(
    val admin: Boolean,
    val chapterTops: List<Any>,
    val coinCount: Int,
    val collectIds: MutableList<Int>,
    val email: String,
    val icon: String,
    val id: Long,
    val nickname: String,
    val password: String,
    val publicName: String,
    val token: String,
    val type: Int,
    val username: String
)

