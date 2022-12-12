package com.example.projek

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projek.adapter.AplikasiAdapter
import com.example.projek.databinding.FragmentHomeBinding
import com.example.projek.model.DataAplikasi


class HomeFragment : Fragment() {
    private lateinit var aplikasiAdapter: AplikasiAdapter
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val dataDummy = arrayListOf(
        DataAplikasi(
            R.drawable.one,
            "Spotify Subscription",
            "Entertainment","10.14 AM", "-$9.99"),
        DataAplikasi(
            R.drawable.four,
            "Dyana",
            "Gift","10.14 AM", "+$9.99"),
        DataAplikasi(
            R.drawable.three,
            "Steam",
            "Entertainment","10.14 AM", "-$9.99"),
        DataAplikasi(
            R.drawable.two,
            "Marline",
            "Gift","10.14 AM", "+$9.99"),
        DataAplikasi(
            R.drawable.one,
            "Spotify Subscription",
            "Entertainment","10.14 AM", "-$9.99"),
        DataAplikasi(
            R.drawable.four,
            "Dyana",
            "Gift","10.14 AM", "+$9.99"),
        DataAplikasi(
            R.drawable.three,
            "Steam",
            "Entertainment","10.14 AM", "-$9.99"),
        DataAplikasi(
            R.drawable.two,
            "Marline",
            "Gift","10.14 AM", "+$9.99")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.topUp.setOnClickListener{
            val i = Intent(this@HomeFragment.requireContext(), Top_Up::class.java)
            startActivity(i)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        aplikasiAdapter = AplikasiAdapter(requireContext())
        binding.rvList.apply {
            setHasFixedSize(true)
            layoutManager =  object : LinearLayoutManager(requireContext()) {
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
            adapter = aplikasiAdapter
        }

        aplikasiAdapter.setData(dataDummy)
    }

}

