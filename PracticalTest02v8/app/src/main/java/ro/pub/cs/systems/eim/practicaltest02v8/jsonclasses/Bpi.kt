package ro.pub.cs.systems.eim.practicaltest02v8.jsonclasses

import com.google.gson.annotations.SerializedName


data class Bpi (

  @SerializedName("USD" ) var USD : USD? = USD(),
  @SerializedName("EUR" ) var EUR : EUR? = EUR()

)