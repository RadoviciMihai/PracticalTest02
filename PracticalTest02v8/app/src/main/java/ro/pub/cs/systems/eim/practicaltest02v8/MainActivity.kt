package ro.pub.cs.systems.eim.practicaltest02v8

import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ro.pub.cs.systems.eim.practicaltest02v8.R
import ro.pub.cs.systems.eim.practicaltest02v8.databinding.ActivityMainBinding
import ro.pub.cs.systems.eim.practicaltest02v8.jsonclasses.BitcoinData
import ro.pub.cs.systems.eim.practicaltest02v8.jsonclasses.Presenter

class MainActivity : AppCompatActivity(), Presenter.BitcoinView {

    private lateinit var presenter: Presenter
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_main)
        presenter = Presenter(this)
        setContentView(R.layout.activity_main)

        val textField: TextView = findViewById(R.id.text_field)
        val usdButton: Button = findViewById(R.id.usd_button)
        val eurButton: Button = findViewById(R.id.eur_button)
        val nxtActButton: Button = findViewById(R.id.nxtact_button)

        usdButton.setOnClickListener {
            textField.text = Constants.TAG_RESULT_USD
            presenter.getBitcoinInfo()
        }

        eurButton.setOnClickListener {
            textField.text = Constants.TAG_RESULT_USD
            presenter.getBitcoinInfo()
        }
    }

    override fun onBitcoinInfoSucces(bitcoin: BitcoinData) {
        Log.d(Constants.TAG_RESULT, "bitcoin")
        Constants.TAG_RESULT_EUR = bitcoin.bpi?.EUR?.rate.toString()
        Constants.TAG_RESULT_USD = bitcoin.bpi?.USD?.rate.toString()
    }

    override fun onBitcoinInfoError(message: String) {
        Log.e(Constants.TAG_RESULT, message)
        Constants.TAG_RESULT = "bitcoin Fail"
    }
}