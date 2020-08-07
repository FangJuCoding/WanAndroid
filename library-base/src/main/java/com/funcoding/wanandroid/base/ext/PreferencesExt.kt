package com.funcoding.wanandroid.base.ext

import android.content.Context
import java.lang.IllegalArgumentException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class Preferences<T>(
    val context: Context,
    val name: String,
    val defValue: T,
    val prefName: String = "default"
) : ReadWriteProperty<Any?, T> {
    private val pref by lazy {
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getPreference(findProperName(property))
    }

    private fun getPreference(name: String): T {
        return when (defValue) {
            is Int -> pref.getInt(name, defValue)
            is Float -> pref.getFloat(name, defValue)
            is Long -> pref.getLong(name, defValue)
            is Boolean -> pref.getBoolean(name, defValue)
            is String -> pref.getString(name, defValue)
            else ->
                throw IllegalArgumentException("Unsupported Type")
        } as T
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(findProperName(property), value)
    }

    private fun putPreference(name: String, value: T) {
        with(pref.edit()) {
            when (value) {
                is Int -> putInt(name, value)
                is Float -> putFloat(name, value)
                is Long -> putLong(name, value)
                is Boolean -> putBoolean(name, value)
                is String -> putString(name, value)
                else ->
                    throw IllegalArgumentException("Unsupported Type")
            }
            apply()
        }
    }

    private fun findProperName(property: KProperty<*>): String = if (name.isEmpty()) {
        property.name
    } else {
        name
    }
}