package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.Point

class EntityManager {
    var entities = arrayListOf<Entity>()

    fun initialize() {

    }

    fun addEntity(entity: Entity) {
        entities.add(entity)
    }

    fun render(batch: SpriteBatch) {
        entities.forEach {
            it.render(batch)
            it.update(Gdx.graphics.deltaTime)
        }
    }

    fun translate(type: EntityType, position: Point) {
        entities.forEach {
            if(it.getEntityType() == type) {
                val temp = it
                println("Try to move to $position")
                entities.forEach { e ->
                    if(e.getEntityType() == EntityType.BOX) {
                        println("CURR PLAYER POS ${(temp.getPosition().plus(position))}")
                        println("BOX POS ${e.getPosition()}")

                        if(e.getPosition() == (temp.getPosition().plus(position))) {
                            if(!isIntersectsWall(e.getPosition().plus(position))) {
                                e.translate(position.x, position.y)
                            }
                            println("Theres a box")
                            return
                        }
                    }
                }
                if(!isIntersectsWall(temp.getPosition().plus(position))) {
                    it.translate(position.x, position.y)
                }
            }
        }
    }

    fun isIntersectsWall(position:Point) : Boolean {
        entities.forEach { e ->
            if(e.getEntityType() == EntityType.WALL && e.getPosition() == position) {
                //e.translate(position.x, position.y)
                println("WALL POS ${e.getPosition()}")
                println("Theres a wall")
                return true
            }
        }
        return false
    }

    fun dispose() {
        entities.forEach {
            it.dispose()
        }
    }
}