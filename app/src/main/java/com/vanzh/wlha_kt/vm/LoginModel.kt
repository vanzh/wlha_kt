package com.vanzh.wlha_kt.vm

import android.util.Log
import com.google.gson.Gson
import com.vanzh.wlha_kt.model.Account
import com.vanzh.wlha_kt.model.TokenInfo
import com.vanzh.wlha_kt.net.NetHelper
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response


/**
 * created by zp on 2019/3/18.
 */

class LoginModel {
    val TAG = "LoginModel"
    var username: String? = "17623894818"
    var userpwd: String? = "123456"
    var account: Account? = null


    fun login() {
        Log.i(TAG, "username: $username, password: $userpwd")
        account = Account()
        account!!.username = username
        account!!.password = userpwd
        NetHelper.getInstance.login(account!!)
                .compose(handleResult())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<TokenInfo> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: TokenInfo) {
                        Log.i(TAG, Gson().toJson(t))
                    }

                    override fun onError(e: Throwable) {
                        Log.i(TAG, e.message)
                    }

                    override fun onComplete() {

                    }


                })
    }

    fun <T> handleResult(): ObservableTransformer<Response<T>, T> {
        return ObservableTransformer<Response<T>, T> { upstream ->
            upstream.flatMap {
                if (it.isSuccessful) {
                    return@flatMap Observable.create<T> { subscriber ->
                        try {
                            subscriber.onNext(it.body()!!)
                            subscriber.onComplete()
                        } catch (e: Exception) {
                            subscriber.onError(e)
                        }
                    }
                }
                return@flatMap Observable.empty<T>()
            }
        }
    }

    private fun <T> createData(t: T): Observable<T> {
        return Observable.create { subscriber ->
            try {
                subscriber.onNext(t)
                subscriber.onComplete()
            } catch (e: Exception) {
                subscriber.onError(e)
            }
        }
    }
}


