package com.project.dronedemo.view.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.ResponseData
import com.project.dronedemo.R
import com.project.dronedemo.utils.Constant
import com.project.dronedemo.view.dashboard.DashboardActivity
import com.project.dronedemo.view.dashboard.GridAdapter
import com.project.dronedemo.view.homeinnerlist.HomeFragmentInner
import com.project.dronedemo.view.homeinnerlist.InnerActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), GridAdapter.Onclick {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
     lateinit var rVGrid: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    lateinit var dashboardActivity: DashboardActivity

    lateinit var adapter: GridAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dashboardActivity= (activity as DashboardActivity?)!!
        rVGrid = view.findViewById(R.id.rvHomeTile)
        adapter = GridAdapter(context, getData(), this)
        val manager = GridLayoutManager(context, 2)
        rVGrid.layoutManager = manager
        rVGrid.setAdapter(adapter)
         super.onViewCreated(view, savedInstanceState)
    }

    private fun getData(): List<ResponseData> {
        val list: ArrayList<ResponseData> = ArrayList(0)
        val responseData = ResponseData()
        responseData.title = getString(R.string.drones)
        responseData.icon = R.drawable.drones_s
        list.add(responseData)

        val responseData1 = ResponseData()
        responseData1.title = getString(R.string.crop_input_selection)
        responseData1.icon = R.drawable.ic_baseline_crop_24

        list.add(responseData1)

        val responseData2 = ResponseData()
        responseData2.title = getString(R.string.tools_tech)
        responseData2.icon = R.drawable.ic_baseline_military_tech_24
        list.add(responseData2)

        val responseData3 = ResponseData()
        responseData3.title = getString(R.string.market_place)
        responseData3.icon = R.drawable.ic_baseline_bookmarks_24
        list.add(responseData3)

        val responseData4 = ResponseData()
        responseData4.title = getString(R.string.media)
        responseData4.icon = R.drawable.ic_baseline_perm_media_24
        list.add(responseData4)
        return list
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment()
    }

    override fun onClicked(str: String) {
        if (str.equals(getString(R.string.drones))) {
            callDroneList(getString(R.string.drones))
            return
        }
        if (str.equals(getString(R.string.media))) {
            callDroneList(getString(R.string.media))
            return
        }
        dashboardActivity.showBottomToast(getString(R.string.coming_soon))
    }

    private fun callDroneList(str: String) {
        startActivity(Intent(dashboardActivity,InnerActivity::class.java).putExtra(Constant.DATA,str))

    }
}