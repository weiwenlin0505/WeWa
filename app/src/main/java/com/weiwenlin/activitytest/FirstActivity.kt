package com.weiwenlin.activitytest

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
//        val firstActivityButton1: Button = findViewById(R.id.button1)
//        firstActivityButton1.setOnClickListener {
//            Toast.makeText(this, "傻逼", Toast.LENGTH_SHORT).show()  //静态方法  short 4000 long 7000
////            Toast.makeText(this, firstActivityButton1.toString(), Toast.LENGTH_LONG).show()
//        }
        var inputOpinion:String = ""
        button1.setOnClickListener {
            Toast.makeText(this, R.string.answer_to_button1, Toast.LENGTH_LONG).show()
        }
        first_jump_to_second.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)             //显示intent
            inputOpinion = input_opinion.text.toString()
            intent.putExtra("input_opinion", inputOpinion)
//            val intent = Intent("com.weiwenlin.activitytest.ACTION_START")            //隐式intent
            intent.addCategory("com.weiwenlin.activitytest.Red")
//            startActivity(intent)                     // 普通启动Activity的方法
            startActivityForResult(intent, 1)
        }
        go_to_pornhub.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.baidu.com")  //可以在manifest中配置，用<data>标签
            startActivity(intent)
        }
        button3_switcher.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:15556929322")
            startActivity(intent)
        }
        life_cycle.setOnClickListener {
            val intent = Intent(this, ForthActivity::class.java)
            startActivity(intent)
        }
        life_cycle_dialog.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "死了", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "活着", Toast.LENGTH_SHORT).show()
            R.id.kill_wwl -> finish()
            else -> Toast.makeText(this, "有毒", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
