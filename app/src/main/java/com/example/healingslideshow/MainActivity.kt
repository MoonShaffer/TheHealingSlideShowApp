package com.example.healingslideshow

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //フルスクリーンで表示し、四隅を丸くする
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //ボタンと作成したメソッドを紐付けして、タップで実行されるようにクリック時のリスナーを設定する
        btnOcean.setOnClickListener { onOceanButtonTapped(it) }
        btnForest.setOnClickListener { onForestButtonTapped(it) }
        btnUniverse.setOnClickListener { onUniverseButtonTapped(it) }
        btnFlower.setOnClickListener { onFlowerButtonTapped(it) }


    }

    //ボタンをタップした時に実行するメソッドを用意する、全ボタンに設定するため、引数はViewを受け取るように指定する
    fun onOceanButtonTapped(view: View?) {
        //開きたいアクティビティを指定して、Intentクラスのインスタンスを生成し、startActivityメソッドの引数に渡す
        val intent = Intent(this, oceanActivity::class.java)
        startActivity(intent)
    }

    //ボタンをタップした時に実行するメソッドを用意する、全ボタンに設定するため、引数はViewを受け取るように指定する
    fun onForestButtonTapped(view: View?) {
        //開きたいアクティビティを指定して、Intentクラスのインスタンスを生成し、startActivityメソッドの引数に渡す
        val intent = Intent(this, forestActivity::class.java)
        startActivity(intent)
    }

    //ボタンをタップした時に実行するメソッドを用意する、全ボタンに設定するため、引数はViewを受け取るように指定する
    fun onUniverseButtonTapped(view: View?) {
        //開きたいアクティビティを指定して、Intentクラスのインスタンスを生成し、startActivityメソッドの引数に渡す
        val intent = Intent(this, universeActivity::class.java)
        startActivity(intent)
    }

    //ボタンをタップした時に実行するメソッドを用意する、全ボタンに設定するため、引数はViewを受け取るように指定する
    fun onFlowerButtonTapped(view: View?) {
        //開きたいアクティビティを指定して、Intentクラスのインスタンスを生成し、startActivityメソッドの引数に渡す
        val intent = Intent(this, flowerActivity::class.java)
        startActivity(intent)
    }

}
