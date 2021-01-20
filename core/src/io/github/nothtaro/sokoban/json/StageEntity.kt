package io.github.nothtaro.sokoban.json

data class StageEntity(val levelName: String, val field: Array<Array<Int>>, val entity: Array<EntityEntity>)