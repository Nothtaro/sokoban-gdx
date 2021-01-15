package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.TexturePreloader
import io.github.nothtaro.sokoban.stage.tile.TileType

class Wall(override var x:Int, override var y:Int) : Entity {
    override fun getEntityType() : EntityType {
        return EntityType.WALL
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(TexturePreloader.loadTile(TileType.WALL),(32 * x).toFloat(),(32 * y).toFloat(),32f,32f)
    }

    override fun update(delta:Float) { }

    override fun dispose() { }
}