package io.github.nothtaro.sokoban.entity

class EntityManager {
    private var entities = arrayListOf<Entity>()

    fun initialize() {
        entities.add(Player(50,100))
        entities.add(Box(100,50))
    }

    fun render() {
        entities.forEach {
            it.render()
        }
    }

    fun dispose() {
        entities.forEach {
            it.dispose()
        }
    }
}