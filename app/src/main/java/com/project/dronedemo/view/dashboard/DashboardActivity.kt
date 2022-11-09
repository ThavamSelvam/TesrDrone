package com.project.dronedemo.view.dashboard

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import com.project.dronedemo.R
import com.project.dronedemo.libs.bottombar.OnItemSelectedListener
import com.project.dronedemo.libs.bottombar.SuperBottomBar
import com.project.dronedemo.view.base.BaseActivity
import com.project.dronedemo.view.home.HomeFragment
import com.project.dronedemo.view.profile.ProfileFragment
import com.project.dronedemo.view.service.ServiceFragment


class DashboardActivity : BaseActivity() {
    lateinit var appBarLayout: Toolbar
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        appBarLayout=findViewById(R.id.appbar)
        setSupportActionBar(appBarLayout);
        sharedPreferences =  getSharedPreferences("appname", Context.MODE_PRIVATE)!!
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean("USERLOGIN",true)
        val bottomBar: SuperBottomBar = findViewById(R.id.bottomBar)
         replaceFragment(0)
        bottomBar.setOnItemSelectListener(object : OnItemSelectedListener {
            override fun onItemSelect(pos: Int) {
                replaceFragment(pos)
            }
        })

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

    fun replaceFragment(pos: Int) {

        val fragment: Fragment

        when (pos) {
            0 -> fragment = HomeFragment.newInstance()

            1 -> fragment = ServiceFragment.newInstance()

            else -> fragment = ProfileFragment.newInstance()
        }
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flContainer, fragment)
        transaction.addToBackStack(null);
        transaction.commit()
    }
}