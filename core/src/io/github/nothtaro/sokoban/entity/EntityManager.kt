package io.github.nothtaro.sokoban.entity

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.enums.EntityType
import io.github.nothtaro.sokoban.util.Point

class EntityManager {
    var entities = arrayListOf<Entity>()

    fun render(batch: SpriteBatch) {
        entities.forEach {
            it.render(batch)
            it.update(Gdx.graphics.deltaTime)
        }
    }

    fun dispose() {
        entities.forEach {
            it.dispose()
        }
    }
}