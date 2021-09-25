package com.example.udemyfirebase

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.udemyfirebase.ui.theme.UdemyFirebaseTheme
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var dato: String = "javi"
        setContent {

            val database = Firebase.database.reference

            val listener = object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    dato = snapshot.getValue(String::class.java).toString()

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }

            val dataRef = database.child("saludo").child("dato")

            dataRef.addValueEventListener(listener)

            Greeting(name = "El valor es: $dataRef")
            


        }
    }
}


@Composable
fun Greeting(name: String) {
    UdemyFirebaseTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Text(text = "Hello $name!")

        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UdemyFirebaseTheme {
        Greeting("Android")
    }
}

