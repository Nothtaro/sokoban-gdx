package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.Point

class Player(override var x:Int, override var y:Int) : Entity {
    private var playerTexture = Texture(Gdx.files.internal("player.png"))
    private var tempX:Float = 0.0f; var tempY:Float = 0.0f
    private var easeX:Float = 0.0f; var easeY:Float = 0.0f


    override fun getEntityType() : EntityType {
        return EntityType.PLAYER
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(playerTexture,easeX,easeY,32.toFloat(),32.toFloat())
    }

    override fun translate(x: Int, y: Int) {
        this.x += x
        this.y += y

        tempX = (32 * x).toFloat()
        tempY = (32 * y).toFloat()
    }

    override fun update(delta:Float) {
        easeX += (0.15 * ((32 * x) - easeX)).toFloat()
        easeY += (0.15 * ((32 * y) - easeY)).toFloat()
    }

    override fun dispose() {
        playerTexture.dispose()
    }
}
