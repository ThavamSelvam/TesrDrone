package com.project.dronedemo.view.booking

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.project.dronedemo.R
import com.project.dronedemo.databinding.ActivityBookingBinding
import com.project.dronedemo.model.BookingList
import com.project.dronedemo.utils.Constant
import com.project.dronedemo.view.base.BaseActivity
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import java.util.*
import kotlin.collections.ArrayList


class BookingActivity : BaseActivity(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var bookingViewModel: BookingViewModel
    lateinit var binding: ActivityBookingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookingViewModel =
            ViewModelProvider(this@BookingActivity).get(BookingViewModel::class.java)
        binding =
            DataBindingUtil.setContentView(this@BookingActivity, R.layout.activity_booking)
        binding.viewModel = bookingViewModel
        val toolbar: Toolbar = findViewById(R.id.appbar)
        sharedPreferences = getSharedPreferences("appname", Context.MODE_PRIVATE)!!
        setSupportActionBar(toolbar)
        loadLiveDataModel()
        bookingViewModel.setActivity(this);
        binding.btnSubmit.setOnClickListener {
            if (binding.edtName.text.isNullOrEmpty() || binding.edtAddress.text!!.isBlank()) {
                binding.edtName.setError(getString(R.string.please_enter_user_name))
                return@setOnClickListener
            }
            if (binding.edtDateFrom.text.isNullOrEmpty() || binding.edtAddress.text!!.isBlank()) {
                binding.edtDateFrom.setError(getString(R.string.please_enter_date_from))
                return@setOnClickListener
            }
            if (binding.edtDateTo.text.isNullOrEmpty() || binding.edtAddress.text!!.isBlank()) {
                binding.edtDateTo.setError(getString(R.string.please_enter_date_to))
                return@setOnClickListener
            }
            if (binding.edtAddress.text.isNullOrEmpty() || binding.edtAddress.text!!.isBlank()) {
                binding.edtAddress.setError(getString(R.string.please_enter_address))
                return@setOnClickListener
            }
            if (binding.edtAreaLength.text.isNullOrEmpty() || binding.edtAddress.text!!.isBlank()) {
                binding.edtAreaLength.setError(getString(R.string.please_enter_area))
                return@setOnClickListener
            }
            saveToPref()
        }
        binding.consDateFrom.setOnClickListener {
            isDateFromClicked = true
            callDatePicker()
        }
        binding.grpDateTo.setOnClickListener {
            isDateFromClicked = false
            callDatePicker()
        }
    }

    var isDateFromClicked = false

    fun callDatePicker() {
        val now = Calendar.getInstance()
        DatePickerDialog.newInstance(
            this@BookingActivity,

            now[Calendar.YEAR],  // Initial year selection
            now[Calendar.MONTH],  // Initial month selection
            now[Calendar.DAY_OF_MONTH] // Inital day selection
        ).show(supportFragmentManager, "dialog")
    }

    private fun saveToPref() {
        val bookingList = BookingList()
        bookingList.dateFrom = binding.edtDateTo.text.toString()
        bookingList.dateTo = binding.edtDateTo.text.toString()
        bookingList.acre = binding.edtAreaLength.text.toString()
        bookingList.name = binding.edtName.text.toString()
        bookingList.address = binding.edtAddress.text.toString()
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        if (sharedPreferences.getString(Constant.DRONE, "").toString().isEmpty()) {
            val arrayList: ArrayList<BookingList> = ArrayList()
            arrayList.add(bookingList)
            editor.putString(Constant.DRONE, Gson().toJson(arrayList))
        } else {
            val list: ArrayList<BookingList> = Gson().fromJson<ArrayList<BookingList>>(
                sharedPreferences.getString(
                    Constant.DRONE,
                    ""
                ), ArrayList::class.java
            )
            list.add(0, bookingList)
            editor.putString(Constant.DRONE, Gson().toJson(list))
        }
        editor.apply()
        editor.commit()
        showBottomToast(getString(R.string.date_saved))
        finish()
    }

    private fun loadLiveDataModel() {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_help_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.help_icon) {
            showBottomToast(getString(R.string.help))
        }
        return super.onOptionsItemSelected(item)
    }

    var date = ""
    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        date = "" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year
        val now = Calendar.getInstance()
        TimePickerDialog.newInstance(
            this@BookingActivity,
            now[Calendar.HOUR_OF_DAY],
            now[Calendar.MINUTE],
            false
        ).show(supportFragmentManager, "time")
    }

    override fun onTimeSet(view: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int) {
        val hourString = if (hourOfDay < 10) "0$hourOfDay" else "" + hourOfDay
        val minuteString = if (minute < 10) "0$minute" else "" + minute
        val secondString = if (second < 10) "0$second" else "" + second
        val time =
            "" + hourString + "h" + minuteString + "m" + secondString + "s"
        date + time;
        if (isDateFromClicked)
            binding.edtDateFrom.setText("" + date + time)
        else binding.edtDateTo.setText("" + date + time)

    }

}