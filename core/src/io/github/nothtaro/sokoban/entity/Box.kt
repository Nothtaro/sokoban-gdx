package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.TexturePreloader
import io.github.nothtaro.sokoban.stage.tile.TileType

class Box(override var x:Int, override var y:Int) : Entity {
    private var tempX:Float = 0.0f; var tempY:Float = 0.0f
    private var easeX:Float = 0.0f; var easeY:Float = 0.0f

    override fun getEntityType() : EntityType {
        return EntityType.BOX
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(TexturePreloader.loadTile(TileType.BOX),easeX,easeY,32f,32f)
    }

    override fun translate(x: Int, y: Int) {
        this.x += x
        this.y += y

        tempX = (32 * x).toFloat()
        tempY = (32 * y).toFloat()
    }

    override fun update(delta:Float) {
        easeX += (0.25 * ((32 * x) - easeX)).toFloat()
        easeY += (0.25 * ((32 * y) - easeY)).toFloat()
    }

    override fun dispose() { }
}