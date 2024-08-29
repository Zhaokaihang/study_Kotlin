package com.example.spsample.retrofit

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface CommonService {
    @GET("OneDayEnglish/")
    fun getTopMovie(): Observable<Bean>

}