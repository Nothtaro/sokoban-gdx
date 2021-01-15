package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Player(override var x:Int, override var y:Int) : Entity {
    private var playerTexture = Texture(Gdx.files.internal("player.png"))

    override fun getEntityType() : EntityType {
        return EntityType.PLAYER
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(playerTexture,(32 * x).toFloat(),(32 * y).toFloat(),32.toFloat(),32.toFloat())
    }

    override fun update(delta:Float) { }

    override fun dispose() {
        playerTexture.dispose()
    }
}
