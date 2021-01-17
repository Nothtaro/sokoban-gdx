package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.graphics.OrthographicCamera

class StageManager {
    private lateinit var stageLoader: StageLoader
    lateinit var stage: Stage

    fun initialize() {
        stageLoader = StageLoader()
        stageLoader.initialize()
        stage = stageLoader.load(0)
    }

    fun render(camera: OrthographicCamera) {
        stage.render(camera)
    }

    fun dispose() {
        stage.dispose()
    }
}