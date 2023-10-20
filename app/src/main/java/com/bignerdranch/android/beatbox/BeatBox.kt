package com.bignerdranch.android.beatbox

import android.content.res.AssetManager
import android.util.Log

private const val TAG = "BeatBox"
private const val SOUNDS_FOLDER = "sample_sounds"

/**
 * AssetManager используется для обращения к активам
 */

class BeatBox(private val assets: AssetManager) {

    val sounds: List<Sound>
    init {
        sounds = loadSounds()
    }

    /**assets.list(SOUNDS_FOLDER) возвращает список имен файлов*/
    private fun loadSounds(): List<Sound> {
        val soundName: Array<String>
        try {
            soundName = assets.list(SOUNDS_FOLDER)!!
        } catch (e: Exception) {
            Log.e(TAG, "Could not list assets")
            return emptyList()
        }
        val sounds = mutableListOf<Sound>()
        soundName.forEach { fileName ->
            val assetPath = "$SOUNDS_FOLDER/$fileName"
            val sound = Sound(assetPath)
            sounds.add(sound)
        }
        return sounds

    }
}