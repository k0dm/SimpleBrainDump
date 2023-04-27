package com.example.braindump

import android.content.Context
import android.content.Context.MODE_PRIVATE
import java.security.Key

interface DataSource {
    fun saveText( text: String)

    fun getText():String

    class CacheDataSource(context: Context) : DataSource {
        private val sharedPreferences = context.getSharedPreferences("text", MODE_PRIVATE)

        override fun saveText( text: String) {
            sharedPreferences.edit().putString(KEY, text).apply()
        }

        override fun getText() :String =
            sharedPreferences.getString(KEY, "").toString()


        companion object {
            private const val KEY = "textKey"
        }

    }
}
