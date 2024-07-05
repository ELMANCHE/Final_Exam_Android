package com.example.juegofinal2

// Definición de la interfaz Tarea
interface Tarea {
    // Declaración del método abstracto Cierre, que recibe un entero mScore como parámetro
    // Este método debe ser implementado por cualquier clase que implemente esta interfaz
    // Su propósito es manejar el evento de cierre del juego, posiblemente actualizando el puntaje final
    fun Cierre(mScore: Int)
}
