package com.example.superheroleague.data

import com.google.gson.TypeAdapter
import com.google.gson.annotations.SerializedName
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

data class SuperheroSearchResponse(
    val results: List<Superhero>
)

data class Superhero(
    val id: String,
    val name: String,
    val image: Image,
    val biography: Biography,
    val work: Work,
    @SerializedName("powerstats") val stats: Stats
)

data class Work (
    val occupation: String,
    val base: String

)

data class Biography(
    @SerializedName("full-name") val realName: String,
    @SerializedName("place-of-birth") val placeOfBirth: String,
    val publisher: String,
    val alignment: String
)

data class Stats (

    var intelligence: String,
    var strength: String,
    var speed: String,
    var durability: String,
    var power: String,
    var combat: String,
)

data class Image(
    val url: String
)

class IntegerAdapter : TypeAdapter<Int>() {
    override fun write(out: JsonWriter?, value: Int) {
        out?.value(value)
    }

    override fun read(`in`: JsonReader?): Int {
        return try {
            `in`!!.nextString()!!.toInt()
        } catch (e: Exception) {
            0
        }
    }

}