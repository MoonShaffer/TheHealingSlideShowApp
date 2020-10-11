package com.example.healingslideshow

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_image.*

//Bundleオブジェクトの値を格納したり出したりする時に、必要なキーを保持するために定数IMG_RES_IDを宣言する
val IMG_RES_ID = "IMG_RES_ID"

class ImageFragment : Fragment() {

    //アーギュメンツから取り出した画像のリソースIDを保持する変数
    private var imgResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //アーギュメンツに保存されていた画像のリソースIDを変数に保存する
            imgResId = it.getInt(IMG_RES_ID)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

//コンパニオンオブジェクトを宣言する
    companion object {
        //newInstanceメソッドで、引数にこのフラグメント内のImageViewに表示する画像のリソースIDを取り、インスタンスを返す
        fun newInstance(imageResourceID : Int) : ImageFragment {
            //Bundleクラスのインスタンスを作成する
            val bundle = Bundle()
            //画像リソースのIDをBundle内に格納する
            bundle.putInt(IMG_RES_ID, imageResourceID)
            //インスタンスを生成後、アーギュメンツへの書き込みを行う
            val imageFragment = ImageFragment()
            imageFragment.arguments = bundle
            //戻り値として、クラスのインスタンスを作成し、返す
            return imageFragment
        }
    }

    //フラグメントのライフサイクルメソッド、アクティビティのonCreateが完了した後、呼び出される
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //imgResIdに保持した画像リソースIDを使って、フラグメント内のImageViewに画像を設定する
        imgResId?.let {
            imageView.setImageResource(it)
        }
    }
}