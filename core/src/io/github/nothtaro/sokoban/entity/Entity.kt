package io.github.nothtaro.sokoban.entity

import io.github.nothtaro.sokoban.util.Point


interface Entity {
    fun translate(x:Int, y:Int)

    fun getPosition() : Point

    fun getEntityType() : EntityType

    fun setPosition(x: Int, y: Int)

    fun render()

    fun dispose()
}