package com.example.udemyfirebase.viewModels

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.udemyfirebase.Greeting
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainViewModel {

    private var saludo = MutableLiveData("false") // eso se puede cambiar desde fuera del viewModel

    fun saludo(): LiveData<String> = saludo  // al meterla en la funcion no la pueden


}


