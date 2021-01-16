package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.Gdx
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.github.nothtaro.sokoban.entity.Box
import io.github.nothtaro.sokoban.entity.Player
import io.github.nothtaro.sokoban.entity.Wall
import io.github.nothtaro.sokoban.json.StageEntity
import io.github.nothtaro.sokoban.json.StagesEntity
import io.github.nothtaro.sokoban.stage.tile.Tile
import io.github.nothtaro.sokoban.stage.tile.TileType
import io.github.nothtaro.sokoban.util.Point

class StageLoader {
    private var jsonMapper = jacksonObjectMapper()
    private val tileCount = 8
    private val tileSize = 64

    private lateinit var stages: Array<StageEntity>

    fun initialize() {
        stages = jsonMapper.readValue<StagesEntity>(Gdx.files.internal("levels/levels.json").reader()).stages
    }

    fun load(level: String): Stage {
        val temp = Stage(level)
        println("Loading")

        stages.forEach {
            if(it.level == temp.getStageLevel()) {
                for (x in 0 until tileCount) {
                    for (y in 0 until tileCount) {
                        when {
                            it.field[y][x] == 0 -> {
                                temp.addEntity(Wall(x,y,tileSize))
                            }
                            it.field[y][x] == 2 -> {
                                temp.addEntity(Player(x,y,tileSize))
                            }
                            it.field[y][x] == 3 -> {
                                temp.addEntity(Box(x,y,tileSize))
                            }
                        }
                        temp.addTile(Tile(TileType.getFromId(1)!!, Point((tileSize * x),(tileSize * y))))
                    }
                }
            }
        }
        print("Stage loaded")
        return temp
    }
}