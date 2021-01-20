package io.github.nothtaro.sokoban.stage

import io.github.nothtaro.sokoban.enums.TileType
import io.github.nothtaro.sokoban.util.Point

data class Tile(val tileType: TileType, val position:Point)