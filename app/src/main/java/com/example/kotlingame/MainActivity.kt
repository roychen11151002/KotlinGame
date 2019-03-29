package com.example.kotlingame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

const val KotlinLog = "kotlinTest"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            if(txvName.length() != 0) {
                val pc = Random.nextInt(1, 4)
                var me: Int = 0
                Log.d(KotlinLog, "random $pc")
                txvShowName.text = getString(R.string.txvShowName) + "\n" + txvName.text
                when(rdGp.checkedRadioButtonId) {
                    R.id.rdPaper -> {
                        Log.d(KotlinLog, "Paper")
                        txvShowMe.text = getString(R.string.txvShowMe) + "\n" + "Paper"
                        me = 1;
                    }
                    R.id.rdStone -> {
                        Log.d(KotlinLog, "Stone")
                        txvShowMe.text = getString(R.string.txvShowMe) + "\n" + "Stone"
                        me = 2
                    }
                    R.id.rdScissor -> {
                        Log.d(KotlinLog, "Scissors")
                        txvShowMe.text = getString(R.string.txvShowMe) + "\n" + "Scissors"
                        me = 3
                    }
                    else ->Log.d(KotlinLog, "otherwise ${rdGp.checkedRadioButtonId}")
                }
                when(pc)
                {
                    1 -> txvShowPc.text = getString(R.string.txvShowPc) + "\n" + "Paper"
                    2 -> txvShowPc.text = getString(R.string.txvShowPc) + "\n" + "Stone"
                    3 -> txvShowPc.text = getString(R.string.txvShowPc) + "\n" + "Scissors"
                    else ->Log.d(KotlinLog, "otherwise")
                }
                if(me == pc) {
                    txvShow.text = "The game was tied !"
                    txvShowWinner.text = getString(R.string.txvShowWinner) + "\n" + "tie"
                }
                // else if(((me == 1) && (pc == 2)) || ((me == 2) && (pc == 3)) || ((me == 3) && (pc == 1))) {
                else if(((me + 1) % 3) == (pc % 3)) {
                    txvShow.text = "I was the winner !"
                    txvShowWinner.text = getString(R.string.txvShowWinner) + "\n" + "me"
                }
                else
                {
                    txvShow.text = "Android was the winner !"
                    txvShowWinner.text = getString(R.string.txvShowWinner) + "\n" + "Android"
                }
            }
            else
                txvShow.text = getString(R.string.txvShow)
        }
    }
}
