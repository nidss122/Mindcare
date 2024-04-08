package com.company.mindcare

import android.content.Intent
import android.os.Bundle
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alan.alansdk.AlanCallback
import com.alan.alansdk.AlanConfig
import com.alan.alansdk.AlanState
import com.alan.alansdk.button.AlanButton
import com.alan.alansdk.events.EventCommand
import org.json.JSONException
import org.json.JSONObject
import java.util.Locale

class Chatbot : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var speechRecognizer: SpeechRecognizer
    private lateinit var textToSpeech: TextToSpeech
    private lateinit var speechRecognizerIntent: Intent // Declare at class level
    private var alanButton: AlanButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        /// Set up the Alan AI button
        val config = AlanConfig.builder().setProjectId("5da7a9c41c6ed79812e5ed6f350367fe2e956eca572e1d8b807a3e2338fdd0dc/stage").build()
        alanButton = findViewById(R.id.alan_button)
        alanButton?.initWithConfig(config)

        fun setVisualState() {
            /// Providing any params
            val params = JSONObject()
            try {
                params.put("data", "your data")
            } catch (e: JSONException) {
                e.message?.let { Log.e("AlanButton", it) }
            }
            alanButton?.setVisualState(params.toString())
        }

        fun callProjectApi() {
            /// Providind any params
            val params = JSONObject()
            try {
                params.put("data", "your data")
            } catch (e: JSONException) {
                e.message?.let { Log.e("AlanButton", it) }
            }
            alanButton?.callProjectApi("script::funcName", params.toString())
        }

        fun playText() {
            /// Providing text as string param
            alanButton?.playText("Hi")
        }

        fun sendText() {
            /// Providing text as string param
            alanButton?.sendText("Hello Alan, can you help me?")
        }

        fun playCommand() {
            /// Providing any params
            val params = JSONObject()
            try {
                params.put("action", "openSomePage")
            } catch (e: JSONException) {
                e.message?.let { Log.e("AlanButton", it) }
            }
            alanButton?.playCommand(params.toString(), null)
        }

        fun activate() {
            alanButton?.activate()
        }

        fun deactivate() {
            alanButton?.deactivate()
        }

        alanButton?.isActive()

        var enabled = alanButton?.getWakewordEnabled()
        alanButton?.setWakewordEnabled(true)

        val alanCallback: AlanCallback = object : AlanCallback() {
            /// Handle commands from Alan AI Studio
            override fun onCommand(eventCommand: EventCommand) {
                try {
                    val command = eventCommand.data
                    val commandName = command.getJSONObject("data").getString("command")
                    Log.d("AlanButton", "onCommand: commandName: $commandName")
                } catch (e: JSONException) {
                    e.message?.let { Log.e("AlanButton", it) }
                }
            }


            override fun onButtonState(alanState: AlanState) {
                Log.d("AlanButton", "onButtonState: $alanState")
            }
        };
        alanButton?.registerCallback(alanCallback);
    }


    override fun onInit(status: Int) {
        if (status != TextToSpeech.ERROR) {
            textToSpeech.language = Locale.US
        }
    }

}
