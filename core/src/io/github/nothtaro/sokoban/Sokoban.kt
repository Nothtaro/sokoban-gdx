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
    private var stageRenderer = StageManager()
    private var fontRenderer = FontRenderer()
    private lateinit var camera: OrthographicCamera
    private var gameState = GameState.MAIN
    private var count = 0f
    private var ab = 64 * 8
    private var steps = 0

    override fun create() {
        TextureInitializer.initialize()
        camera = OrthographicCamera()
        camera.setToOrtho(false)
        camera.translate(-((Gdx.graphics.width - ab) / 2).toFloat(),-((Gdx.graphics.height - ab) / 2).toFloat())
        stageRenderer.initialize()
        fontRenderer.initialize()
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        Gdx.gl.glClearColor(0.10f,0.10f,0.10f,1f)
        camera.update()

        if(gameState == GameState.MAIN) {
            //fontRenderer.render("SOKOBAN", Point(0,0))
            //fontRenderer.render("PRESS.SPACE.TO.BEGIN", Point(0,20))
            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                gameState = GameState.GAME
            }
        }

        if(gameState == GameState.GAME) {
            //fontRenderer.render("LEVEL.${stageRenderer.stage.name}", Point(0,0))
            //fontRenderer.render("STEPS.$steps", Point(0,20))
            //fontRenderer.render("TIME.${(count.toInt() / 60)}M${count.toInt() % 60}S", Point(0, 40))
            //fontRenderer.render("FPS.${Gdx.graphics.framesPerSecond}", Point(0,80))
            stageRenderer.render(camera)

            if(stageRenderer.stage.entityManager.getPlayerEntity() != null) {
                when {
                    Gdx.input.isKeyJustPressed(Input.Keys.W) -> {
                        //stageRenderer.stage.entityManager.getPlayerEntity()!!.directionState = DirectionState.NORTH
                        stageRenderer.translate(EntityType.PLAYER, Point(0, 1))
                        steps++
                    }
                    Gdx.input.isKeyJustPressed(Input.Keys.A) -> {
                        //stageRenderer.stage.entityManager.getPlayerEntity()!!.directionState = DirectionState.WEST
                        stageRenderer.translate(EntityType.PLAYER, Point(-1, 0))
                        steps++
                    }
                    Gdx.input.isKeyJustPressed(Input.Keys.S) -> {
                        //stageRenderer.stage.entityManager.getPlayerEntity()!!.directionState = DirectionState.SOUTH
                        stageRenderer.translate(EntityType.PLAYER, Point(0, -1))
                        steps++
                    }
                    Gdx.input.isKeyJustPressed(Input.Keys.D) -> {
                        //stageRenderer.stage.entityManager.getPlayerEntity()!!.directionState = DirectionState.EAST
                        stageRenderer.translate(EntityType.PLAYER, Point(1, 0))
                        steps++
                    }
                }
            }
            //count += Gdx.graphics.deltaTime
        }
    }

    override fun dispose() {
        TextureInitializer.dispose()
        stageRenderer.dispose()
        fontRenderer.dispose()
    }
}
