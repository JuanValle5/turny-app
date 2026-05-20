package com.app.turny.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

private val Context.dataStore by preferencesDataStore(
    name = "turny_session"
)

class SessionManager(
    private val context: Context
) {

    companion object {

        private val TOKEN_KEY =
            stringPreferencesKey("token")

        private val USER_TYPE_KEY =
            stringPreferencesKey("user_type")

        private val USER_NAME_KEY =
            stringPreferencesKey("user_name")
    }

    // GUARDAR SESIÓN
    suspend fun saveSession(
        token: String,
        userType: String,
        userName: String
    ) {

        context.dataStore.edit { preferences ->

            preferences[TOKEN_KEY] = token

            preferences[USER_TYPE_KEY] = userType

            preferences[USER_NAME_KEY] = userName
        }
    }

    // OBTENER TOKEN
    suspend fun getToken(): String? {

        val preferences =
            context.dataStore.data.first()

        return preferences[TOKEN_KEY]
    }

    // OBTENER TIPO
    suspend fun getUserType(): String? {

        val preferences =
            context.dataStore.data.first()

        return preferences[USER_TYPE_KEY]
    }

    // OBTENER NOMBRE
    suspend fun getUserName(): String? {

        val preferences =
            context.dataStore.data.first()

        return preferences[USER_NAME_KEY]
    }

    // CERRAR SESIÓN
    suspend fun clearSession() {

        context.dataStore.edit { preferences ->

            preferences.clear()
        }
    }
}