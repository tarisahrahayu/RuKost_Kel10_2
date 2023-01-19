package com.example.rukost_kel10.vPagerFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rukost_kel10.R
import com.example.rukost_kel10.ViewPagerAdapter
import com.example.rukost_kel10.databinding.FragmentViewPagerBinding
import com.example.rukost_kel10.vPagerFragment.screen.HalamanKedua
import com.example.rukost_kel10.vPagerFragment.screen.HalamanKetiga
import com.example.rukost_kel10.vPagerFragment.screen.HalamanPertama


class ViewPagerFragment : Fragment() {

    lateinit var  binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        binding = FragmentViewPagerBinding.bind(view)
        val fragmentList = arrayListOf(
            HalamanPertama(),
            HalamanKedua(),
            HalamanKetiga()
        )

        val adapter = ViewPagerAdapter(fragmentList,
            requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        return  view
    }

}