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
        if(stage.isBoxAtGoal()) {
            stage = stageLoader.load(stageLoader.currentLevel + 1)
        }
    }

    fun testCollide() {

    }

    fun dispose() {
        stage.dispose()
    }
}