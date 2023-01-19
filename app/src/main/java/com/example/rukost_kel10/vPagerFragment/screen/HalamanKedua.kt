package com.example.rukost_kel10.vPagerFragment.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.rukost_kel10.R
import com.example.rukost_kel10.databinding.FragmentHalamanKeduaBinding

class HalamanKedua : Fragment() {

    private  lateinit var  binding : FragmentHalamanKeduaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_halaman_kedua,
            container, false)
        binding = FragmentHalamanKeduaBinding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.txtHalNext2.setOnClickListener{
            viewPager?.currentItem = 2
        }
        return view
    }
}