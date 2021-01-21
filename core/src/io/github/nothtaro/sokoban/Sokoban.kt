package io.github.nothtaro.sokoban

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Vector3
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
    private var gameState = GameState.GAME
    private var mapSize = 64 * 16
    private var zoom = 1.5f
    private var steps = 0

    override fun create() {
        TextureInitializer.initialize()
        camera = OrthographicCamera()
        camera.setToOrtho(false)
        stageManager.initialize()
        fontRenderer.initialize()
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        Gdx.gl.glClearColor(0.10f,0.10f,0.10f,1f)
        camera.translate((0.75f * ((mapSize / 2) - camera.position.x)),(0.75f * ((mapSize / 2) - camera.position.y)))
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
                    Gdx.input.isKeyJustPressed(Input.Keys.O) -> {
                        zoom -= 0.5f
                    }
                    Gdx.input.isKeyJustPressed(Input.Keys.L) -> {
                        zoom += 0.5f
                    }
                }
            }
            camera.zoom += (0.25f * ((zoom - camera.zoom)))
        }
    }

    override fun dispose() {
        TextureInitializer.dispose()
        stageManager.dispose()
        fontRenderer.dispose()
    }
}
