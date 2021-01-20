package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.TextureInitializer
import io.github.nothtaro.sokoban.entity.EntityManager
import io.github.nothtaro.sokoban.enums.EntityType
import io.github.nothtaro.sokoban.util.Point

class Stage(val name:String) {
    private val spriteBatch = SpriteBatch()
    val entityManager = EntityManager()
    val tiles = arrayListOf<Tile>()
    var goalPosition:Point = Point(0,0)

    fun isBoxAtGoal(): Boolean = entityManager.entities.find { (it.getEntityType() == EntityType.BOX && it.position == goalPosition) } != null

    fun render(camera: OrthographicCamera) {
        spriteBatch.projectionMatrix = camera.combined
        spriteBatch.begin()
        tiles.forEach { spriteBatch.draw(TextureInitializer.load(it.tileType),it.position.x.toFloat() * 64, it.position.y.toFloat() * 64, 64f,64f) }
        entityManager.render(spriteBatch)
        spriteBatch.end()
    }

    fun dispose() {
        spriteBatch.dispose()
        entityManager.dispose()
    }
}