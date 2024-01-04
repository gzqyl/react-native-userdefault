package com.github.gzqyl.rnuserdefault

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.facebook.react.bridge.ReactApplicationContext
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "mlkit_langcode_setting")

class RNUserDataStore(private val reactContext: ReactApplicationContext) {

    val langKey = stringPreferencesKey("mlkit_lang_code")

    fun getMLkitLang(): String {

        return runBlocking{

            reactContext.applicationContext.dataStore.data.firstOrNull()?.get(langKey) ?: "en"

        }

    }

    fun setMLkitLang(langCode: String) {

        runBlocking{

            reactContext.applicationContext.dataStore.edit { preferences ->
                preferences[langKey] = langCode
            }

        }

    }
    
    fun isLangSetted(): Boolean {

        return runBlocking{

            val langCode = reactContext.applicationContext.dataStore.data.firstOrNull()?.get(langKey)

            langCode != null

        }

    }

}