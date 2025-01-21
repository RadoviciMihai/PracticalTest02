package ro.pub.cs.systems.eim.practicaltest02v8.jsonclasses

import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import ro.pub.cs.systems.eim.practicaltest02v8.Constants

class Presenter(private val view: BitcoinView) {

    private val client = OkHttpClient()
    private val gson = Gson()

    interface BitcoinView {
        fun onBitcoinInfoSucces(bitcoin: BitcoinData)
        fun onBitcoinInfoError(message: String)
    }

    fun getBitcoinInfo() {

        CoroutineScope(Dispatchers.IO).launch {
            val url = "https://api.coindesk.com/v1/bpi/currentprice/EUR.json"

            val request = Request.Builder()
                .url(url)
                .build()

            val response = client.newCall(request).execute()


            if (!response.isSuccessful) {
                view.onBitcoinInfoError("Unexpected response: ${response.code}")
                return@launch
            }

            val bitcoin = gson.fromJson(response.body?.string(), BitcoinData::class.java)
            view.onBitcoinInfoSucces(bitcoin)
        }
    }

}