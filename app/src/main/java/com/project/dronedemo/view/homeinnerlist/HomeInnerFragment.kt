package com.project.dronedemo.view.homeinnerlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.ResponseData
import com.project.dronedemo.R
import com.project.dronedemo.utils.Constant

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragmentInner.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragmentInner : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rVGrid = view.findViewById(R.id.rvHomeTile)
        val manager = GridLayoutManager(context, 2)
        rVGrid.layoutManager = manager
        val list: List<ResponseData>
        when (param1) {
            getString(R.string.drones) -> list = getDroneList()
            else -> list = getMediaTiles()
        }
        //val adapter = InnerMenuGridAdapter(context, list)
     //1   rVGrid.setAdapter(adapter)
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
        responseData.icon = R.drawable.support
        list.add(responseData)

        val responseData1 = ResponseData()
        responseData1.title = getString(R.string.read_blog)
        responseData1.icon = R.drawable.support

        list.add(responseData1)

        val responseData2 = ResponseData()
        responseData2.title = getString(R.string.chat)
        responseData2.icon = R.drawable.support

        list.add(responseData2)
        return list
    }


    companion object {
        @JvmStatic
        fun newInstance(fromDate: String) =
            HomeFragmentInner().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, fromDate)
                }
            }
    }
}