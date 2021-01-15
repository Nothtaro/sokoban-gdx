package io.github.nothtaro.sokoban.util

data class Point(var x:Int, var y:Int) {
    operator fun plus(p: Point): Point {
        return Point(this.x + p.x, this.y + p.y)
    }
}