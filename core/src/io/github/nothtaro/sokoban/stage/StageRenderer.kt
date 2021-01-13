package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.TexturePreloader
import io.github.nothtaro.sokoban.TileType

class StageRenderer {
    var batch: SpriteBatch = SpriteBatch()

    var leftIndent = 0.0
    var topIndent = 0.0

    var gridSize = 64
    var worldGridSize = 8
    var worldSize = gridSize * worldGridSize

    //Test Room
    var a = arrayOf(intArrayOf(1,1,1,1), intArrayOf(1,0,0,1), intArrayOf(1,0,0,1), intArrayOf(1,1,1,1))

    fun initialize() {
        leftIndent = ((Gdx.graphics.width - worldSize) / 2).toDouble()
        topIndent = ((Gdx.graphics.height - worldSize) / 2).toDouble()
    }

    fun render() {
        batch.begin()
        for (x in 0 until worldGridSize) {
            for (y in 0 until worldGridSize) {
                batch.draw(TexturePreloader.loadTile(TileType.WALL), (leftIndent + (gridSize) * x).toFloat(), (topIndent + (gridSize) * y).toFloat(), 64f, 64f)
            }
        }
        batch.end()
    }

    fun dispose() {
        batch.dispose()
    }
}