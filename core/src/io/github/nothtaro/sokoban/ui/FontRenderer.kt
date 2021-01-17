package io.github.nothtaro.sokoban.ui

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import io.github.nothtaro.sokoban.util.Point

class FontRenderer {
    private lateinit var spriteBatch: SpriteBatch
    private lateinit var fontAtlas: TextureAtlas

    fun initialize() {
        spriteBatch = SpriteBatch()
        fontAtlas = TextureAtlas(Gdx.files.internal("sprites/font/lowbitfont.atlas"))
    }

    fun render(string: String,point: Point) {
        spriteBatch.color = Color.WHITE
        spriteBatch.begin()
        for(num in string.indices) {
            spriteBatch.draw(fontAtlas.findRegion(string[num].toString().toLowerCase()),(point.x) + (12f * num),point.y.toFloat(),8f,12f)
        }
        spriteBatch.end()
    }

    fun dispose() {
        spriteBatch.dispose()
        fontAtlas.dispose()
    }
}