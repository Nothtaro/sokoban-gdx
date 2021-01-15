package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.graphics.OrthographicCamera

class StageRenderer {
    private lateinit var stageLoader: StageLoader
    lateinit var stage: Stage

    fun initialize() {
        stageLoader = StageLoader()
        stage = stageLoader.load()
    }

    fun render(camera: OrthographicCamera) {
        stage.render(camera)
    }

    fun dispose() {
        stage.dispose()
    }
}