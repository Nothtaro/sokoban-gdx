package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.state.Direction
import io.github.nothtaro.sokoban.util.Point

interface Entity {
    var position: Point
    var textureSize: Int
    var direction: Direction

    fun translate(x:Int, y:Int) {
        this.position.x += x; this.position.y += y
    }

    fun getEntityType() : EntityType

    fun render(batch: SpriteBatch)

    fun update(delta: Float)

    fun dispose()
}