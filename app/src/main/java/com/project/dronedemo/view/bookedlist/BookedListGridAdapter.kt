package com.project.dronedemo.view.bookedlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.example.ResponseData
import com.project.dronedemo.R
import com.project.dronedemo.model.BookingList


class BookedListGridAdapter(
    val context: Context?,
    val data: List<BookingList>,
    val click: OnClickEvent
) :
    RecyclerView.Adapter<BookedListGridAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_booked_deatails_tiles, parent, false)
        );

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bookingList = data.get(position);

        holder.txt.setText(
            "" +context?.getString(R.string.name)
                    + "     : " + bookingList.name + "\n" +
                    context?.getString(R.string.date_from) + " : " + bookingList.dateFrom + "\n" + context?.getString(
                R.string.date_to
            ) + " : " + bookingList.dateTo + "\n" +
                    context?.getText(R.string.address) + " : " + bookingList.address + "\n" + context?.getString(
                R.string.acre
            ) + "     : " + bookingList.acre
        )
        // holder.txtHint.setText(
        holder.cons.setOnClickListener {
            click.onVieClick(bookingList)
        }
    }


    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val txt: TextView = itemView.findViewById(R.id.txtNames)
        val txtHint: TextView = itemView.findViewById(R.id.txtNameHint)
        val cons: ConstraintLayout = itemView.findViewById(R.id.cons)
    }

    interface OnClickEvent {
        fun onVieClick(str: BookingList);
    }

}


