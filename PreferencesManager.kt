package com.example.practica05.data

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(
            "user_preferences",
            Context.MODE_PRIVATE
        )

    companion object {
        private const val KEY_NOMBRE = "nombre"
        private const val KEY_MODO_OSCURO = "modo_oscuro"
        private const val KEY_NOTIFICACIONES = "notificaciones"
    }

    fun guardarNombre(nombre: String) {
        preferences.edit()
            .putString(KEY_NOMBRE, nombre)
            .apply()
    }

    fun obtenerNombre(): String {
        return preferences.getString(KEY_NOMBRE, "") ?: ""
    }

    fun guardarModoOscuro(activo: Boolean) {
        preferences.edit()
            .putBoolean(KEY_MODO_OSCURO, activo)
            .apply()
    }

    fun obtenerModoOscuro(): Boolean {
        return preferences.getBoolean(KEY_MODO_OSCURO, false)
    }

    fun guardarNotificaciones(activas: Boolean) {
        preferences.edit()
            .putBoolean(KEY_NOTIFICACIONES, activas)
            .apply()
    }

    fun obtenerNotificaciones(): Boolean {
        return preferences.getBoolean(KEY_NOTIFICACIONES, true)
    }
}
