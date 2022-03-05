package com.sparklead.tictac

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_game.view.*
import kotlinx.android.synthetic.main.winner_dialogue.*

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
            buselected.setBackgroundResource(R.drawable.playeronebox)
            player1.add(cellid)
            activeplayer = 2
        }
        else
        {
            buselected.text="O"
            buselected.setBackgroundResource(R.drawable.playertwobox)
            player2.add(cellid)
            activeplayer = 1
        }
        buselected.isEnabled =false

        winnercheck()

    }

    fun winnercheck(){
        var winner = -1


        // row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            winner=1
        }
        else if(player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            winner=2
        }
        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            winner=1
        }
        else if(player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            winner=2
        }
        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            winner=1
        }
        else if(player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            winner=2
        }


        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            winner=1
        }
        else if(player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            winner=2
        }
        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            winner=1
        }
        else if(player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            winner=2
        }
        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            winner=1
        }
        else if(player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            winner=2
        }


//      diagonal 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            winner=1
        }else if(player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            winner=2
        }

//      diagonal 2

        if(player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            winner=1
        }else if(player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            winner=2
        }




        if(winner==1)
        {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialogue)
            dialog.winner_text.text="Player 1 Won The Game"


            dialog.exit.setOnClickListener {
                val intent = Intent(this,StartActivity::class.java)
                finish()
                startActivity(intent)

            }
            dialog.playagain.setOnClickListener {
                val intent= Intent(this,GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()
        }
        else if(winner==2)
        {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialogue)
            dialog.winner_text.text="Player 2 Won The Game"


            dialog.exit.setOnClickListener {
                val intent = Intent(this,StartActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.playagain.setOnClickListener {
                val intent= Intent(this,GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()

        }
        else if (player1.size+ player2.size==9)
        {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winner_dialogue)
            dialog.winner_text.text="Draw"


            dialog.exit.setOnClickListener {
                val intent = Intent(this,StartActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.playagain.setOnClickListener {
                val intent= Intent(this,GameActivity::class.java)
                finish()
                startActivity(intent)
            }
            dialog.show()

        }


    }

}