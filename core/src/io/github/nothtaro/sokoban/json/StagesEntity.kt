package io.github.nothtaro.sokoban.json

data class StagesEntity(val stages: Array<StageEntity>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StagesEntity

        if (!stages.contentEquals(other.stages)) return false

        return true
    }

    override fun hashCode(): Int {
        return stages.contentHashCode()
    }
}