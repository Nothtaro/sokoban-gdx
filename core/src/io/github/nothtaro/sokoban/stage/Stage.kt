package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.TextureInitializer
import io.github.nothtaro.sokoban.entity.EntityManager
import io.github.nothtaro.sokoban.enums.EntityType
import io.github.nothtaro.sokoban.util.Point

class Stage(private val stageName:String) {
    private val tiles = arrayListOf<Tile>()
    private val spriteBatch = SpriteBatch()
    val entityManager = EntityManager()
    lateinit var goalPosition:Point

    fun getStageName(): String {
        return this.stageName
    }

    fun addTile(tile: Tile) {
        this.tiles.add(tile)
    }

    fun setGoal(position: Point) {
        this.goalPosition = position
    }

    fun isBoxAtGoal(): Boolean {
        /*entityManager.entities.forEach {
            if(it.getEntityType() == EntityType.BOX && it.position == goalPosition) {
                return true
            }
        }*/
        return false
    }

    fun render(camera: OrthographicCamera) {
        spriteBatch.projectionMatrix = camera.combined
        spriteBatch.begin()
        tiles.forEach {
            spriteBatch.draw(TextureInitializer.load(it.tileType),it.position.x.toFloat(), it.position.y.toFloat(), 64f,64f)
        }
        entityManager.render(spriteBatch)
        spriteBatch.end()
    }

    fun dispose() {
        spriteBatch.dispose()
    }
}