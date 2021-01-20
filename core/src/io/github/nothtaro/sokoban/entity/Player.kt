package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import io.github.nothtaro.sokoban.enums.EntityType
import io.github.nothtaro.sokoban.enums.DirectionState
import io.github.nothtaro.sokoban.util.Point

class Player(override var position: Point, override var textureSize: Int) : Entity {
    private val playerAtlas = TextureAtlas(Gdx.files.internal("sprites/player/PlayerAtlas.atlas"))
    private var easeX:Float = (textureSize * position.x).toFloat(); private var easeY:Float = (textureSize * position.y).toFloat()
    override var directionState: DirectionState = DirectionState.NORTH

    override fun getEntityType() : EntityType {
        return EntityType.PLAYER
    }

    private fun getSprite() : TextureAtlas.AtlasRegion {
        return when(directionState) {
            DirectionState.NORTH -> playerAtlas.findRegion("up")
            DirectionState.EAST -> playerAtlas.findRegion("right")
            DirectionState.WEST -> playerAtlas.findRegion("left")
            DirectionState.SOUTH -> playerAtlas.findRegion("down")
        }
    }

    override fun render(batch: SpriteBatch) {
        batch.draw(getSprite(),easeX,easeY,textureSize.toFloat(),textureSize.toFloat())
    }

    override fun update(delta:Float) {
        easeX += (0.30 * ((textureSize * position.x) - easeX)).toFloat()
        easeY += (0.30 * ((textureSize * position.y) - easeY)).toFloat()
    }

    override fun dispose() {
        playerAtlas.dispose()
    }
}
