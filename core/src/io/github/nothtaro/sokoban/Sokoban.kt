package io.github.nothtaro.sokoban

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import io.github.nothtaro.sokoban.entity.EntityType
import io.github.nothtaro.sokoban.stage.StageRenderer
import io.github.nothtaro.sokoban.state.GameState
import io.github.nothtaro.sokoban.ui.FontRenderer
import io.github.nothtaro.sokoban.util.Point
import io.github.nothtaro.sokoban.util.TexturePreloader

class Sokoban : ApplicationAdapter() {
    private var stageRenderer = StageRenderer()
    private var fontRenderer = FontRenderer()
    private lateinit var camera: OrthographicCamera
    private var gameState = GameState.MAIN
    private var ab = 64 * 8
    private var steps = 0

    override fun create() {
        TexturePreloader.initalize()
        camera = OrthographicCamera()
        camera.setToOrtho(false)
        camera.translate(-((Gdx.graphics.width - ab) / 2).toFloat(),-((Gdx.graphics.height - ab) / 2).toFloat())
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
            fontRenderer.render("LEVEL", Point(0,20))
            fontRenderer.render(steps.toString(), Point(0,40))
            fontRenderer.render("STEPS", Point(0,60))
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

/*
class EaseTest {
    private var x = ((512 - 32) / 2).toFloat(); private var y = ((512 - 32) / 2).toFloat()
    private var tempX = 0f; var tempY = 0f
    private var moveX = 0f; var moveY = 0f

    private var spriteBatch = SpriteBatch()
    private var sprite = TexturePreloader.loadTile(TileType.BOX)
    private var count = 0
    private var elapsed = 0
    private var frameSug = 0

    fun render() {
        spriteBatch.begin()
        spriteBatch.draw(sprite,x,y,32f,32f)
        spriteBatch.end()

        if(Gdx.input.justTouched()) {
            //elapsed = 0
        }

        if(Gdx.input.isTouched) {
            this.tempX = (32 * 4).toFloat()
            this.tempY = 512 - Gdx.input.y.toFloat() - 16

            //println("現在の箱の位置 X: $x Y: $y")
            //println("X: $tempX Y: $tempY に移動しようとしています")
        }

        x += (0.03 * (tempX - x)).toFloat()
        y += (0.03 * (tempY - y)).toFloat()
    }

    private fun easeOutCubic(x: Double):Double {
        return 1 - (1 - x).pow(3.0)
    }
}*/
