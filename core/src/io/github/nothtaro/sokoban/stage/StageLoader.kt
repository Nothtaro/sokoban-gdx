package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.Gdx
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.github.nothtaro.sokoban.json.StageEntity
import io.github.nothtaro.sokoban.json.StagesEntity
import io.github.nothtaro.sokoban.enums.TileType
import io.github.nothtaro.sokoban.util.Point

class StageLoader {
    private var jsonMapper = jacksonObjectMapper()
    private val tileCount = 8
    private val tileSize = 64

    private lateinit var stages: Array<StageEntity>
    private var elapsed = 0L


    fun initialize() {
        println("Loading JSON...")
        startMeasuring()
        stages = jsonMapper.readValue<StagesEntity>(Gdx.files.internal("levels/levels.json").reader()).stages
        println("Loaded. elapsed ${stopMeasuring()}ms")
    }

    fun load(level: Int): Stage {
        startMeasuring()
        println("ロード中")

        val stage = stages[level]
        val temp = Stage(stage.levelName)

        for (x in 0 until tileCount) {
            for (y in 0 until tileCount) {
                temp.addTile(Tile(TileType.fromID(stage.field[7-y][x])!!, Point((tileSize * x),(tileSize * y))))
                if(stage.field[7-y][x] == 4) {
                    temp.setGoal(Point(x,y))
                }
            }
        }

        stage.entity.forEach { entities ->
            entities.position.forEach {
                temp.entityManager.addEntity(entities.type, it)
            }
        }

        print("ロード完了 経過時間 ${stopMeasuring()}ms")
        return temp
    }

    private fun startMeasuring() {
        elapsed = System.currentTimeMillis()
    }

    private fun stopMeasuring(): Long {
        return (System.currentTimeMillis() - elapsed)
    }
}