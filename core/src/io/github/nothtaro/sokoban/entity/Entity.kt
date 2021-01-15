package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.Point

interface Entity {
    var x: Int; var y: Int

    fun translate(x:Int, y:Int) {
        this.x += x; this.y += y
    }

    fun getPosition() : Point {
        return Point(this.x,this.y)
    }

    fun getEntityType() : EntityType

    fun setPosition(x: Int, y: Int) {
        this.x = x; this.y = y
    }

    fun render(batch: SpriteBatch)

    fun update(delta: Float)

    fun dispose()
}