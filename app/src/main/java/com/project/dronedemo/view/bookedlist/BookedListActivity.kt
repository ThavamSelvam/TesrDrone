package com.project.dronedemo.view.bookedlist

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.project.dronedemo.R
import com.project.dronedemo.model.BookingList
import com.project.dronedemo.utils.Constant
import com.project.dronedemo.view.base.BaseActivity
import java.lang.reflect.Type


class BookedListActivity : BaseActivity(), BookedListGridAdapter.OnClickEvent {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var appBarLayout: Toolbar
    lateinit var rVGrid: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inner_activity)
        appBarLayout = findViewById(R.id.appbar)
        setSupportActionBar(appBarLayout);
        rVGrid = findViewById(R.id.rvHomeTile)
        val manager = GridLayoutManager(this@BookedListActivity, 1)
        rVGrid.layoutManager = manager
        sharedPreferences = getSharedPreferences("appname", Context.MODE_PRIVATE)!!

        val gson = Gson()
        val type: Type = object : TypeToken<List<BookingList?>?>() {}.type
        var list: List<BookingList> = ArrayList()
        if (sharedPreferences.getString(
                Constant.DRONE, ""
            ).equals("")
        ) {
            list = ArrayList()
        } else {
            list = gson.fromJson(
                sharedPreferences.getString(
                    Constant.DRONE, ""
                ), type
            )
        }
        val adapter = BookedListGridAdapter(this@BookedListActivity, list, this)
        rVGrid.setAdapter(adapter)
    }


    override fun onVieClick(str: BookingList) {

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home_help_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        if (id == R.id.help_icon) {
            showBottomToast(getString(R.string.help))
        }
        return super.onOptionsItemSelected(item)
    }

}