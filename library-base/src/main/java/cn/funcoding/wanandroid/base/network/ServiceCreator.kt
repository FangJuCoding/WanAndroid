package cn.funcoding.wanandroid.base.network

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import cn.funcoding.wanandroid.base.BuildConfig
import cn.funcoding.wanandroid.base.base.AppContext
import cn.funcoding.wanandroid.base.ext.otherwise
import cn.funcoding.wanandroid.base.ext.yes
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Retrofit入口
 */
object ServiceCreator {
    private const val BASE_URL = "https://www.wanandroid.com"

    private fun createHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        return BuildConfig.DEBUG.yes {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        }.otherwise {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
        }
    }

    private val cookieJar =
        PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(AppContext))

    fun clearCookie() = cookieJar.clear()

    private val okHttpClient = OkHttpClient.Builder()
        .callTimeout(20, TimeUnit.SECONDS)
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(createHttpLoggingInterceptor())
        .cookieJar(cookieJar)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)
}