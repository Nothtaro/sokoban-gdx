package io.github.nothtaro.sokoban.json

import io.github.nothtaro.sokoban.enums.EntityType
import io.github.nothtaro.sokoban.util.Point

data class EntityEntity(val type: EntityType, val position:Array<Point>)
