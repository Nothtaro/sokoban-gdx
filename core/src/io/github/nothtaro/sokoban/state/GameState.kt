package io.github.nothtaro.sokoban.state

enum class GameState(val id:Int) {
    MAIN(0),
    GAME(1),
    PAUSE(2);

    companion object {
        fun getFromId(id:Int): GameState? {
            values().forEach {
                if(it.id == id) {
                    return it
                }
            }
            return null
        }
    }
}