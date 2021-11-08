package com.zero.covid_19.data.model.general

import com.google.gson.annotations.SerializedName

data class DataGeneral(
    @SerializedName("total_cases") val total_cases: String?,
    @SerializedName("recovery_cases") val recovery_cases: String?,
    @SerializedName("death_cases") val death_cases: Int?,
    @SerializedName("last_update") val last_update: String?,
    @SerializedName("currently_infected") val currently_infected: String?,
    @SerializedName("cases_with_outcome") val cases_with_outcome: String?,
    @SerializedName("mild_condition_active_cases") val mild_condition_active_cases: String?,
    @SerializedName("critical_condition_active_cases") val critical_condition_active_cases: String?,
    @SerializedName("recovered_closed_cases") val recovered_closed_cases: String?,
    @SerializedName("death_closed_cases") val death_closed_cases: String?,
)
