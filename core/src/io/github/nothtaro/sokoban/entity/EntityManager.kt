package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.Point

class EntityManager {
    private var entities = arrayListOf<Entity>()
    private val textureSize = 64

    fun addEntity(entityType: EntityType, position:Point) {
        when(entityType) {
            EntityType.PLAYER -> { entities.add(Player(position,textureSize)) }
            EntityType.BOX -> { entities.add(Box(position,textureSize)) }
            EntityType.WALL -> { entities.add(Wall(position,textureSize)) }
        }
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
                println("$position に移動を試みました")
                entities.forEach { e ->
                    if(e.getEntityType() == EntityType.BOX) {
                        //println("CURR PLAYER POS ${(temp.position.plus(position))}")
                        //println("BOX POS ${e.position}")

                        if(e.position == (temp.position.plus(position))) {
                            if(!isIntersectsWall(e.position.plus(position))) {
                                e.translate(position.x, position.y)
                            }
                            println("箱がある")
                            return
                        }
                    }
                }
                if(!isIntersectsWall(temp.position.plus(position))) {
                    it.translate(position.x, position.y)
                }
            }
        }
    }

    private fun isIntersectsWall(position:Point) : Boolean {
        entities.forEach { e ->
            if(e.getEntityType() == EntityType.WALL && e.position == position) {
                //e.translate(position.x, position.y)
                println("WALL POS ${e.position}")
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