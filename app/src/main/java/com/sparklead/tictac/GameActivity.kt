package com.sparklead.tictac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    fun buclick(view:View){

        var cellid=0
        val buselected = view as Button

        when(buselected.id){

            R.id.button1 -> cellid=1
            R.id.button2 -> cellid=2
            R.id.button3 -> cellid=3
            R.id.button4 -> cellid=4
            R.id.button5 -> cellid=5
            R.id.button6 -> cellid=6
            R.id.button7 -> cellid=7
            R.id.button8 -> cellid=8
            R.id.button9 -> cellid=9



        }

//        Log.d("buclick :" , buselected.id.toString())
//        Log.d("cellid" , cellid.toString())

        playgame(cellid,buselected)

    }
    var activeplayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playgame(cellid: Int , buselected:Button) {

        if(activeplayer==1) {
            buselected.text = "X"
            buselected.setBackgroundResource(R.color.my_green)
            player1.add(cellid)
            activeplayer = 2
        }
        else
        {
            buselected.text="O"
            buselected.setBackgroundResource(R.color.my_yellow)
            player2.add(cellid)
            activeplayer = 1
        }
        buselected.isEnabled =false

    }

}