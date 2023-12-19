package com.example.klapa.data.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.klapa.R

class BarangAdapter(private val barangList: List<BarangModel>) : RecyclerView.Adapter<BarangAdapter.BarangViewHolder>() {

    private var filteredList: List<BarangModel> = barangList
    private var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(barang: BarangModel)
    }

    inner class BarangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val namaTextView: TextView = itemView.findViewById(R.id.namaTextView)
        val hargaTextView: TextView = itemView.findViewById(R.id.hargaTextView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener?.onItemClick(filteredList[position])
                }
            }
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_barang, parent, false)
        return BarangViewHolder(view)
    }

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        val barang = filteredList[position]

        // Menggunakan Glide untuk memuat gambar dari drawable dengan ukuran yang diatur
        Glide.with(holder.itemView.context)
            .load(barang.drawableResId)
            .centerCrop()
            .override(1000, 1000)
            .into(holder.imageView)

        holder.namaTextView.text = barang.nama
        holder.hargaTextView.text = "Rp ${barang.harga}"
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            barangList
        } else {
            barangList.filter { barang ->
                barang.nama.toLowerCase().contains(query.toLowerCase())
            }
        }
        notifyDataSetChanged()
    }
}
