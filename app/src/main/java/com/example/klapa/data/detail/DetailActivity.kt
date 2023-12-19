package com.example.klapa.data.detail


import BarangModel
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.klapa.R



class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageViewDetail: ImageView = findViewById(R.id.imageViewDetail)
        val namaProduk: TextView = findViewById(R.id.namaProduk)
        val hargaProduk: TextView = findViewById(R.id.hargaProduk)
        val diskonProduk: TextView = findViewById(R.id.diskonProduk)
        val detailProduk: TextView = findViewById(R.id.detailProduk)
        val deskripsiProduk: TextView = findViewById(R.id.deskripsiProduk)

        // Terima data barang dari intent
        val barangModel: BarangModel? = intent.getParcelableExtra("barang")

        // Tampilkan informasi barang
        if (barangModel != null) {
            imageViewDetail.setImageResource(barangModel.drawableResId)
            namaProduk.text = barangModel.nama
            hargaProduk.text = "Harga: ${barangModel.harga}"
            diskonProduk.text = "Diskon: ${barangModel.diskon}%"

            // Mengatur detail produk dengan multiline text
            // Mengatur detail produk dengan multiline text
            val detailText = barangModel?.formatDetailProduk() ?: ""
            detailProduk.text = detailText


            // Mengatur deskripsi produk dengan multiline text
            deskripsiProduk.text = barangModel.deskripsi
        }

    }
}