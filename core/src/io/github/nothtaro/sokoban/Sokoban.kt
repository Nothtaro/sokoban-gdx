package io.github.nothtaro.sokoban

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import io.github.nothtaro.sokoban.enums.EntityType
import io.github.nothtaro.sokoban.stage.StageManager
import io.github.nothtaro.sokoban.enums.DirectionState
import io.github.nothtaro.sokoban.enums.GameState
import io.github.nothtaro.sokoban.ui.FontRenderer
import io.github.nothtaro.sokoban.util.Point
import io.github.nothtaro.sokoban.util.TextureInitializer

class Sokoban : ApplicationAdapter() {
    private var stageManager = StageManager()
    private var fontRenderer = FontRenderer()
    private lateinit var camera: OrthographicCamera
    private var gameState = GameState.MAIN
    private var mapSize = 64 * 8
    private var steps = 0

    override fun create() {
        TextureInitializer.initialize()
        camera = OrthographicCamera()
        camera.setToOrtho(false)
        camera.translate(-((Gdx.graphics.width - mapSize) / 2).toFloat(),-((Gdx.graphics.height - mapSize) / 2).toFloat())
        stageManager.initialize()
        fontRenderer.initialize()
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        Gdx.gl.glClearColor(0.10f,0.10f,0.10f,1f)
        camera.update()

        if(gameState == GameState.MAIN) {
            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                gameState = GameState.GAME
            }
        }

        if(gameState == GameState.GAME) {
            stageManager.render(camera)
            if(stageManager.getPlayer() != null) {
                when {
                    Gdx.input.isKeyJustPressed(Input.Keys.W) -> {
                        stageManager.translate(EntityType.PLAYER, DirectionState.NORTH)
                        steps++
                    }
                    Gdx.input.isKeyJustPressed(Input.Keys.A) -> {
                        stageManager.translate(EntityType.PLAYER, DirectionState.WEST)
                        steps++
                    }
                    Gdx.input.isKeyJustPressed(Input.Keys.S) -> {
                        stageManager.translate(EntityType.PLAYER, DirectionState.SOUTH)
                        steps++
                    }
                    Gdx.input.isKeyJustPressed(Input.Keys.D) -> {
                        stageManager.translate(EntityType.PLAYER, DirectionState.EAST)
                        steps++
                    }
                }
            }
        }
    }

    override fun dispose() {
        TextureInitializer.dispose()
        stageManager.dispose()
        fontRenderer.dispose()
    }
}
