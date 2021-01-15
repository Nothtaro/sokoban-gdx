package io.github.nothtaro.sokoban

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import io.github.nothtaro.sokoban.entity.EntityManager
import io.github.nothtaro.sokoban.entity.EntityType
import io.github.nothtaro.sokoban.entity.Player
import io.github.nothtaro.sokoban.stage.StageLoader
import io.github.nothtaro.sokoban.stage.StageRenderer
import io.github.nothtaro.sokoban.util.Point

class Sokoban : ApplicationAdapter() {
    private var stageRenderer = StageRenderer()

    override fun create() {
        TexturePreloader.initalize()
        stageRenderer.initialize()
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stageRenderer.render()

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