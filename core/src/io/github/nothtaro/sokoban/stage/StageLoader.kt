package io.github.nothtaro.sokoban.stage

import com.badlogic.gdx.Gdx
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.github.nothtaro.sokoban.entity.Box
import io.github.nothtaro.sokoban.entity.EntityType
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
    private var elapsed = 0L

    fun initialize() {
        stages = jsonMapper.readValue<StagesEntity>(Gdx.files.internal("levels/levels.json").reader()).stages
    }

    fun load(level: String): Stage {
        val temp = Stage(level)
        elapsed = System.currentTimeMillis()
        println("ロード中")
        stages.forEach {
            if(it.level == temp.getStageLevel()) {
                for (x in 0 until tileCount) {
                    for (y in 0 until tileCount) {
                        if(it.field[y][x] < 3) {
                            temp.entityManager.addEntity(EntityType.getFromId(it.field[y][x])!!, Point(x,y))
                        }
                        temp.addTile(Tile(TileType.getFromId(1)!!, Point((tileSize * x),(tileSize * y))))
                    }
                }
            }
        }
        print("ロード完了 経過時間 ${System.currentTimeMillis() - elapsed}ms")
        return temp
    }
}