package com.example.klapa.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.klapa.R
import com.example.klapa.data.model.BarangAdapter
import com.example.klapa.data.model.BarangModel
import com.example.klapa.data.model.GambarAdapter
import com.example.klapa.data.model.GambarModel

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val gambarList = listOf(
            GambarModel(R.drawable.gambar1),
            GambarModel(R.drawable.gambar2),
            GambarModel(R.drawable.gambar3),
            GambarModel(R.drawable.gambar4),
            GambarModel(R.drawable.gambar5),
            GambarModel(R.drawable.gambar6)
            // Tambahkan gambar sesuai kebutuhan
        )

        val gambarAdapter = GambarAdapter(gambarList)
        viewPager.adapter = gambarAdapter

        val barangList = listOf(
            BarangModel(R.drawable.barang1, "Barang 1", 10000),
            BarangModel(R.drawable.barang2, "Barang 2", 15000),
            BarangModel(R.drawable.barang3, "Barang 3", 20000),
            // Tambahkan barang sesuai kebutuhan
        )
        val barangAdapter = BarangAdapter(barangList)
        recyclerView.adapter = barangAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}
