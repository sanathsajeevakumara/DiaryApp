package com.sanathcoding.diaryapp.presentation.screen.write

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanathcoding.diaryapp.data.repository.MongoDB
import com.sanathcoding.diaryapp.model.Diary
import com.sanathcoding.diaryapp.model.Mood
import com.sanathcoding.diaryapp.util.Constant.WRITE_SCREEN_ARGUMENT_KEY
import com.sanathcoding.diaryapp.util.RequestState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.mongodb.kbson.ObjectId

class WriteViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var uiState by mutableStateOf(UiState())
        private set

    init {
        getDiaryIdArgument()
        fetchSelectedDiaryData()
    }

    private fun getDiaryIdArgument() {
        uiState = UiState().copy(
            selectedDiaryId = savedStateHandle.get<String>(
                key = WRITE_SCREEN_ARGUMENT_KEY
            )
        )
    }

    private fun fetchSelectedDiaryData() {
        uiState.let {
            viewModelScope.launch(Dispatchers.Main) {
                it.selectedDiaryId?.let { diaryId -> ObjectId.invoke(diaryId) }?.let {
                    MongoDB.getSelectedDiary(diaryId = it)
                        .collect { diary ->
                            if (diary is RequestState.Success) {
                                setSelectedDiary(diary = diary.data)
                                setTitle(title = diary.data.title)
                                setDescription(description = diary.data.description)
                                setMood(mood = Mood.valueOf(diary.data.mood))
                            }
                        }
                }
            }
        }
    }

    private fun setSelectedDiary(diary: Diary) { uiState = UiState().copy(selectedDiary = diary) }
    fun setTitle(title: String) { uiState = UiState().copy(title = title) }
    fun setDescription(description: String) { uiState = UiState().copy(description = description) }
    private fun setMood(mood: Mood) { uiState = UiState().copy(mood = mood) }

}