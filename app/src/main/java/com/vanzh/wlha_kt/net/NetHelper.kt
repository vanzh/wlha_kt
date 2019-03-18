package com.vanzh.wlha_kt.net

import com.vanzh.dialogdemo.net.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.X509Certificate
import com.vanzh.wlha_kt.net.NetHelper.TrustAllManager
import java.security.SecureRandom
import java.security.cert.CertificateException
import javax.net.ssl.*


/**
 * created by zp on 2019/3/18.
 */

class NetHelper {

    val BASE_URL = "https://api.j1home.com/api/"

    companion object {
        val instance: ApiService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            val netHelper = NetHelper()
            netHelper.initClient()
        }
    }

    fun initClient(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkhttp())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    private fun getOkhttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .addInterceptor(LogInterceptor())
            .sslSocketFactory(createSSLSocketFactory(),TrustAllManager())
            .build()
    }

    private fun createSSLSocketFactory(): SSLSocketFactory? {

        var sSLSocketFactory: SSLSocketFactory? = null

        try {
            val sc = SSLContext.getInstance("TLS")
            sc.init(
                null, arrayOf<TrustManager>(TrustAllManager()),
                SecureRandom()
            )
            sSLSocketFactory = sc.getSocketFactory()
        } catch (e: Exception) {
        }

        return sSLSocketFactory
    }

    class TrustAllManager : X509TrustManager {
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            throw  CertificateException()
        }

        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            throw CertificateException()
        }

        override fun getAcceptedIssuers(): Array<X509Certificate>? {
            return null
        }
    }

    private class TrustAllHostnameVerifier : HostnameVerifier {
        override fun verify(hostname: String, session: SSLSession): Boolean {
            return true
        }
    }
}