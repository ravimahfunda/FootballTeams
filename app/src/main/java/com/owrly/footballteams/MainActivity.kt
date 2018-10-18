package com.owrly.footballteams

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.recyclerview.R.attr.layoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.owrly.footballteams.adapter.RecyclerViewAdapter
import com.owrly.footballteams.model.Club
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        private var clubs: MutableList<Club> = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

        initData()
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

            relativeLayout{
                lparams(matchParent, matchParent)
                recyclerView {
                    layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                    adapter = RecyclerViewAdapter(context, clubs){
                        val toast = Toast.makeText(context, it.name, Toast.LENGTH_SHORT)
                        toast.show()
                        startActivity<DetailActivity>("club" to it)
                    }
                }.lparams(matchParent, wrapContent)

            }
        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_desc)
        clubs.clear()
        for (i in name.indices) {
            clubs.add(
                    Club(name[i], image.getResourceId(i, 0), desc[i])
            )
        }

        //Recycle the typed array
        image.recycle()
    }
}
