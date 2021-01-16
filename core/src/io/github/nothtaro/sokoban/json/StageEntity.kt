package io.github.nothtaro.sokoban.json

data class StageEntity(val level: String, val field: Array<Array<Int>>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StageEntity

        if (level != other.level) return false
        if (!field.contentDeepEquals(other.field)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = level.hashCode()
        result = 31 * result + field.contentDeepHashCode()
        return result
    }
}