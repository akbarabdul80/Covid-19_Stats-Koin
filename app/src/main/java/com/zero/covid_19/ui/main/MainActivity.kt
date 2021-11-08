package com.zero.covid_19.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.oratakashi.viewbinding.core.tools.toast
import com.zero.covid_19.R
import com.zero.covid_19.data.model.general.ResponseGeneral
import com.zero.covid_19.utils.SimpleState
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObserver()
        viewModel.getGeneral()
    }

    private fun setupObserver() {
        viewModel.stateGeneral.observe(this) { state ->
            state.let {
                when (it) {
                    is SimpleState.Loading -> {
                    }
                    is SimpleState.Result<*> -> {
                        if (it.data is ResponseGeneral) {
                            Log.e("Data", it.data.data!!.toString())
                        }
                    }
                    is SimpleState.Error -> {
                        toast(it.error.message.toString())
                    }
                }
            }

        }
    }
}