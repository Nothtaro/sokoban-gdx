package io.github.nothtaro.sokoban

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.nothtaro.sokoban.ui.FontRenderer
import io.github.nothtaro.sokoban.entity.EntityType
import io.github.nothtaro.sokoban.stage.StageRenderer
import io.github.nothtaro.sokoban.util.Point

class Sokoban : ApplicationAdapter() {
    private var stageRenderer = StageRenderer()
    private var fontRenderer = FontRenderer()
    private lateinit var spriteBatch: SpriteBatch
    private lateinit var camera: OrthographicCamera
    private var gameState = GameState.MAIN
    private var steps = 0

    override fun create() {
        spriteBatch = SpriteBatch()
        TexturePreloader.initalize()
        camera = OrthographicCamera(512f,512f)
        camera.setToOrtho(false)
        camera.translate(-128f,-128f)
        stageRenderer.initialize()
        fontRenderer.initialize()
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        Gdx.gl.glClearColor(0.15f,0.15f,0.15f,1f)
        camera.update()

        if(gameState == GameState.MAIN) {
            fontRenderer.render("SOKOBAN", Point(0,0))
            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                gameState = GameState.GAME
            }
        }

        if(gameState == GameState.GAME) {
            fontRenderer.render("0-0", Point(0,0))
            fontRenderer.render("LEVEL", Point(0,30))
            fontRenderer.render(steps.toString(), Point(0,60))
            fontRenderer.render("STEPS", Point(0,90))
            stageRenderer.render(camera)

            when {
                Gdx.input.isKeyJustPressed(Input.Keys.W) -> {
                    stageRenderer.stage.entityManager.translate(EntityType.PLAYER, Point(0, 1))
                    steps++
                }
                Gdx.input.isKeyJustPressed(Input.Keys.A) -> {
                    stageRenderer.stage.entityManager.translate(EntityType.PLAYER, Point(-1, 0))
                    steps++
                }
                Gdx.input.isKeyJustPressed(Input.Keys.S) -> {
                    stageRenderer.stage.entityManager.translate(EntityType.PLAYER, Point(0, -1))
                    steps++
                }
                Gdx.input.isKeyJustPressed(Input.Keys.D) -> {
                    stageRenderer.stage.entityManager.translate(EntityType.PLAYER, Point(1, 0))
                    steps++
                }
            }
        }
    }

    override fun dispose() {
        TexturePreloader.dispose()
        stageRenderer.dispose()
        fontRenderer.dispose()
    }
}