package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.Point

class EntityManager {
    var entities = arrayListOf<Entity>()
    private val textureSize = 64
    private var collideAt: Entity? = null

    fun addEntity(entityType: EntityType, position:Point) {
        when(entityType) {
            EntityType.PLAYER -> { entities.add(Player(position,textureSize)) }
            EntityType.BOX -> { entities.add(Box(position,textureSize)) }
            EntityType.WALL -> { entities.add(Wall(position,textureSize)) }
            EntityType.WALLBOTTOM -> { entities.add(WallBottom(position,textureSize)) }
        }
    }

    fun render(batch: SpriteBatch) {
        entities.forEach {
            it.render(batch)
            it.update(Gdx.graphics.deltaTime)
        }
    }

    fun getPlayerEntity(): Entity?{
        entities.forEach {
            if(it.getEntityType() == EntityType.PLAYER) {
                return it as Player
            }
        }
        return null
    }

    fun translate(type: EntityType, position: Point) {
        entities.forEach {
            if(it.getEntityType() == type) {
                collideAt = isIntersectAt(it.position.plus(position))
                println("$position に移動を試みました 現在 ${it.position}")
                if(collideAt != null && collideAt!!.getEntityType() != EntityType.WALL && collideAt!!.getEntityType() == EntityType.BOX) {
                    if(isIntersectAt(collideAt!!.position.plus(position)) == null) {
                        collideAt!!.translate(position.x,position.y)
                    }
                } else if (collideAt == null) {
                    it.translate(position.x,position.y)
                }
            }
        }
    }

    private fun isIntersectAt(position:Point): Entity? {
        entities.forEach {
            if(it.position == position) {
                println("${it.getEntityType()} がある")
                return it
            }
        }
        return null
    }

    fun dispose() {
        entities.forEach {
            it.dispose()
        }
    }
}