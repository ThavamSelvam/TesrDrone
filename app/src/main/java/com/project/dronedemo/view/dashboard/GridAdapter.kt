package com.project.dronedemo.view.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.example.ResponseData
import com.project.dronedemo.R


class GridAdapter(val context: Context?, var data: List<ResponseData>, val onclick: Onclick) :
    RecyclerView.Adapter<GridAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_home_tiles, parent, false)
        );

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt.setText(data.get(position).title)
        holder.imageView.setImageResource(data.get(position).icon!!)
        holder.cons.setOnClickListener {
            data.get(position).title?.let { it1 -> onclick.onClicked(it1) }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun loaddata(listData: List<ResponseData>) {
        data = listData
        notifyDataSetChanged()
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val txt: TextView = itemView.findViewById(R.id.txtTitle)
        val imageView: AppCompatImageView = itemView.findViewById(R.id.imgTile)
        val cons: ConstraintLayout = itemView.findViewById(R.id.cons)
    }

    public interface Onclick {
        fun onClicked(str: String)
    }
}
