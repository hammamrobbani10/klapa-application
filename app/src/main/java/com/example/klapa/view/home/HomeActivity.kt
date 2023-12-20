package com.example.klapa.view.home


import BarangAdapter
import BarangModel
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.klapa.R
import com.example.klapa.data.detail.DetailActivity
import com.example.klapa.data.model.GambarAdapter
import com.example.klapa.data.model.GambarModel
import com.example.klapa.profile.ProfilePageActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var recyclerView: RecyclerView
    private lateinit var etQuery: EditText
    private lateinit var barangAdapter: BarangAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewPager = findViewById(R.id.viewPager)
        recyclerView = findViewById(R.id.recyclerView)
        etQuery = findViewById(R.id.et_query)

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
            BarangModel(
                R.drawable.barang1,
                "Barang 1",
                180000,
                80,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang2,
                "Barang 2",
                15000,
                20,
                "Bekas",
                "2 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang3,
                "Barang 3",
                20000,
                15,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang4,
                "Barang 4",
                25000,
                10,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang5,
                "Barang 5",
                30000,
                25,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang6,
                "Barang 6",
                180000,
                30,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang7,
                "Barang 7",
                15000,
                15,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang8,
                "Barang 8",
                20000,
                20,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang9,
                "Barang 9",
                25000,
                10,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang10,
                "Barang 10",
                30000,
                5,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang11,
                "Barang 11",
                180000,
                15,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang12,
                "Barang 12",
                20000,
                20,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang13,
                "Barang 13",
                15000,
                25,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            ),
            BarangModel(
                R.drawable.barang14,
                "Barang 14",
                20000,
                10,
                "Baru",
                "1 Buah",
                "Bibit",
                "Detail Product",
                "Deskripsi:\n\nKelapa adalah buah dari pohon kelapa (Cocos nucifera).\nBuah kelapa digunakan sebagai minuman, sari/santan, minyak, dan dagingnya yang lezat juga dikonsumsi.\n\nKelapa atau nyiur adalah anggota tunggal dalam genus Cocos dari suku aren-arenan atau Arecaceae.\nArti kata kelapa dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan.",
                "Alamat barang di sini"
            )
            // Tambahkan barang sesuai kebutuhan
        )

        barangAdapter = BarangAdapter(barangList)
        recyclerView.adapter = barangAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        etQuery.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                barangAdapter.filter(charSequence.toString())
            }

            override fun afterTextChanged(editable: Editable?) {}
        })

        barangAdapter.setOnItemClickListener(object : BarangAdapter.OnItemClickListener {
            override fun onItemClick(barang: BarangModel) {
                val intent = Intent(this@HomeActivity, DetailActivity::class.java)
                intent.putExtra("barang", barang)
                startActivity(intent)
            }
        })
        val personButton: ImageButton = findViewById(R.id.personButton)
        personButton.setOnClickListener {
            val intent = Intent(this, ProfilePageActivity::class.java)
            startActivity(intent)
        }
    }
}