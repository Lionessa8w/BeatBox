package com.bignerdranch.android.beatbox

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import java.util.Objects
import javax.security.auth.Subject

class SoundViewModelTest {
    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel

    @Before
    fun setUp() {
        sound = Sound("assetPath")
        subject = SoundViewModel()
        subject.sound = sound
    }

    @Test
    fun exposesSoundNameAsTitle() {
        assertEquals(subject.title, sound.name)

    }
}