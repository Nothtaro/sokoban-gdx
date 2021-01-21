package io.github.nothtaro.sokoban.json

import io.github.nothtaro.sokoban.enums.EntityType
import io.github.nothtaro.sokoban.util.Point

data class Entity(val type: EntityType, val position:Array<Point>)
