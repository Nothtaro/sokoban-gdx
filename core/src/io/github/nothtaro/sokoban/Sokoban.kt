package io.github.nothtaro.sokoban

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import io.github.nothtaro.sokoban.entity.EntityManager
import io.github.nothtaro.sokoban.entity.Player
import io.github.nothtaro.sokoban.stage.StageRenderer

class Sokoban : ApplicationAdapter() {
    private var stageRenderer = StageRenderer()
    private var entityManager = EntityManager()

    override fun create() {
        TexturePreloader.initalize()
        stageRenderer.initialize()
        entityManager.initialize()
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stageRenderer.render()
        entityManager.render()
    }

    override fun dispose() {
        TexturePreloader.dispose()
        stageRenderer.dispose()
        entityManager.dispose()
    }
}