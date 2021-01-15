package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.TexturePreloader
import io.github.nothtaro.sokoban.stage.tile.TileType

class StageRenderer {
    private lateinit var stageLoader: StageLoader
    lateinit var stage: Stage

    fun initialize() {
        stageLoader = StageLoader()
        stage = stageLoader.load()
    }

    fun render() {
        stage.render()
    }

    fun dispose() {
        stage.dispose()
    }
}