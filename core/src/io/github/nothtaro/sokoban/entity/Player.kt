package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.Point

class Player(override var x:Int, override var y:Int) : Entity {
    private var playerTexture = Texture(Gdx.files.internal("player.png"))
    private var tempX:Float = 0.0f; var tempY:Float = 0.0f
    private var easeX:Float = (64 * x).toFloat(); var easeY:Float = (64 * y).toFloat()


    override fun getEntityType() : EntityType {
        return EntityType.PLAYER
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(playerTexture,easeX,easeY,64.toFloat(),64.toFloat())
    }

    override fun translate(x: Int, y: Int) {
        this.x += x
        this.y += y

        tempX = (64 * x).toFloat()
        tempY = (64 * y).toFloat()
    }

    override fun update(delta:Float) {
        easeX += (0.30 * ((64 * x) - easeX)).toFloat()
        easeY += (0.30 * ((64 * y) - easeY)).toFloat()
    }

    override fun dispose() {
        playerTexture.dispose()
    }
}
