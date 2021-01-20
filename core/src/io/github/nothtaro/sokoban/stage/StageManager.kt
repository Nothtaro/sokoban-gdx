package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.graphics.OrthographicCamera
import io.github.nothtaro.sokoban.enums.EntityType
import io.github.nothtaro.sokoban.util.Point

class StageManager {
    private var stageLoader = StageLoader()
    lateinit var stage: Stage

    fun initialize() {
        stageLoader.initialize()
        stage = stageLoader.load(0)
    }

    fun render(camera: OrthographicCamera) {
        stage.render(camera)
        if(stage.isBoxAtGoal()) {
            stage = stageLoader.load(1)
        }
    }

    fun translate(type: EntityType, position: Point) {
        stage.entityManager.entities.forEach {
            if(it.getEntityType() == type) {
                val collideAt = stage.entityManager.isIntersectAt(it.position.plus(position))
                println("$position に移動を試みました 現在 ${it.position}")
                if(collideAt != null) {
                    if(collideAt.isCollidable()) {
                        if(stage.entityManager.isIntersectAt(collideAt.position.plus(position)) == null && !tileCollideAt(collideAt.position.plus(position))) {
                            collideAt.translate(position.x,position.y)
                        }
                    }
                } else if(!tileCollideAt(it.position.plus(position))) {
                    it.translate(position.x,position.y)
                }
            }
        }
    }

    fun tileCollideAt(position: Point): Boolean = stage.tiles.find { (it.position == position && it.tileType.collidable) } != null

    fun dispose() {
        stage.dispose()
    }
}