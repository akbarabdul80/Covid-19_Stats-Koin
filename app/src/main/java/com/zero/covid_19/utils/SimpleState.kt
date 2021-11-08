package com.zero.covid_19.utils

sealed class SimpleState {
    object Loading : SimpleState()
    data class Result<T>(val data: T) : SimpleState()
    data class Error(val error: Throwable) : SimpleState()
}
