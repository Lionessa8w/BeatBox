package com.bignerdranch.android.beatbox

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class SoundViewModelTest {
    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel
    private lateinit var beatBox: BeatBox


    @Before
    fun setUp() {
        // mock имитация объекта
        beatBox = mock(BeatBox::class.java)
        sound = Sound("assetPath")
        subject = SoundViewModel(beatBox)
        subject.sound = sound
    }

    @Test
    fun exposesSoundNameAsTitle() {
        assertEquals(subject.title, sound.name)

    }

    /**
     * Ваш тест вызывает функцию и проверяет, делает ли она то, что ей сказано: вызывает BeatBox.play(Sound).
     */
    @Test
    fun callsBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked()
        /**
         * Вызовите функцию verify(Object), чтобы убедиться в том, что onButtonClicked() вызывает BeatBox.play(Sound)
         * с объектом Sound, связанным с SoundViewModel.
         * Вызов verify(beatBox) означает: «Я хочу проверить, что для beatBox была вызвана функция».
         */
        verify(beatBox).play(sound)
    }
}