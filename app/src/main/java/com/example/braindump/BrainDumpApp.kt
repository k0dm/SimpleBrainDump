package com.example.braindump

import android.app.Application
import androidx.lifecycle.ViewModel

class BrainDumpApp : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(Repository.Base())
    }
}