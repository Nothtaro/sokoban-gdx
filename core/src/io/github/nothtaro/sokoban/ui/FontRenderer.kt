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
        fontAtlas = TextureAtlas(Gdx.files.internal("font/lowbitfont.atlas"))
    }

    fun render(string: String,point: Point) {
        spriteBatch.color = Color.GRAY
        spriteBatch.begin()
        for(num in string.indices) {
            spriteBatch.draw(fontAtlas.findRegion(string[num].toString().toLowerCase()),(point.x) + (24f * num),point.y.toFloat(),16f,24f)
        }
        spriteBatch.end()
    }

    fun dispose() {
        spriteBatch.dispose()
        fontAtlas.dispose()
    }
}