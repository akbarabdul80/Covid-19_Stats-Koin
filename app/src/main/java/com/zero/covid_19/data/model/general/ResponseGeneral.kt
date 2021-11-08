package com.zero.covid_19.data.model.general

import com.google.gson.annotations.SerializedName

data class ResponseGeneral(
    @SerializedName("sukses") val success: Int?,
    @SerializedName("data") val data: DataGeneral?
)
