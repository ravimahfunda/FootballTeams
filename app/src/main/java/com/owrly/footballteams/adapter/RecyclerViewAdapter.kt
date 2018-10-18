package com.owrly.footballteams.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.owrly.footballteams.R
import com.owrly.footballteams.model.Club
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*

/**
 * Created by ravimahfunda on 19/10/2018.
 */
class RecyclerViewAdapter(private val context: Context, private val clubs: List<Club>, private val listener: (Club) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(clubs[position], listener, context)
    }

    override fun getItemCount(): Int = clubs.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        fun bindItem(items: Club, listener: (Club) -> Unit, context: Context) {
            name.text = items.name
            Glide.with(context).load(items.image).into(image)
            containerView.setOnClickListener { listener(items) }
        }
    }
}