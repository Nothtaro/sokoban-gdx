package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.Point

class Player(private var x:Int, private var y:Int) : Entity {
    private var batch: SpriteBatch = SpriteBatch()
    private var playerTexture = Texture(Gdx.files.internal("player.png"))

    override fun getPosition() = Point(x, y)

    override fun getEntityType() : EntityType {
        return EntityType.PLAYER
    }

    override fun setPosition(x: Int, y: Int) {
        this.x = x; this.y = y
    }

    override fun translate(x: Int, y: Int) {
        this.x += x; this.y += y
    }

    override fun render() {
        batch.begin()
        batch.draw(playerTexture,(32 * x).toFloat(),(32 * y).toFloat(),32f,32f)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        playerTexture.dispose()
    }
}
