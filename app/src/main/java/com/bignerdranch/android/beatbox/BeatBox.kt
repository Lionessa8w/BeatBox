package com.bignerdranch.android.beatbox

import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.SoundPool
import android.util.Log

private const val TAG = "BeatBox"
private const val SOUNDS_FOLDER = "sample_sounds"
private const val MAX_SOUNDS = 5

/**
 * AssetManager используется для обращения к активам
 */

class BeatBox(private val assets: AssetManager) {

    val sounds: List<Sound>
    private val soundPool = SoundPool.Builder()
        .setMaxStreams(MAX_SOUNDS)
        .build()

    init {
        sounds = loadSounds()
    }

    /** воспроизведение звуков*/
    fun play(sound: Sound){
        sound.soundId?.let {
            soundPool.play(it, 1.0f, 1.0f, 1, 0, 1.0f)

        }

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
            /** загружаем весь звук*/
            try {
                load(sound)
                sounds.add(sound)
            } catch (ioe: Exception) {
                Log.e(TAG, "Cound not load sound $fileName", ioe)
            }
        }
        return sounds

    }

    /** функция загрузки звуков*/
    private fun load(sound: Sound) {
        val afd: AssetFileDescriptor = assets.openFd(sound.assetPath)
        val soundId = soundPool.load(afd, 1)
        sound.soundId = soundId

    }
}