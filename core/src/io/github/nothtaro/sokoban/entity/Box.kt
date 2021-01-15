package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.TexturePreloader
import io.github.nothtaro.sokoban.stage.tile.TileType

class Box(override var x:Int, override var y:Int) : Entity {
    override fun getEntityType() : EntityType {
        return EntityType.BOX
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(TexturePreloader.loadTile(TileType.BOX),(32 * x).toFloat(),(32 * y).toFloat(),32f,32f)
    }

    override fun update(delta: Float) { }

    override fun dispose() { }
}