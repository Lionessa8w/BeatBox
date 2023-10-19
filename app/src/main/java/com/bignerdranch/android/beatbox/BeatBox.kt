package com.bignerdranch.android.beatbox

import android.content.res.AssetManager
import android.util.Log

private const val TAG="BeatBox"
private const val SOUNDS_FOLDER="sample_sounds"

/**
 * AssetManager используется для обращения к активам
 */

class BeatBox (private val assets:AssetManager){

    /**assets.list(SOUNDS_FOLDER) возвращает список имен файлов*/
    fun loadSound(): List<String>{
        return try {
            val soundName=assets.list(SOUNDS_FOLDER)!!
            Log.d(TAG,"Found ${soundName.size} sounds")
            soundName.asList()
        } catch (e:Exception){
            Log.e(TAG, "Could not list assets")
            emptyList()
        }

    }
}