package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.util.TexturePreloader
import io.github.nothtaro.sokoban.entity.EntityManager
import io.github.nothtaro.sokoban.stage.tile.Tile

class Stage(private val stageLevel:String) {
    private val tiles = arrayListOf<Tile>()
    private val spriteBatch = SpriteBatch()
    val entityManager = EntityManager()

    fun getStageLevel(): String {
        return this.stageLevel
    }

    fun addTile(tile: Tile) {
        this.tiles.add(tile)
    }

    fun render(camera: OrthographicCamera) {
        spriteBatch.projectionMatrix = camera.combined
        spriteBatch.begin()
        tiles.forEach {
            spriteBatch.draw(TexturePreloader.loadTile(it.tileType),it.position.x.toFloat(), it.position.y.toFloat(), 64f,64f)
        }
        entityManager.render(spriteBatch)
        spriteBatch.end()
    }

    fun dispose() {
        spriteBatch.dispose()
    }
}