package com.sanathcoding.diaryapp.data.repository

import com.sanathcoding.diaryapp.model.Diary
import com.sanathcoding.diaryapp.util.RequestState
import org.mongodb.kbson.ObjectId
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate


typealias Diaries = RequestState<Map<LocalDate, List<Diary>>>

interface MongoRepository {
    fun configureTheRealm()
    fun getAllDiaries(): Flow<Diaries>
    fun getSelectedDiary(diaryId: ObjectId): Flow<RequestState<Diary>>
}