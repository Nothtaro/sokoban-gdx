package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.Point

class Player(override var x:Int, override var y:Int, override var textureSize: Int) : Entity {
    private var playerTexture = Texture(Gdx.files.internal("player.png"))
    private var easeX:Float = (textureSize * x).toFloat(); private var easeY:Float = (textureSize * y).toFloat()


    override fun getEntityType() : EntityType {
        return EntityType.PLAYER
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(playerTexture,easeX,easeY,textureSize.toFloat(),textureSize.toFloat())
    }

    override fun update(delta:Float) {
        easeX += (0.30 * ((textureSize * x) - easeX)).toFloat()
        easeY += (0.30 * ((textureSize * y) - easeY)).toFloat()
    }

    override fun dispose() {
        playerTexture.dispose()
    }
}
