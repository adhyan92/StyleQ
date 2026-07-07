package com.example.styleq.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.styleq.data.UserProfile

class ProfileViewModel : ViewModel() {

        private val _profile = mutableStateOf(UserProfile())
        val profile: State<UserProfile> = _profile

        fun saveProfile(
            fullName: String,
            gender: String,
            height: String,
            weight: String,
            age: String,
            location: String,
            bodyShape: String,
            skinTone: String
        ) {
            _profile.value = UserProfile(
                fullName = fullName,
                gender = gender,
                height = height,
                weight = weight,
                age = age,
                location = location,
                bodyShape = bodyShape,
                skinTone = skinTone
            )
        }
    }
