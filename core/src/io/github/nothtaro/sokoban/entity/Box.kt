package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.TexturePreloader
import io.github.nothtaro.sokoban.stage.tile.TileType
import io.github.nothtaro.sokoban.util.Point

class Box(private var x:Int, private var y:Int) : Entity {
    override fun getPosition() = Point(x, y)

    override fun getEntityType() : EntityType {
        return EntityType.BOX
    }

    override fun setPosition(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    override fun translate(x: Int, y: Int) {
        this.x += x
        this.y += y
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(TexturePreloader.loadTile(TileType.BOX),(32 * x).toFloat(),(32 * y).toFloat(),32f,32f)
    }

    override fun update(delta: Float) {
    }

    override fun dispose() {
    }
}