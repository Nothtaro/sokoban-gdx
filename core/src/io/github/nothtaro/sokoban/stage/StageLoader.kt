package io.github.nothtaro.sokoban.stage

import io.github.nothtaro.sokoban.stage.tile.Tile
import io.github.nothtaro.sokoban.stage.tile.TileType
import io.github.nothtaro.sokoban.util.Point

class StageLoader {
    private val tileCount = 8
    private val tileSize = 32
    //Test room for develop to be implemented
    private var a = arrayOf(intArrayOf(0,0,0,0,0,0,0,0),
                            intArrayOf(0,1,1,1,1,1,1,0),
                            intArrayOf(0,1,1,1,1,1,1,0),
                            intArrayOf(0,1,1,1,1,1,1,0),
                            intArrayOf(0,1,1,1,1,1,1,0),
                            intArrayOf(0,1,1,1,1,1,1,0),
                            intArrayOf(0,1,1,1,1,1,1,0),
                            intArrayOf(0,0,0,0,0,0,0,0))

    fun load(): Stage {
        val temp = Stage()
        println("Loading")
        for (x in 0 until tileCount) {
            for (y in 0 until tileCount) {
                temp.addTile(Tile(TileType.getFromId(a[x][y])!!, Point((tileSize * x),(tileSize * y))))
            }
        }
        print("Stage loaded")
        return temp
    }
}