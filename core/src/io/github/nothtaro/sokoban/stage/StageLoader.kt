package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.Gdx
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.github.nothtaro.sokoban.entity.Box
import io.github.nothtaro.sokoban.entity.Player
import io.github.nothtaro.sokoban.enums.EntityType
import io.github.nothtaro.sokoban.json.Stage
import io.github.nothtaro.sokoban.json.Stages
import io.github.nothtaro.sokoban.enums.TileType
import io.github.nothtaro.sokoban.util.Point

class StageLoader {
    private lateinit var stages: Array<Stage>
    private var jsonMapper = jacksonObjectMapper()
    private val tileCount = 16
    private val textureSize = 64
    private var elapsed = 0L


    fun initialize() {
        println("Loading JSON...")
        startMeasuring()
        //stages = jsonMapper.readValue<Stages>(Gdx.files.internal("levels/levels.json").reader()).stages
        println("Loaded. elapsed ${stopMeasuring()}ms")
    }

    fun load(level: Int): io.github.nothtaro.sokoban.stage.Stage {
        val temp = Stage("stage.levelName")

        for (x in 0 until tileCount) {
            for (y in 0 until tileCount) {
                temp.tiles.add(Tile(TileType.WALL, Point(x,y)))
            }
        }
        temp.entityManager.entities.add(Player(Point(0,0),64))
        /*startMeasuring()
        println("ロード中")
        val stage = stages[level]
        val temp = Stage(stage.levelName)
        for (x in 0 until tileCount) {
            for (y in 0 until tileCount) {
                temp.tiles.add(Tile(TileType.fromID(stage.field[7-y][x])!!, Point(x,y)))
                if(stage.field[7-y][x] == 4) {
                    temp.goalPosition = Point(x,y)
                }
            }
        }
        stage.entity.forEach { entities ->
            entities.position.forEach {
                when(entities.type) {
                    EntityType.PLAYER -> temp.entityManager.entities.add(Player(it,textureSize))
                    EntityType.BOX -> temp.entityManager.entities.add(Box(it,textureSize))
                }
            }
        }
        print("ロード完了 経過時間 ${stopMeasuring()}ms")*/
        return temp
    }

    private fun startMeasuring() {
        elapsed = System.currentTimeMillis()
    }

    private fun stopMeasuring(): Long {
        return (System.currentTimeMillis() - elapsed)
    }
}