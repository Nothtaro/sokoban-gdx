package io.github.nothtaro.sokoban

data class Player(var x:Int, var y:Int) {
    fun getPosition() = Point(x,y)

    fun setPosition(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    fun translate(x: Int, y: Int) {
        this.x += x
        this.y += y
    }
}

data class Point(var x:Int, var y:Int)