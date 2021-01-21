package io.github.nothtaro.sokoban.json

data class Stage(val levelName: String, val field: Array<Array<Int>>, val entity: Array<Entity>)