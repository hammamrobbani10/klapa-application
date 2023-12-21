package com.example.klapa.data.detail

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.klapa.R
import BarangModel
import android.widget.ImageButton
import com.example.klapa.data.chatbot.ChatBotActivity

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
        val backButton: ImageView = findViewById(R.id.backButton)
        val messageButton: ImageButton = findViewById(R.id.messageButton)

        // Terima data barang dari intent
        val barangModel: BarangModel? = intent.getParcelableExtra("barang")

        // Tampilkan informasi barang
        if (barangModel != null) {
            imageViewDetail.setImageResource(barangModel.drawableResId)
            namaProduk.text = barangModel.nama
            hargaProduk.text = "Harga: ${barangModel.harga}"
            diskonProduk.text = "Diskon: ${barangModel.diskon}%"

            // Mengatur detail produk dengan multiline text
            val detailText = "Detail Product\n\n" +
                    "Kondisi: ${barangModel.kondisi}\n" +
                    "Min.Pemesanan: ${barangModel.pesanan}\n" +
                    "Kategori: ${barangModel.kategori}"
            detailProduk.text = detailText

            // Mengatur deskripsi produk dengan multiline text
            deskripsiProduk.text = barangModel.deskripsi
        }

        // Menangani klik tombol back
        backButton.setOnClickListener {
            onBackPressed()
        }

        // Menangani klik tombol pesan
        messageButton.setOnClickListener {
            // Membuat Intent untuk memulai ChatBotActivity
            val intent = Intent(this, ChatBotActivity::class.java)
            startActivity(intent)
        }
    }
}
