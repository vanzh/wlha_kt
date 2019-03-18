package com.vanzh.dialogdemo.net

import com.vanzh.wlha_kt.model.Account
import com.vanzh.wlha_kt.model.TokenInfo
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * 网络接口
 *
 * @author yk
 * create at 2017/2/13 13:09
 * email : yk_developer@163.com
 */
interface ApiService {
    /**
     * 用户登录
     */
    @POST("Accounts/login")
    fun login(@Body account: Account): Single<Response<TokenInfo>>


}
