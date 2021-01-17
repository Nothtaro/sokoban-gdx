package io.github.nothtaro.sokoban.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import io.github.nothtaro.sokoban.Sokoban

fun main(args:Array<String>) {
    val config = LwjglApplicationConfiguration()
    config.width = 800; config.height = 800
    config.resizable = false
    LwjglApplication(Sokoban(), config)
}