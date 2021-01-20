package io.github.nothtaro.sokoban.enums

enum class GameState(val id:Int) {
    MAIN(0),
    GAME(1),
    EDITOR(2),
    PAUSE(3);

    companion object {
        fun fromID(id:Int): GameState? {
            return values().find { it.id == id }
        }
    }
}