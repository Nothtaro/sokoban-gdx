package io.github.nothtaro.sokoban.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import io.github.nothtaro.sokoban.Sokoban

fun main(args:Array<String>) {
    val config = LwjglApplicationConfiguration()
    config.width = 1024; config.height = 1024
    LwjglApplication(Sokoban(), config)
}