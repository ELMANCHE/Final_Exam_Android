package com.example.juegofinal2

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Prueba instrumentada, que se ejecutará en un dispositivo Android.
 *
 * Consulta la [documentación sobre pruebas](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    // Método de prueba para verificar el contexto de la aplicación
    @Test
    fun useAppContext() {
        // Obtiene el contexto de la aplicación en prueba
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        // Verifica que el nombre del paquete sea el esperado
        assertEquals("com.example.juegofinal2", appContext.packageName)
    }
}
