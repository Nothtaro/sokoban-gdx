package io.github.nothtaro.sokoban.stage

import io.github.nothtaro.sokoban.stage.tile.Tile
import io.github.nothtaro.sokoban.stage.tile.TileType
import io.github.nothtaro.sokoban.util.Point

class Tst {
    var test = Array(5) { arrayOfNulls<Tile>(5) }
    var test2 = arrayOf(arrayOf(Tile(TileType.BOX, Point(2, 2))))
}