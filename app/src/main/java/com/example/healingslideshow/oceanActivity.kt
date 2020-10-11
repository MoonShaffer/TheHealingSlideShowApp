package com.example.healingslideshow

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import kotlinx.android.synthetic.main.activity_ocean.*
import kotlin.concurrent.timer

class oceanActivity : AppCompatActivity() {

    //MediaPlayerクラスのインスタンスを保持するための変数
    private lateinit var player: MediaPlayer

    //FragmentPagerAdapterを継承したクラスMyAdapterを作成する
    class MyAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        //フラグメントに表示する画像を保持するためのInt型のリスト
        private val resources = listOf(
            R.drawable.beach,
            R.drawable.dolphin,
            R.drawable.jellyfish,
            R.drawable.maldives,
            R.drawable.nightship,
            R.drawable.oia,
            R.drawable.sea
        )

        //getCountメソッドで画像の総数を返す、リストが保持している要素数はsizeプロパティで取得する
        override fun getCount(): Int {
            return resources.size
        }

        //ImageFragmentのnewInstanceメソッドを呼び、ImageFragmentのインスタンスを生成して返す
        override fun getItem(position: Int): Fragment {
            return ImageFragment.newInstance(resources[position])
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ocean)

        //フルスクリーン で表示し、四隅を丸くする
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //ViewPagerとViewAdapterを関連付ける、Kotlinではadapterプロパティでアクセスできる
        pager.adapter = MyAdapter(supportFragmentManager)
        //Handlerクラスのインスタンスを生成し、変数に取得する
        val handler = Handler()
        //Kotlinのtimer関数を使って15秒ごとに実行するタイマーを用意する
        timer(period = 15000) {
            //Handlerのpostメソッドで実行する
            handler.post {
                //setCurrentItemメソッドにページ数を渡して、指定したページを表示する
                pager.currentItem = (pager.currentItem + 1) % 7
            }
        }

        //createメソッドでMediaPlayerのインスタンスを生成する
        player = MediaPlayer.create(this, R.raw.oceansong)
        //サウンドファイルを繰り返し再生するisLoopingプロパティを設定する
        player.isLooping = true
    }

    //oceanActivityクラスにonResumeメソッドを追加、startメソッドで音楽再生を開始する
    override fun onResume() {
        super.onResume()
        player.start()
    }

    //アプリが中断されたら音楽を一時停止する、onPauseメソッドをオーバーライドしてpauseメソッドを実行する
    override fun onPause() {
        super.onPause()
        player.pause()
    }
}

