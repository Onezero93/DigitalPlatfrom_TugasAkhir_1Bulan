package com.example.projek.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.projek.databinding.ItemListBinding
import com.example.projek.model.DataAplikasi

class AplikasiAdapter(private val content: Context) :
    RecyclerView.Adapter<AplikasiAdapter.AplikasiViewHolder>() {

    private val list = ArrayList<DataAplikasi>()

    fun setData(listParams: List<DataAplikasi>) {
        list.clear()
        list.addAll(listParams)
        notifyDataSetChanged()
    }
    inner class AplikasiViewHolder(private val binding: ItemListBinding)
        :ViewHolder(binding.root){

                fun bind(data: DataAplikasi){
                    binding.mg.setImageResource(data.image)
                    binding.ss.text = data.nama
                binding.tl.text = data.des
                binding.jm.text = data.jam
                binding.dl.text = data.rating.toString()
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AplikasiViewHolder (
        ItemListBinding.inflate(LayoutInflater.from(content),parent,false)
    )

    override fun onBindViewHolder(holder: AplikasiViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}