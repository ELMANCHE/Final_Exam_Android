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

// MainActivity es la actividad principal de la aplicación y también implementa la interfaz Tarea
class MainActivity : AppCompatActivity(), Tarea {
    // Declaración de variables de la vista
    lateinit var base_Layout: LinearLayout
    lateinit var inicio_boton: Button
    lateinit var mGameView: GameView
    lateinit var puntaje: TextView

    // Método que se ejecuta cuando la actividad es creada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la actividad con el layout activity_main
        setContentView(R.layout.activity_main)

        // Inicializa las variables de la vista con sus respectivos elementos en el layout
        inicio_boton = findViewById(R.id.startBtn)
        base_Layout = findViewById(R.id.rootLayout)
        puntaje = findViewById(R.id.score)

        // Crea una instancia de GameView
        mGameView = GameView(this, this)

        // Configura el botón de inicio para que cuando se haga clic, se inicie el juego
        inicio_boton.setOnClickListener() {
            // Establece el fondo del juego
            mGameView.setBackgroundResource(R.drawable.fondo)
            // Añade la vista del juego al layout principal
            base_Layout.addView(mGameView)
            // Oculta el botón de inicio y el puntaje
            inicio_boton.visibility = View.GONE
            puntaje.visibility = View.GONE
        }
    }

    // Implementación del método Cierre de la interfaz Tarea
    override fun Cierre(mScore: Int) {
        // Muestra el puntaje final
        puntaje.text = "Puntaje: $mScore"
        // Elimina la vista del juego del layout principal
        base_Layout.removeView(mGameView)
        // Muestra el botón de inicio y el puntaje
        inicio_boton.visibility = View.VISIBLE
        puntaje.visibility = View.VISIBLE
    }
}
