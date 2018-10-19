package com.owrly.footballteams

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.owrly.footballteams.model.Club
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    companion object {
        private lateinit var club: Club
    }

    private lateinit var nameTextView: TextView
    private lateinit var descTextView: TextView
    private lateinit var logoImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout{
            padding = dip(16)
            logoImageView = imageView()
                    .lparams(dip(60),dip(60)){
                        gravity = Gravity.CENTER
                        margin = dip(8)
                    }
            nameTextView = textView()
            descTextView = textView()
        }

        val intent = intent
        club = intent.getParcelableExtra("club")

        Glide.with(this).load(club?.image).into(logoImageView)
        nameTextView.text = club?.name
        descTextView.text = club?.desc
    }
}
