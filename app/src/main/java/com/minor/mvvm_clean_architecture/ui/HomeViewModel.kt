package com.minor.mvvm_clean_architecture.ui

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minor.mvvm_clean_architecture.domain.common.AppDispatchers
import com.minor.mvvm_clean_architecture.domain.entities.UserEntity
import com.minor.mvvm_clean_architecture.domain.usecases.GetTopUsersUseCase
import com.minor.mvvm_clean_architecture.domain.usecases.base.UseCaseParams
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getTopUsersUseCase: GetTopUsersUseCase,
    private val appDispatchers: AppDispatchers
) :  ViewModel() {

    val usersLiveData: MutableLiveData<List<UserEntity>> = MutableLiveData()

    var isLoading: ObservableBoolean = ObservableBoolean()

    fun userRefreshesItems() {
        isLoading.set(true)
        loadUsers()
    }

    fun loadUsers() = viewModelScope.launch(appDispatchers.main) {
        val getUserResult = getTopUsersUseCase.execute(UseCaseParams.Empty)

        isLoading.set(false)
        getUserResult.either({ failure ->
            usersLiveData.value = null
        }, { userEntities ->
            usersLiveData.value = userEntities
        })
    }
}