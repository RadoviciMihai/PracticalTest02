package ro.pub.cs.systems.eim.practicaltest02v8.jsonclasses

import com.google.gson.annotations.SerializedName


data class BitcoinData (

  @SerializedName("time"       ) var time       : Time?   = Time(),
  @SerializedName("disclaimer" ) var disclaimer : String? = null,
  @SerializedName("bpi"        ) var bpi        : Bpi?    = Bpi()

)