package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.TexturePreloader
import io.github.nothtaro.sokoban.stage.tile.TileType

class Box(override var x:Int, override var y:Int) : Entity {
    private var tempX:Float = 0.0f; var tempY:Float = 0.0f
    private var easeX:Float = (64 * x).toFloat(); var easeY:Float = (64 * y).toFloat()

    override fun getEntityType() : EntityType {
        return EntityType.BOX
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(TexturePreloader.loadTile(TileType.BOX),easeX,easeY,64f,64f)
    }

    override fun translate(x: Int, y: Int) {
        this.x += x
        this.y += y

        tempX = (64 * x).toFloat()
        tempY = (64 * y).toFloat()
    }

    override fun update(delta:Float) {
        easeX += (0.25 * ((64 * x) - easeX)).toFloat()
        easeY += (0.25 * ((64 * y) - easeY)).toFloat()
    }

    override fun dispose() { }
}