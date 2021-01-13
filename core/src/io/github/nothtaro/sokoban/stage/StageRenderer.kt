package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.TexturePreloader
import io.github.nothtaro.sokoban.TileType

class StageRenderer {
    private lateinit var batch: SpriteBatch

    private var leftIndent = 0.0
    private var topIndent = 0.0

    private var gridSize = 32
    private var worldGridSize = 8
    private var worldSize = gridSize * worldGridSize

    //Test Room
    var a = arrayOf(intArrayOf(0,0,0,0,0,0,0,0),
                    intArrayOf(0,1,1,1,1,1,1,0),
                    intArrayOf(0,1,1,1,1,1,1,0),
                    intArrayOf(0,1,1,1,1,1,1,0),
                    intArrayOf(0,1,1,1,1,1,1,0),
                    intArrayOf(0,1,1,1,1,1,1,0),
                    intArrayOf(0,1,1,1,1,1,1,0),
                    intArrayOf(0,0,0,0,0,0,0,0))

    fun initialize() {
        batch = SpriteBatch()
        leftIndent = ((Gdx.graphics.width - worldSize) / 2).toDouble()
        topIndent = ((Gdx.graphics.height - worldSize) / 2).toDouble()
    }

    fun render() {
        batch.begin()
        for (x in 0 until worldGridSize) {
            for (y in 0 until worldGridSize) {
                batch.draw(TexturePreloader.loadTile(TileType.getFromId(a[x][y])!!), (leftIndent + (gridSize * x)).toFloat(), (topIndent + gridSize * (worldGridSize - y)).toFloat(), 32f, 32f)
            }
        }
        batch.end()

        println(Gdx.input.x)
    }

    fun dispose() {
        batch.dispose()
    }
}