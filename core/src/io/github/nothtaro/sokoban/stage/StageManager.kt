package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.graphics.OrthographicCamera
import io.github.nothtaro.sokoban.entity.Entity
import io.github.nothtaro.sokoban.entity.EntityManager
import io.github.nothtaro.sokoban.enums.DirectionState
import io.github.nothtaro.sokoban.enums.EntityType
import io.github.nothtaro.sokoban.util.Point

class StageManager {
    private var stageLoader = StageLoader()
    private lateinit var entityManager: EntityManager
    lateinit var stage: Stage

    fun initialize() {
        stageLoader.initialize()
        stage = stageLoader.load(0)
        entityManager = stage.entityManager
    }

    fun render(camera: OrthographicCamera) {
        stage.render(camera)
        if(stage.isBoxAtGoal()) {
            stage = stageLoader.load(1)
            entityManager = stage.entityManager
        }
    }

    fun translate(type: EntityType, direction: DirectionState) {
        val position = direction.point
        entityManager.entities.forEach {
            if(it.getEntityType() == type) {
                it.directionState = direction
                val collideAt = isEntityCollideAt(it.position.plus(position))
                println("$position に移動を試みました 現在 ${it.position}")
                if(collideAt != null) {
                    if(collideAt.isCollidable()) {
                        if(isEntityCollideAt(collideAt.position.plus(position)) == null && !isTileCollideAt(collideAt.position.plus(position))) {
                            collideAt.translate(position.x,position.y)
                        }
                    }
                } else if(!isTileCollideAt(it.position.plus(position))) {
                    it.translate(position.x,position.y)
                }
            }
        }
    }

    private fun isEntityCollideAt(position:Point): Entity? = entityManager.entities.find { (it.position == position && it.isCollidable()) }

    private fun isTileCollideAt(position: Point): Boolean = stage.tiles.find { (it.position == position && it.tileType.collidable) } != null

    fun getPlayer(): Entity?{
        entityManager.entities.forEach {
            if(it.getEntityType() == EntityType.PLAYER) {
                return it
            }
        }
        return null
    }

    fun dispose() {
        stage.dispose()
    }
}