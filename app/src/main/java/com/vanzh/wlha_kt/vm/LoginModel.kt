package com.vanzh.wlha_kt.vm

import android.util.Log
import com.vanzh.wlha_kt.model.Account
import com.vanzh.wlha_kt.model.TokenInfo
import com.vanzh.wlha_kt.net.NetHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response


/**
 * created by zp on 2019/3/18.
 */

class LoginModel {
    val TAG = "LoginModel"
    var username: String? = "18523048537"
    var userpwd: String? = "111111"
    var account: Account? = null


    fun login() {
        Log.i(TAG, "username: $username, password: $userpwd")
        account = Account()
        account!!.username = username
        account!!.password = userpwd
        NetHelper().initClient().login(account!!)
            //  .compose(handleResult)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t: Response<TokenInfo>? ->
                Log.i(TAG, t?.isSuccessful.toString())

            }, { t: Throwable? ->
                Log.i(TAG, t?.message)

            })
    }

//    fun <T> handleResult(): ObservableTransformer<Response<T>,T>{
//
//        return
//    }
}


