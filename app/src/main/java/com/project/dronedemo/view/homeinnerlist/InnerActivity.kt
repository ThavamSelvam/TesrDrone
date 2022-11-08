package com.project.dronedemo.view.homeinnerlist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.ResponseData
import com.project.dronedemo.R
import com.project.dronedemo.model.BookingList
import com.project.dronedemo.utils.Constant
import com.project.dronedemo.view.base.BaseActivity
import com.project.dronedemo.view.bookedlist.BookedListActivity
import com.project.dronedemo.view.booking.BookingActivity


class InnerActivity : BaseActivity(), InnerMenuGridAdapter.OnClickEvent {
    lateinit var appBarLayout: Toolbar
    lateinit var rVGrid: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inner_activity)
        appBarLayout = findViewById(R.id.appbar)
        setSupportActionBar(appBarLayout);
        rVGrid = findViewById(R.id.rvHomeTile)
        val data = intent.getStringExtra(Constant.DATA).toString()
        val manager = GridLayoutManager(this@InnerActivity, 2)
        rVGrid.layoutManager = manager
        var list: List<ResponseData> = getDroneList()
        when (data) {
            getString(R.string.drones) -> list = getDroneList()
            getString(R.string.media) -> list = getMediaTiles()
            else -> showBottomToast(getString(R.string.coming_soon))

        }
        val adapter = InnerMenuGridAdapter(this@InnerActivity, list, this)
        rVGrid.setAdapter(adapter)
    }

    fun openWhatsApp() {
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Ask your query")
        sendIntent.type = "text/plain"
        sendIntent.setPackage("com.whatsapp")
        startActivity(Intent.createChooser(sendIntent, ""))
        startActivity(sendIntent)
    }

    private fun getDroneList(): List<ResponseData> {
        val list: ArrayList<ResponseData> = ArrayList(0)
        val responseData = ResponseData()
        responseData.title = getString(R.string.buy)
        responseData.icon = R.drawable.cart
        list.add(responseData)

        val responseData1 = ResponseData()
        responseData1.title = getString(R.string.rent)
        responseData1.icon = R.drawable.house
        list.add(responseData1)

        val responseData2 = ResponseData()
        responseData2.title = getString(R.string.traing)
        responseData2.icon = R.drawable.presentation
        list.add(responseData2)

        val responseData3 = ResponseData()
        responseData3.title = getString(R.string.book_service)
        responseData3.icon = R.drawable.customer_service
        list.add(responseData3)

        val responseData4 = ResponseData()
        responseData4.title = getString(R.string.service_and_repair)
        responseData4.icon = R.drawable.support
        list.add(responseData4)
        return list
    }

    private fun getMediaTiles(): List<ResponseData> {
        val list: ArrayList<ResponseData> = ArrayList(0)
        val responseData = ResponseData()
        responseData.title = getString(R.string.video)
        responseData.icon = R.drawable.ic_baseline_ondemand_video_24
        list.add(responseData)

        val responseData1 = ResponseData()
        responseData1.title = getString(R.string.read_blog)
        responseData1.icon = R.drawable.support

        list.add(responseData1)

        val responseData2 = ResponseData()
        responseData2.title = getString(R.string.chat)
        responseData2.icon = R.drawable.ic_baseline_call_24
        list.add(responseData2)
        return list
    }

    override fun onVieClick(str: String) {
        if (getString(R.string.chat).equals(str)) {
            openWhatsApp()
        }
        if (getString(R.string.rent).equals(str)) {
            openBooking()
        }
        if (getString(R.string.book_service).equals(str)) {
            openBookingList()
        }
    }

    private fun openBookingList() {
        startActivity(Intent(this@InnerActivity, BookedListActivity::class.java))

    }

    private fun openBooking() {
        startActivity(Intent(this@InnerActivity, BookingActivity::class.java))
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