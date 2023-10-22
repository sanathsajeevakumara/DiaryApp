package com.sanathcoding.diaryapp.presentation.screen.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanathcoding.diaryapp.data.repository.Diaries
import com.sanathcoding.diaryapp.data.repository.MongoDB
import com.sanathcoding.diaryapp.util.RequestState
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    var diaries: MutableState<Diaries> = mutableStateOf(RequestState.Idle)

    init {
        observeAllDiaries()
    }

    private fun observeAllDiaries() {
        viewModelScope.launch {
            MongoDB.getAllDiaries().collect { result ->
                diaries.value = result
            }
        }
    }
}