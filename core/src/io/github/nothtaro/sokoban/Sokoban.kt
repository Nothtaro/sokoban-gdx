package io.github.nothtaro.sokoban

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Vector3
import io.github.nothtaro.sokoban.entity.EntityType
import io.github.nothtaro.sokoban.stage.StageRenderer
import io.github.nothtaro.sokoban.util.Point

class Sokoban : ApplicationAdapter() {
    private var stageRenderer = StageRenderer()
    private lateinit var camera: OrthographicCamera

    override fun create() {
        TexturePreloader.initalize()
        camera = OrthographicCamera(512f,512f)
        camera.setToOrtho(false)
        camera.translate(-128f,-128f)
        stageRenderer.initialize()
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        Gdx.gl.glClearColor(0.15f,0.15f,0.15f,1f)
        camera.update()
        stageRenderer.render(camera)

        when {
            Gdx.input.isKeyJustPressed(Input.Keys.W) -> {
                stageRenderer.stage.entityManager.translate(EntityType.PLAYER, Point(0,1))
            }
            Gdx.input.isKeyJustPressed(Input.Keys.A) -> {
                stageRenderer.stage.entityManager.translate(EntityType.PLAYER, Point(-1,0))
            }
            Gdx.input.isKeyJustPressed(Input.Keys.S) -> {
                stageRenderer.stage.entityManager.translate(EntityType.PLAYER, Point(0,-1))
            }
            Gdx.input.isKeyJustPressed(Input.Keys.D) -> {
                stageRenderer.stage.entityManager.translate(EntityType.PLAYER, Point(1,0))
            }
        }
    }

    override fun dispose() {
        TexturePreloader.dispose()
        stageRenderer.dispose()
    }
}