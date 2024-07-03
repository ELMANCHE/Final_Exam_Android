package com.example.juegofinal2

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),Tarea {
    lateinit var base_Layout: LinearLayout
    lateinit var inicio_boton: Button
    lateinit var mGameView : GameView
    lateinit var puntaje: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicio_boton = findViewById(R.id.startBtn)
        base_Layout = findViewById(R.id.rootLayout)
        puntaje = findViewById(R.id.score)
        mGameView = GameView(this,this)

        inicio_boton.setOnClickListener(){
            mG
        }
    }

    override fun Cierre(score: Int) {
        TODO("Not yet implemented")
    }
}
