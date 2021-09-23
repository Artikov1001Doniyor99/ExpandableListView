package com.example.modul_5_2_lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val intF = intent.getIntExtra("Father",-1)
        val intCh = intent.getIntExtra("Child",-1)

        if(intF==0){
            if (intCh == 0){
                image_S.setImageResource(R.drawable.apple)
                image_S.scaleType = ImageView.ScaleType.CENTER_INSIDE
            }else{
                if (intCh == 1){
                    image_S.setImageResource(R.drawable.mango)
                }else{
                    if (intCh == 2){
                        image_S.setImageResource(R.drawable.banana)
                        image_S.scaleType = ImageView.ScaleType.CENTER_INSIDE
                    }else{
                            image_S.setImageResource(R.drawable.orange)
                        image_S.scaleType = ImageView.ScaleType.CENTER_INSIDE
                    }
                }
            }
        }else{
            if(intF==1){
                if (intCh == 0){
                    image_S.setImageResource(R.drawable.rose)
                }else{
                    if (intCh == 1){
                        image_S.setImageResource(R.drawable.lily)
                    }else{
                            image_S.setImageResource(R.drawable.tulip)
                    }
                }
            }else{
                if(intF==2){
                    if (intCh == 0){
                        image_S.setImageResource(R.drawable.tiger)
                    }else{
                        if (intCh == 1){
                            image_S.setImageResource(R.drawable.bear)
                        }else{
                            image_S.setImageResource(R.drawable.wolf)
                        }
                    }
                }else{
                    if(intF==3){
                        if (intCh == 0){
                            image_S.setImageResource(R.drawable.goose)
                        }else{
                            if (intCh == 1){
                                image_S.setImageResource(R.drawable.penguin)
                            }else{
                                image_S.setImageResource(R.drawable.owl)
                            }
                        }
                    }
                }
            }
        }

    }
}

