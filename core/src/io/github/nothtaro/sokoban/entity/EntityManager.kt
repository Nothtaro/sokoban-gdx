package io.github.nothtaro.sokoban.entity

class EntityManager {
    private var entities = arrayListOf<Entity>()

    fun initialize() {
        entities.add(Player(32,32))
        entities.add(Box(32,64))
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