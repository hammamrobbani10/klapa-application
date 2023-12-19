package com.example.klapa.data.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.klapa.R

class GambarAdapter(private val gambarList: List<GambarModel>) : RecyclerView.Adapter<GambarAdapter.GambarViewHolder>() {

    inner class GambarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageListView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GambarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gambar, parent, false)
        return GambarViewHolder(view)
    }

    override fun onBindViewHolder(holder: GambarViewHolder, position: Int) {
        val gambar = gambarList[position]

        // Menggunakan Glide untuk memuat gambar dari drawable dengan ukuran yang diatur
        Glide.with(holder.itemView.context)
            .load(gambar.drawableResId) // Menggunakan ID drawable dari GambarModel
            .centerCrop()
            .override(600, 600) // Mengatur ukuran gambar yang di-load
            .into(holder.imageView)
    }


    override fun getItemCount(): Int {
        return gambarList.size
    }
}