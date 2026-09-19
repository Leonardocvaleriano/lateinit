package com.leonardocvaleriano.lateinit

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var planet: Planet
    va

    override fun onCreate(savedInstanceState: Bundle?) {

//         I need to instance it here, otherwise app will crash.
//         if i dont want to instance it, i can use a DI library to handle it,
//        planet = Planet()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val planetName = planet.writeRandomPlanetName()
        val textView = findViewById<TextView>(R.id.tv_random_planet)
        val btn = findViewById<Button>(R.id.btn_update_planet)

        btn.setOnClickListener {
            textView.text = planet.writeRandomPlanetName()
        }

        textView.text = planetName

    }
}


class Planet(){

    val planetNames = listOf<String>(
        "Earth",
        "Pluton",
        "Mars"
    )

    fun writeRandomPlanetName(): String{
        return planetNames.random()
    }



}

