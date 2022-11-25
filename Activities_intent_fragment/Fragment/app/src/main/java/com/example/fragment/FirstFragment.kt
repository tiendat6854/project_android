package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        Toast.makeText(context, "onCreateView", Toast.LENGTH_SHORT).show()
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(context, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(context, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(context, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(context, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(context, "onDestroy", Toast.LENGTH_SHORT).show()
    }

}