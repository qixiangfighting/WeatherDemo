package com.test.foundationlib.data.net

import com.test.foundationlib.common.BaseConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Retrofit Factory
 *
 */
class RetrofitFactory private constructor(){

    /**
     * singleton
     *
     */
    companion object {
        val instance:RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val interceptor:Interceptor
    private val retrofit:Retrofit

    init {
        /**
         * Using the interceptor to handle header
         *
         */
        interceptor = Interceptor {
            chain -> val request = chain.request()
                .newBuilder()
                .addHeader("Content_Type","application/json")
                .addHeader("charset","UTF-8")
                .build()

            chain.proceed(request)
        }

        retrofit = Retrofit.Builder()
                .baseUrl(BaseConstant.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initClient())
                .build()
    }


    private fun initClient():OkHttpClient{
        return OkHttpClient.Builder()
                .addInterceptor(initLogInterceptor())
                .addInterceptor(interceptor)
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build()
    }


    /**
     * It is the log interceptor
     *
     */
    private fun initLogInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }


    /**
     * Create the corresponding API
     *
     */
    fun <T> create(service:Class<T>):T{
        return retrofit.create(service)
    }
}
