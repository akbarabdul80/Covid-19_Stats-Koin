package com.zero.covid_19.data.api

import com.zero.covid_19.data.model.general.ResponseGeneral
import io.reactivex.Single
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("v1/cases/general-stats")
    fun getGeneral(): Single<ResponseGeneral>
}