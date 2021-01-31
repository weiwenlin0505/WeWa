package com.weiwenlin.activitytest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.second_layout.*


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
        button2.setOnClickListener {
            Toast.makeText(this, R.string.answer_to_button2, Toast.LENGTH_SHORT).show()
        }
        setAnswerToOpinion()
        second_jump_to_first.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return", this.getString(R.string.returned_data))
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    private fun setAnswerToOpinion() {
        val answerFromFirst: String? = intent.getStringExtra("input_opinion")
        answer_to_opinion.text = when (answerFromFirst?.toUpperCase()){
            "A" -> resources.getString(R.string.answer_of_A)
            "B" -> resources.getString(R.string.answer_of_B)
            "C" -> resources.getString(R.string.answer_of_C)
            "D" -> resources.getString(R.string.answer_of_D)
            else -> resources.getString(R.string.answer_of_default)
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return", this.getString(R.string.returned_data))
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
