package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.Point


interface Entity {
    fun translate(x:Int, y:Int)

    fun getPosition() : Point

    fun getEntityType() : EntityType

    fun setPosition(x: Int, y: Int)

    fun render(batch: SpriteBatch)

    fun update(delta: Float)

    fun dispose()
}