package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bClick(view: View) {
        val bSelected = view as Button
        var cellId = 0
        when (bSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }

        Toast.makeText(this, "You Selected: $cellId", Toast.LENGTH_LONG).show()

        GamePlay(cellId, bSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var ActivePlayer = 1

    fun GamePlay(cellId: Int, bSelected: Button) {

        if (ActivePlayer == 1) {
            bSelected.text = "O"
            bSelected.textSize = 25F
            bSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellId)
            ActivePlayer = 2
               AutoPlay()
        } else {

            bSelected.text = "X"
            bSelected.textSize = 25F
            bSelected.setBackgroundColor(Color.RED)
            player2.add(cellId)
            ActivePlayer = 1
        }
        bSelected.isEnabled = false;
        GameWinner()
    }

    fun GameWinner() {

        var winner = -1


        //ROW 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1;
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2;
        }


        //ROW 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1;
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2;
        }


        //ROW 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1;
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2;
        }


        //COL 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1;
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2;
        }


        //COL 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1;
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2;
        }


        //COL 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1;
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2;
        }


        //Diagonal 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1;
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2;
        }


        //Diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1;
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2;
        }

        if (winner != -1) {

            if (winner == 1) {
                Toast.makeText(this, "The Winner is Player 1!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "The Winner is Player 2!", Toast.LENGTH_LONG).show()

            }
        }
    }

    fun AutoPlay() {
        var emptyCells = ArrayList<Int>()
        for (cellId in 1..9) {
            if (!(player1.contains(cellId) || player2.contains(cellId))) {
                emptyCells.add(cellId)
            }
        }

        var r = Random()
        val randIndex = r.nextInt(emptyCells.size - 0) + 0
        val cellId = emptyCells[randIndex]

        var bSelect: Button?
        when (cellId) {
            1 -> bSelect = button1
            2 -> bSelect = button2
            3 -> bSelect = button3
            4 -> bSelect = button4
            5 -> bSelect = button5
            6 -> bSelect = button6
            7 -> bSelect = button7
            8 -> bSelect = button8
            9 -> bSelect = button9
            else -> bSelect = button1
        }
        GamePlay(cellId, bSelect)

    }
}

