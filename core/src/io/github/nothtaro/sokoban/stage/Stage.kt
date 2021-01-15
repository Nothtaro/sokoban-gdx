package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.TexturePreloader
import io.github.nothtaro.sokoban.entity.Entity
import io.github.nothtaro.sokoban.entity.EntityManager
import io.github.nothtaro.sokoban.entity.EntityType
import io.github.nothtaro.sokoban.stage.tile.Tile

class Stage {
    private val tiles = arrayListOf<Tile>()
    private val spriteBatch = SpriteBatch()
    val entityManager = EntityManager()

    init {
        entityManager.initialize()
    }

    fun addTile(tile: Tile) {
        this.tiles.add(tile)
    }

    fun addEntity(entity: Entity) {
        entityManager.addEntity(entity)
    }

    /*fun getEntity(type: EntityType): Entity? {
        entityManager.entities.forEach {
            if(it.getEntityType() == type) {
                return it
            }
        }
        return null
    }*/

    fun render() {
        spriteBatch.begin()
        tiles.forEach {
            spriteBatch.draw(TexturePreloader.loadTile(it.tileType),
                    it.position.x.toFloat(),
                    it.position.y.toFloat(),
                    32f,32f)
        }
        spriteBatch.end()
        entityManager.render()
    }

    fun dispose() {
        spriteBatch.dispose()
    }
}