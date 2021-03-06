package com.tarlad.client.di

import com.tarlad.client.repos.MainRepo
import com.tarlad.client.repos.impl.MainRepoImpl
import com.tarlad.client.ui.viewLayers.main.MainActivity
import com.tarlad.client.ui.viewLayers.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.ScopeID
import org.koin.dsl.module

val mainModule = module {
    scope<MainActivity> {
        scoped<MainRepo> { MainRepoImpl(get()) }
    }

    viewModel { (scopeId: ScopeID) ->
        MainViewModel(
            get(),
            getScope(scopeId).get()
        )
    }
}