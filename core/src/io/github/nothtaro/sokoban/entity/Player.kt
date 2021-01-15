package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.Point

class Player(private var x:Int, private var y:Int) : Entity {
    private var batch: SpriteBatch = SpriteBatch()
    private var playerTexture = Texture(Gdx.files.internal("player.png"))
    private var fixedPositionX = (32 * x).toFloat()
    private var fixedPositionY = (32 * x).toFloat()
    private lateinit var currentPos:Point


    override fun getPosition() = Point(x, y)

    override fun getEntityType() : EntityType {
        return EntityType.PLAYER
    }

    override fun setPosition(x: Int, y: Int) {
        this.x = x; this.y = y
    }

    override fun translate(x: Int, y: Int) {
        this.x += x; this.y += y
        fixedPositionX = (32 * x).toFloat()
        fixedPositionY = (32 * y).toFloat()
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(playerTexture,(32 * x).toFloat(),(32 * y).toFloat(),32.toFloat(),32.toFloat())
    }

    override fun update(delta:Float) {

    }

    override fun dispose() {
        playerTexture.dispose()
    }
}
