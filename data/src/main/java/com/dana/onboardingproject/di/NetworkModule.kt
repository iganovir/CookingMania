package com.dana.onboardingproject.di

import android.content.Context
import com.dana.onboardingproject.data.BuildConfig
import com.dana.onboardingproject.network.Constant
import com.dana.onboardingproject.network.RecipeAPI
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

/**
 * @author Iga Noviyanti created on 18/04/22 at 13.07
 */
@Module
object NetworkModule {
    @Provides
    @Singleton
    fun provideBaseURL() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideCache(context: Context): Cache =
        Cache(context.cacheDir, cacheSize.toLong())

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(
        cache : Cache
    ): OkHttpClient.Builder {
        val logging = HttpLoggingInterceptor().apply{
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
        val okhttpClient = OkHttpClient.Builder()
            .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS)
            .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS)
            .readTimeout(DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS)
            .addInterceptor(logging)
            .addInterceptor {
                val original = it.request()
                val requestBuilder = original.newBuilder()
                    .addHeader(
                        Constant.Network.Header.APIHOST,
                        Constant.Network.Header.APIHOSTVALUE
                    )
                    .addHeader(Constant.Network.Header.APIKEY, Constant.Network.Header.APIKEYVALUE)
                val request = requestBuilder.build()
                it.proceed(request)
            }
            .cache(cache)

        return okhttpClient
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(
        baseUrl: String
    ): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())

    @Provides
    @Singleton
    fun provideRecipeApi(
        httpClientBuilder: OkHttpClient.Builder,
        retrofitBuilder: Retrofit.Builder
    ): RecipeAPI =
        provideService(RecipeAPI::class.java, httpClientBuilder, retrofitBuilder)

    private fun <S> provideService(
        serviceClass: Class<S>,
        httpClientBuilder: OkHttpClient.Builder,
        retrofitBuilder: Retrofit.Builder
    ): S {
        retrofitBuilder.client(httpClientBuilder.build())
        return retrofitBuilder.build().create(serviceClass)
    }

    private val DEFAULT_TIME_OUT: Long = 30L * 1000
    private val cacheSize = 10 * 1024 * 1024
}