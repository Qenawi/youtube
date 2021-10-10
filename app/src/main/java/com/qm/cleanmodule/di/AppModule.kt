package com.qm.cleanmodule.di

import com.qm.cleanmodule.BuildConfig
import com.qm.cleanmodule.constants.ConstString
import com.qm.cleanmodule.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

//MARK:- AppModule @Docs
@InstallIn(SingletonComponent::class)
@Module
class AppModule {

  @Singleton
  @Provides
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .apply {
        if (BuildConfig.DEBUG) {
          this.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        readTimeout(120, TimeUnit.SECONDS)
        connectTimeout(120, TimeUnit.SECONDS)
        writeTimeout(120, TimeUnit.SECONDS)
      }
      .build()
  }

  @Singleton
  @Provides
  fun provideApiService(okHttpClient: OkHttpClient): ApiService {
    return Retrofit.Builder()
      .baseUrl(ConstString.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
      .client(okHttpClient)
      .build()
      .create(ApiService::class.java)
  }
}
