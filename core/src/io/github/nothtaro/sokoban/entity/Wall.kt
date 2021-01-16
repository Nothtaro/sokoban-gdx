package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.TexturePreloader
import io.github.nothtaro.sokoban.stage.tile.TileType

class Wall(override var x:Int, override var y:Int, override var textureSize: Int) : Entity {
    override fun getEntityType() : EntityType {
        return EntityType.WALL
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(TexturePreloader.loadTile(TileType.WALL),(textureSize * x).toFloat(),(textureSize * y).toFloat(),textureSize.toFloat(),textureSize.toFloat())
    }

    override fun update(delta:Float) { }

    override fun dispose() { }
}