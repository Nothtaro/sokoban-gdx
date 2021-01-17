package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.Gdx
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.github.nothtaro.sokoban.entity.EntityType
import io.github.nothtaro.sokoban.json.StageEntity
import io.github.nothtaro.sokoban.json.StagesEntity
import io.github.nothtaro.sokoban.stage.tile.Tile
import io.github.nothtaro.sokoban.stage.tile.TileType
import io.github.nothtaro.sokoban.util.Point

class StageLoader {
    private var jsonMapper = jacksonObjectMapper()
    private val tileCount = 8
    private val tileSize = 64
    var currentLevel = 0

    private lateinit var stages: Array<StageEntity>
    private var elapsed = 0L

    fun initialize() {
        stages = jsonMapper.readValue<StagesEntity>(Gdx.files.internal("levels/levels.json").reader()).stages
    }

    fun load(level: Int): Stage {
        currentLevel = level
        elapsed = System.currentTimeMillis()
        println("ロード中")

        val stage = stages[level]
        val temp = Stage(stage.levelName)

        for (x in 0 until tileCount) {
            for (y in 0 until tileCount) {
                if(stage.field[7-y][x] < 4) {
                    temp.entityManager.addEntity(EntityType.getFromId(stage.field[7-y][x])!!, Point(x,y))
                }

                temp.addTile(Tile(TileType.FLOOR, Point((tileSize * x),(tileSize * y))))

                if(stage.field[7-y][x] == 5) {
                    temp.addTile(Tile(TileType.GOAL, Point((tileSize * x),(tileSize * y))))
                    temp.setGoal(Point(x,y))
                }
            }
        }

        print("ロード完了 経過時間 ${System.currentTimeMillis() - elapsed}ms")
        return temp
    }
}