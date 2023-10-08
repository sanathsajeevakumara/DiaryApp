package com.sanathcoding.diaryapp.presentation.screen.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanathcoding.diaryapp.util.Constant.APP_ID
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.GoogleAuthType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthenticationViewModel: ViewModel() {

    var loadingState = mutableStateOf(false)
        private set

    var authenticated = mutableStateOf(false)
        private set

    fun updateLoading(loading: Boolean) { loadingState.value = loading }

    fun signInWithMongoAtlas(
        tokenId: String,
        authResult: () -> Unit,
        onError: (Exception) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    App.create(APP_ID).login(
                        Credentials.jwt(tokenId)
                    ).loggedIn
                }
                withContext(Dispatchers.Main) {
                    if (result) {
                        authResult()
                        delay(600)
                        authenticated.value = true
                    } else onError(Exception("Authentication Failed!"))
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError(e)
                }
            }
        }
    }

}