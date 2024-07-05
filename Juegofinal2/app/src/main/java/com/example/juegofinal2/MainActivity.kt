package com.example.juegofinal2

import android.os.Bundle
import android.view.View
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
            mGameView.setBackgroundResource(R.drawable.fondo)
            base_Layout.addView(mGameView)
            inicio_boton.visibility = View.GONE
            puntaje.visibility = View.GONE
        }
    }

    override fun Cierre(mScore: Int) {
        puntaje.text = "Puntaje: $mScore"
        base_Layout.removeView(mGameView)
        inicio_boton.visibility = View.VISIBLE
        puntaje.visibility = View.VISIBLE
    }
}
