package com.example.juegofinal2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

// Definición de la clase GameView, que extiende la clase View de Android
class GameView(var c: Context, var gameTask: Tarea) : View(c) {
    // Declaración de variables privadas
    private var myPaint: Paint? = null
    private var speed = 1
    private var time = 0
    private var score = 0
    private var myCarPosition = 0
    private val otherCars = ArrayList<HashMap<String, Any>>()

    // Variables para el ancho y alto de la vista
    var viewWidth = 0
    var viewHeight = 0

    // Bloque de inicialización que configura la pintura
    init {
        myPaint = Paint()
    }

    // Sobrescribe el método onDraw para dibujar en el Canvas
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        viewWidth = this.measuredWidth
        viewHeight = this.measuredHeight

        // Añade nuevos autos en intervalos de tiempo específicos
        if (time % 700 < 10 + speed) {
            val map = HashMap<String, Any>()
            map["lane"] = (0..2).random()
            map["startTime"] = time
            otherCars.add(map)
        }
        time += 10 + speed
        val carWidth = viewWidth / 5
        val carHeight = carWidth + 10
        myPaint!!.style = Paint.Style.FILL
        val d = resources.getDrawable(R.drawable.carro_1, null)
        d.setBounds(
            myCarPosition * viewWidth / 3 + viewWidth / 15 + 25,
            viewHeight - 2 - carHeight,
            myCarPosition * viewWidth / 3 + viewWidth / 15 + carWidth - 25,
            viewHeight - 2
        )
        d.draw(canvas!!)
        myPaint!!.color = Color.GREEN
        var highScore = 0
        // Revisar la posición de las imágenes a ver si está bien (Elias)
        for (i in otherCars.indices) {
            try {
                val carX = otherCars[i]["lane"] as Int * viewWidth / 3 + viewWidth / 15
                val carY = time - otherCars[i]["startTime"] as Int
                val d2 = resources.getDrawable(R.drawable.carro_2, null)

                d2.setBounds(
                    carX + 25, carY - carHeight, carX + carWidth - 25, carY
                )
                d2.draw(canvas)
                // Verifica si el auto se encuentra en la misma posición que el jugador
                if (otherCars[i]["lane"] as Int == myCarPosition) {
                    if (carY > viewHeight - 2 - carHeight && carY < viewHeight - 2) {
                        // Llama al método Cierre de la interfaz Tarea
                        gameTask.Cierre(score)
                    }
                }
                // Elimina autos que han pasado fuera de la vista y actualiza el puntaje
                if (carY > viewHeight + carHeight) {
                    otherCars.removeAt(i)
                    score++
                    speed = 1 + Math.abs(score / 8)
                    if (score > highScore) {
                        highScore = score
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        // Dibuja el puntaje y la velocidad en la pantalla
        myPaint!!.color = Color.WHITE
        myPaint!!.textSize = 40f
        canvas.drawText("Score: $score", 80f, 80f, myPaint!!)
        canvas.drawText("Speed: $speed", 380f, 80f, myPaint!!)
        invalidate() // Invoca una llamada para volver a dibujar la vista
    }

    // Sobrescribe el método onTouchEvent para manejar los eventos de toque en la pantalla
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                val x1 = event.x
                if (x1 < viewWidth / 2) {
                    if (myCarPosition > 0) {
                        myCarPosition--
                    }
                }
                if (x1 > viewWidth / 2) {
                    if (myCarPosition < 2) { // Cambié de myCarPosition > 2 a myCarPosition < 2
                        myCarPosition++
                    }
                }
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                // Aquí puedes agregar acciones adicionales si es necesario
            }
        }
        return true // Indica que el evento ha sido manejado
    }
}
