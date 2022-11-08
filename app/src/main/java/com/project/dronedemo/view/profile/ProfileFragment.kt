package com.project.dronedemo.view.profile

import android.Manifest
import android.R.attr.data
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.MediaRecorder.VideoSource.CAMERA
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.project.dronedemo.R
import com.project.dronedemo.databinding.FragmentProfileBinding
import com.project.dronedemo.utils.Constant.Companion.PROFILE


// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProfileFragment : Fragment() {
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

    lateinit var sharedPreferences: SharedPreferences


    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {    //    return inflater.inflate(R.layout.fragment_profile, container, false)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = context?.getSharedPreferences("appname", Context.MODE_PRIVATE)!!
        binding.imgProfile.setOnClickListener {

            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_DENIED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CAMERA),
                    111
                )
            } else {
                openCamera()
            }
        }

        setValues()
        binding.btnSubmit.setOnClickListener {

            var profile =
                binding.edtName.text.toString() + "," + binding.edtNumber.text.toString() + "," + binding.edtType.text.toString() + "" + binding.edtLocation.text.toString() + "," + binding.edtPin.text.toString()
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("Name", binding.edtName.text.toString())
            editor.putString("number", binding.edtNumber.text.toString())
            editor.putString("type", binding.edtType.text.toString())
            editor.putString("location", binding.edtLocation.text.toString())
            editor.putString("pin", binding.edtPin.text.toString())
            editor.apply()
            editor.commit()
            Toast.makeText(context, "Profile saved successfully", Toast.LENGTH_LONG).show()
            
        }
    }

    private fun setValues() {

        binding.edtName.setText(sharedPreferences.getString("Name", ""))
        binding.edtNumber.setText(sharedPreferences.getString("number", ""))
        binding.edtType.setText(sharedPreferences.getString("type", ""))
        binding.edtLocation.setText(sharedPreferences.getString("location", ""))
        binding.edtPin.setText(sharedPreferences.getString("pin", ""))
    }


    fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultLauncher.launch(intent)
    }

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val datas: Intent? = result.data
                val photo = datas?.getExtras()?.get("data") as Bitmap

                binding.imgProfile.setImageBitmap(photo)
            }
        }


    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}