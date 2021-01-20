package io.github.nothtaro.sokoban.enums

import io.github.nothtaro.sokoban.util.Point

enum class DirectionState(val point: Point) {
    NORTH(Point(0,1)),
    EAST(Point(1,0)),
    WEST(Point(-1,-0)),
    SOUTH(Point(0,-1));
}