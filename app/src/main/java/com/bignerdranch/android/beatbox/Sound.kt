package com.bignerdranch.android.beatbox

//константа расширения файла
private const val WAV = ".wav"

class Sound(val assetPath: String, var soundId: Int? = null) {
    /**Извлекаем имя файла, сплитуя по последнему "/", удаляя префикс .wav*/
    val name = assetPath.split("/").last().removeSuffix(WAV)
}