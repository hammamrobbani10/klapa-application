package com.example.klapa.data.chatbot

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.klapa.R

class ChatBotActivity : AppCompatActivity() {

    private lateinit var etMessage: EditText
    private lateinit var btnSend: Button
    private lateinit var rvMessages: RecyclerView
    private lateinit var messageAdapter: MessageAdapter
    private val messages = mutableListOf<MessageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_bot)

        etMessage = findViewById(R.id.et_message)
        btnSend = findViewById(R.id.btn_send)
        rvMessages = findViewById(R.id.rv_messages)

        messageAdapter = MessageAdapter(messages)
        rvMessages.adapter = messageAdapter

        val layoutManager = LinearLayoutManager(this)
        rvMessages.layoutManager = layoutManager

        btnSend.setOnClickListener {
            sendMessage()
        }
    }

    private var lastUserMessage: String = ""

    private fun sendMessage() {
        val userMessage = etMessage.text.toString().trim()

        // User message
        val userMessageModel = MessageModel(userMessage, false)
        if (userMessageModel.message.isNotBlank()){
            messageAdapter.addMessage(userMessageModel)
        }
        //messageAdapter.addMessage(userMessageModel)

        // Check if the user message is the same as the previous one
        if (userMessage.isNotBlank()) {
            // Bot reply (you need to implement the logic to generate bot replies)
            val botReply = generateBotReply(userMessage)

            // Add bot reply only if it's not blank
            if (botReply.isNotBlank()) {
                val botReplyModel = MessageModel(botReply, true)
                messageAdapter.addMessage(botReplyModel)
            }

            // Update the last user message
            lastUserMessage = userMessage
        }

        // Clear the input field
        etMessage.text.clear()

        // Scroll to the last message
        rvMessages.smoothScrollToPosition(messageAdapter.itemCount - 1)
    }

    private fun generateBotReply(userMessage: String): String {
        return when {

            userMessage.contains("Hai", ignoreCase = true) ||
                    userMessage.contains("Selamat pagi", ignoreCase = true) ||
                    userMessage.contains("Selamat siang", ignoreCase = true) ||
                    userMessage.contains("Selamat malam", ignoreCase = true) ||
                    userMessage.contains("Apa kabar?", ignoreCase = true) ||
                    userMessage.contains("Halo", ignoreCase = true) ||
                    userMessage.contains("Hei", ignoreCase = true) ||
                    userMessage.contains("halo kak", ignoreCase = true) ||
                    userMessage.contains("hai kak", ignoreCase = true) -> "Halo selamat datang di Klapa! Ada yang bisa kami bantu?"
            userMessage.contains("saya ingin bertanya", ignoreCase = true) ||
                    userMessage.contains("saya bertanya", ignoreCase = true) ||
                    userMessage.contains("bagaimana", ignoreCase = true) ||
                    userMessage.contains("saya butuh bantuan", ignoreCase = true) ||
                    userMessage.contains("mau tanya", ignoreCase = true) ||
                    userMessage.contains("nanya", ignoreCase = true) ||
                    userMessage.contains("informasi", ignoreCase = true) ||
                    userMessage.contains("info", ignoreCase = true) ||
                    userMessage.contains("mau nanya dong", ignoreCase = true) -> "Saya siap menjawab berbagai pertanyaan untuk membantu anda."
            userMessage.contains("Sampai jumpa", ignoreCase = true) ||
                    userMessage.contains("Selamat tinggal", ignoreCase = true) ||
                    userMessage.contains("Terima kasih", ignoreCase = true) ||
                    userMessage.contains("Sampai jumpa lagi", ignoreCase = true) ||
                    userMessage.contains("Goodbye", ignoreCase = true) ||
                    userMessage.contains("Bye", ignoreCase = true) ||
                    userMessage.contains("Sampai bertemu lagi", ignoreCase = true) ||
                    userMessage.contains("Terima kasih sudah menjawab.", ignoreCase = true) ||
                    userMessage.contains("Selamat tinggal, semoga harimu menyenangkan", ignoreCase = true) ||
                    userMessage.contains("Bye bye", ignoreCase = true) ||
                    userMessage.contains("Sampai jumpa nanti", ignoreCase = true) ||
                    userMessage.contains("terima kasih", ignoreCase = true) ||
                    userMessage.contains("terimakasih", ignoreCase = true) ||
                    userMessage.contains("makasih", ignoreCase = true) ||
                    userMessage.contains("makasi", ignoreCase = true) ||
                    userMessage.contains("oke kak terimakasih", ignoreCase = true) -> "Sampai jumpa! Jangan ragu untuk kembali."
            userMessage.contains("siapa nama developermu", ignoreCase = true) ||
                    userMessage.contains("siapa nama penciptamu", ignoreCase = true) ||
                    userMessage.contains("siapa nama pengembangmu", ignoreCase = true) ||
                    userMessage.contains("siapa nama pencipta", ignoreCase = true) ||
                    userMessage.contains("siapa yang menciptakanmu", ignoreCase = true) ||
                    userMessage.contains("pengembangmu", ignoreCase = true) ||
                    userMessage.contains("penciptamu", ignoreCase = true) ||
                    userMessage.contains("siapa pengembangmu", ignoreCase = true) ||
                    userMessage.contains("developer", ignoreCase = true) ||
                    userMessage.contains("kamu dibuat oleh siapa", ignoreCase = true) ||
                    userMessage.contains("siapa yang membuatmu", ignoreCase = true) ||
                    userMessage.contains("creators", ignoreCase = true) ||
                    userMessage.contains("siapa yang membuatmu", ignoreCase = true) ||
                    userMessage.contains("siapa yang merancangmu", ignoreCase = true) -> "Tim Bangkit 2023 Batch 2. Kelompok CH2-PS597"
            userMessage.contains("aplikasi", ignoreCase = true) ||
                    userMessage.contains("apa yang dijual aplikasi ini?", ignoreCase = true) ||
                    userMessage.contains("aplikasi ini tentang apa?", ignoreCase = true) ||
                    userMessage.contains("apa yang ditawarkan aplikasi ini?", ignoreCase = true) ||
                    userMessage.contains("aplikasi apa ini?", ignoreCase = true) ||
                    userMessage.contains("ini aplikasi apa?", ignoreCase = true) ||
                    userMessage.contains("jual", ignoreCase = true) ||
                    userMessage.contains("dijual", ignoreCase = true) ||
                    userMessage.contains("informasi aplikasi", ignoreCase = true) ||
                    userMessage.contains("jual apa?", ignoreCase = true) -> "Ini adalah aplikasi Klapa, e-commerce yang menawarkan layanan jual beli produk berbahan dasar kelapa, mulai dari bibit, akar, batang, daun, dan buah."
            userMessage.contains("Apa produk yang tersedia?", ignoreCase = true) ||
                    userMessage.contains("Saya mencari produk tertentu", ignoreCase = true) ||
                    userMessage.contains("Saya butuh bantuan memilih produk", ignoreCase = true) ||
                    userMessage.contains("produk", ignoreCase = true) ||
                    userMessage.contains("informasi produk", ignoreCase = true) -> "Produk yang tersedia semua berbahan dasar Kelapa, kami memiliki beberapa produk mulai dari bibit, batang, daun, dan buah Kelapa."
            userMessage.contains("Apa saja kriteria produk yang anda jual?", ignoreCase = true) ||
                    userMessage.contains("Kategori produk apa saja yang ada?", ignoreCase = true) ||
                    userMessage.contains("Sebutkan kategori produk anda", ignoreCase = true) ||
                    userMessage.contains("ada produk apa saja", ignoreCase = true) ||
                    userMessage.contains("apa yang tersedia di aplikasi ini", ignoreCase = true) -> "Kami memiliki beberapa kategori produk mulai dari bibit, batang, daun, dan buah Kelapa."
            userMessage.contains("Bagaimana cara melakukan pemesanan?", ignoreCase = true) ||
                    userMessage.contains("Saya ingin memesan produk", ignoreCase = true) ||
                    userMessage.contains("Cara beli barang", ignoreCase = true) ||
                    userMessage.contains("Saya ingin melakukan order", ignoreCase = true) ||
                    userMessage.contains("Langkah-langkah pemesanan", ignoreCase = true) ||
                    userMessage.contains("Bagaimana cara checkout?", ignoreCase = true) ||
                    userMessage.contains("Proses pemesanan", ignoreCase = true) ||
                    userMessage.contains("Cara konfirmasi pesanan", ignoreCase = true) ||
                    userMessage.contains("Bagaimana cara memesan produk?", ignoreCase = true) ||
                    userMessage.contains("Saya ingin mengatur pemesanan saya", ignoreCase = true) ||
                    userMessage.contains("pemesanan", ignoreCase = true) ||
                    userMessage.contains("pesanan", ignoreCase = true) ||
                    userMessage.contains("memesan", ignoreCase = true) -> "Proses pemesanan sangat mudah! Pilih produk yang ingin Anda beli, tambahkan ke keranjang, dan ikuti langkah-langkah checkout. Setelah itu, pesanan Anda akan segera diproses."
            userMessage.contains("Bagaimana cara melihat keranjang belanja saya?", ignoreCase = true) ||
                    userMessage.contains("Apa yang ada di dalam keranjang saya?", ignoreCase = true) ||
                    userMessage.contains("Saya ingin melihat barang di keranjang", ignoreCase = true) ||
                    userMessage.contains("Cara mengatur keranjang belanja", ignoreCase = true) ||
                    userMessage.contains("Apakah barang di keranjang akan disimpan?", ignoreCase = true) ||
                    userMessage.contains("Bagaimana cara checkout dari keranjang?", ignoreCase = true) ||
                    userMessage.contains("Saya ingin mengecek produk di keranjang belanja saya", ignoreCase = true) ||
                    userMessage.contains("keranjang", ignoreCase = true) ||
                    userMessage.contains("cek keranjang", ignoreCase = true) -> "Anda dapat melihat keranjang belanja Anda dengan mengklik ikon keranjang di bagian atas halaman. Di sana, Anda bisa melihat dan mengatur produk yang ada di keranjang."
            userMessage.contains("Bagaimana aturan keranjang?", ignoreCase = true) ||
                    userMessage.contains("Apa saja kebijakan pada fitur keranjang?", ignoreCase = true) ||
                    userMessage.contains("kebijakan keranjang", ignoreCase = true) ||
                    userMessage.contains("Aturan keranjang", ignoreCase = true) -> "Barang di keranjang anda akan disimpan selama produk tersedia, sehingga ketersediaan produk pada keranjang tidak dijamin hingga Anda menyelesaikan proses checkout."
            userMessage.contains("Bagaimana cara menambahkan produk ke keranjang?", ignoreCase = true) ||
                    userMessage.contains("Bagaimana cara tambah keranjang?", ignoreCase = true) ||
                    userMessage.contains("Tambah produk ke keranjang", ignoreCase = true) ||
                    userMessage.contains("Saya ingin menambahkan produk ke keranjang", ignoreCase = true) ||
                    userMessage.contains("Saya ingin menambahkan item ke keranjang", ignoreCase = true) ||
                    userMessage.contains("Tambah produk", ignoreCase = true) ||
                    userMessage.contains("tambah pesanan", ignoreCase = true) ||
                    userMessage.contains("cara menambah pesanan", ignoreCase = true) ||
                    userMessage.contains("cara cek keranjang", ignoreCase = true) -> "Untuk menambahkan produk ke keranjang, kunjungi halaman produk, pilih produk yang diinginkan, dan klik tombol 'Tambahkan ke Keranjang'."
            userMessage.contains("Bagaimana menghapus produk dari keranjang", ignoreCase = true) ||
                    userMessage.contains("Menghapus produk dari keranjang", ignoreCase = true) ||
                    userMessage.contains("Mengurangi produk dari keranjang", ignoreCase = true) ||
                    userMessage.contains("Saya ingin menghapus item dari keranjang", ignoreCase = true) ||
                    userMessage.contains("hapus keranjang", ignoreCase = true) ||
                    userMessage.contains("hapus produk", ignoreCase = true) ||
                    userMessage.contains("hapus item", ignoreCase = true) ||
                    userMessage.contains("hapus belanjaan", ignoreCase = true) -> "Jika Anda ingin menghapus item dari keranjang, pergi ke halaman keranjang belanja dan klik tombol hapus di samping produk yang ingin dihapus"
            userMessage.contains("Bagaimana cara pembayaran?", ignoreCase = true) ||
                    userMessage.contains("Metode pembayaran apa yang tersedia?", ignoreCase = true) ||
                    userMessage.contains("Bisakah saya bayar dengan kartu kredit?", ignoreCase = true) ||
                    userMessage.contains("Sistem pembayaran apa yang digunakan?", ignoreCase = true) ||
                    userMessage.contains("Bagaimana cara pembayaran online?", ignoreCase = true) ||
                    userMessage.contains("pembayaran", ignoreCase = true) ||
                    userMessage.contains("ada pembayaran apa aja?", ignoreCase = true) ||
                    userMessage.contains("Apa saja opsi pembayaran?", ignoreCase = true) ||
                    userMessage.contains("Bagaimana cara mengonfirmasi pembayaran?", ignoreCase = true) ||
                    userMessage.contains("Bisakah saya bayar saat barang sampai?", ignoreCase = true) -> "Kami menggunakan sistem pembayaran online yang aman dan terpercaya. Anda dapat memilih opsi pembayaran saat checkout, bisa menggunakan kartu kredit, E-wallet, transfer bank, dan metode pembayaran online lainnya."
            userMessage.contains("Bagaimana cara cancel pemesanan?", ignoreCase = true) ||
                    userMessage.contains("Bagaimana saya bisa mengajukan pembatalan pemesanan", ignoreCase = true) ||
                    userMessage.contains("Batal pemesanan", ignoreCase = true) ||
                    userMessage.contains("cancel pemesanan", ignoreCase = true) ||
                    userMessage.contains("Tolak pemesanan?", ignoreCase = true) ||
                    userMessage.contains("Bagaimana cara cancel pembayaran?", ignoreCase = true) ||
                    userMessage.contains("Bagaimana cara tolak pembayaran", ignoreCase = true) ||
                    userMessage.contains("cancel checkout", ignoreCase = true) ||
                    userMessage.contains("batal pemesanan", ignoreCase = true) ||
                    userMessage.contains("batal checkout", ignoreCase = true) ||
                    userMessage.contains("cancel", ignoreCase = true) ||
                    userMessage.contains("cara cancel", ignoreCase = true) ||
                    userMessage.contains("cara membatalkan pemesanan", ignoreCase = true) -> "Anda bisa mengajukan tolak pemesanan pada halaman pesanan anda, kemudian klik batalkan pesanan"
            userMessage.contains("Berapa harga produk ini?", ignoreCase = true) ||
                    userMessage.contains("Saya ingin tahu harga produk", ignoreCase = true) ||
                    userMessage.contains("Harga produk", ignoreCase = true) ||
                    userMessage.contains("Apa ada harga promo?", ignoreCase = true) ||
                    userMessage.contains("Apa harga terbaik yang bisa Anda berikan?", ignoreCase = true) ||
                    userMessage.contains("Apakah ada potongan harga khusus?", ignoreCase = true) ||
                    userMessage.contains("harga", ignoreCase = true) ||
                    userMessage.contains("cek harga", ignoreCase = true) ||
                    userMessage.contains("informasi harga", ignoreCase = true) -> "Harga produk bisa dilihat di halaman produk yang anda inginkan. Harga sesuai dengan yang tertera di halaman produk tersebut. Jika ada potongan khusus, harga promo akan ditampilkan secara otomatis."
            userMessage.contains("Berapa total tagihan saya?", ignoreCase = true) ||
                    userMessage.contains("Berapa total harga barang yang saya pesan?", ignoreCase = true) ||
                    userMessage.contains("Berapa total harga produk?", ignoreCase = true) ||
                    userMessage.contains("Saya ingin tahu total pembayaran", ignoreCase = true) ||
                    userMessage.contains("total harga", ignoreCase = true) ||
                    userMessage.contains("total tagihan", ignoreCase = true) ||
                    userMessage.contains("total belanja", ignoreCase = true) ||
                    userMessage.contains("total biaya", ignoreCase = true) -> "Total harga bisa dilihat di halaman checkout. Harga yang tertera sudah termasuk harga produk, pengiriman, dan biaya lainnya."
            userMessage.contains("Apakah ada cicilan?", ignoreCase = true) ||
                    userMessage.contains("Apakah saya bisa nyicil?", ignoreCase = true) ||
                    userMessage.contains("cicil", ignoreCase = true) ||
                    userMessage.contains("cicilan", ignoreCase = true) ||
                    userMessage.contains("nyicil", ignoreCase = true) ||
                    userMessage.contains("angsur", ignoreCase = true) ||
                    userMessage.contains("angsuran", ignoreCase = true) ||
                    userMessage.contains("berangsur", ignoreCase = true) ||
                    userMessage.contains("paylater", ignoreCase = true) -> "Maaf, kami tidak menyediakan cicilan untuk semua jenis pembayaran."
            userMessage.contains("Bisakah saya bayar saat barang sampai?", ignoreCase = true) ||
                    userMessage.contains("COD", ignoreCase = true) ||
                    userMessage.contains("Cash on Delivery", ignoreCase = true) ||
                    userMessage.contains("apakah tersedia pembayaran secara COD?", ignoreCase = true) -> "Tidak, kami hanya menyediakan pembayaran melalui transfer bank, dan metode pembayaran online lainnya."
            userMessage.contains("Bagaimana cara melacak pengiriman?", ignoreCase = true) ||
                    userMessage.contains("Berapa lama barang akan sampai?", ignoreCase = true) ||
                    userMessage.contains("pengiriman", ignoreCase = true) ||
                    userMessage.contains("lacak", ignoreCase = true) ||
                    userMessage.contains("melacak", ignoreCase = true) -> "Setelah barang dikirim, Anda akan menerima nomor resi untuk melacak status pengiriman. Anda dapat cek secara berkala melalui resi yang telah didapatkan."
            userMessage.contains("Berapa biaya pengiriman?", ignoreCase = true) ||
                    userMessage.contains("Cek ongkir", ignoreCase = true) ||
                    userMessage.contains("biaya pengiriman", ignoreCase = true) ||
                    userMessage.contains("harga ongkir", ignoreCase = true) -> "Biaya pengiriman tergantung lokasi pengiriman. Anda dapat melihat estimasi biaya saat checkout."
            userMessage.contains("Ada promo spesial hari ini?", ignoreCase = true) ||
                    userMessage.contains("Bagaimana cara mendapatkan diskon?", ignoreCase = true) ||
                    userMessage.contains("Apakah ada kode promo?", ignoreCase = true) ||
                    userMessage.contains("Berapa lama promo ini berlaku?", ignoreCase = true) ||
                    userMessage.contains("Bagaimana cara ikut promo?", ignoreCase = true) ||
                    userMessage.contains("Apakah ada voucher diskon?", ignoreCase = true) ||
                    userMessage.contains("Apa saja promo yang berlangsung?", ignoreCase = true) ||
                    userMessage.contains("Bagaimana cara mendapatkan penawaran khusus?", ignoreCase = true) ||
                    userMessage.contains("Apakah ada diskon untuk pelanggan setia?", ignoreCase = true) ||
                    userMessage.contains("promo", ignoreCase = true) -> "Kami menyediakan voucher diskon untuk pelanggan setia kami. Anda bisa melihatnya di akun Anda atau langsung di halaman promo."
            userMessage.contains("Bagaimana cara mengembalikan barang?", ignoreCase = true) ||
                    userMessage.contains("Saya ingin melakukan pengembalian", ignoreCase = true) ||
                    userMessage.contains("Proses pengembalian", ignoreCase = true) ||
                    userMessage.contains("Cara mengajukan retur", ignoreCase = true) ||
                    userMessage.contains("Saya ingin mengembalikan produk", ignoreCase = true) ||
                    userMessage.contains("Apakah bisa mendapatkan pengembalian dana?", ignoreCase = true) ||
                    userMessage.contains("Bagaimana langkah-langkah retur?", ignoreCase = true) ||
                    userMessage.contains("Saya ingin mengajukan klaim pengembalian", ignoreCase = true) ||
                    userMessage.contains("Bagaimana jika barang rusak saat pengiriman?", ignoreCase = true) ||
                    userMessage.contains("Bagaimana cara retur barang?", ignoreCase = true) ||
                    userMessage.contains("retur", ignoreCase = true) ||
                    userMessage.contains("pengembalian", ignoreCase = true) ||
                    userMessage.contains("pengembalian barang", ignoreCase = true) -> "Anda dapat mengembalikan barang dengan menghubungi layanan pelanggan kami, silakan berikan informasi detail tentang masalah pesanan Anda, dan ikuti prosedur pengembalian yang diberikan. Pastikan untuk membaca kebijakan pengembalian kami di situs web."
            userMessage.contains("Bagaimana jika barang yang saya terima rusak?", ignoreCase = true) ||
                    userMessage.contains("hai, saya menerima barang yang tidak sesuai", ignoreCase = true) ||
                    userMessage.contains("barang rusak", ignoreCase = true) -> "Jika Anda menerima barang yang rusak, segera hubungi tim dukungan pelanggan kami dan berikan foto barang yang rusak beserta bukti lainnya. Kami akan membantu mengatur pengembalian atau penggantian jika sesuai ketentuan yang berlaku."
            userMessage.contains("barang tidak sesuai", ignoreCase = true) ||
                    userMessage.contains("barang gak jelas", ignoreCase = true) ||
                    userMessage.contains("barang tidak jelas", ignoreCase = true) ||
                    userMessage.contains("Bagaimana jika barang tidak sesuai?", ignoreCase = true) ||
                    userMessage.contains("hai, saya menerima barang yang tidak sesuai", ignoreCase = true) -> "Anda bisa mengembalikan produk"
            else -> "Maaf saya tidak diprogram untuk ini, tolong ajukan pertanyaan yang sesuai."
        }
    }


}