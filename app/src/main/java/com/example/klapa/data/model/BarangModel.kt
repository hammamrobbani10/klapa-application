package com.example.klapa.data.model

import android.os.Parcel
import android.os.Parcelable

class BarangModel(
    val drawableResId: Int,
    val nama: String,
    val harga: Int,
    val diskon: Int,
    val kondisi: String,
    val pesanan: String,
    val kategori: String,
    val detail: String,
    val deskripsi: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(drawableResId)
        parcel.writeString(nama)
        parcel.writeInt(harga)
        parcel.writeInt(diskon)
        parcel.writeString(kondisi)
        parcel.writeString(pesanan)
        parcel.writeString(kategori)
        parcel.writeString(detail)
        parcel.writeString(deskripsi)
    }

    override fun describeContents(): Int {
        return 0
    }

    // Fungsi-fungsi untuk format kondisi, pemesanan, dan kategori
    fun formatKondisi(): String {
        return "Kondisi\t\t\t\t\t\t\t\t\t$kondisi"
    }

    fun formatPemesanan(): String {
        return "Pemesanan\t\t\t\t$pesanan"
    }

    fun formatKategori(): String {
        return "Kategori\t\t\t\t\t\t\t\t$kategori"
    }

    fun formatDetailProduk(): String {
        return "Detail produk:\n" +
                "${formatKondisi()}\n" +
                "${formatPemesanan()}\n" +
                "${formatKategori()}"
    }


    fun formatDeskripsiProduk(): String {
        return "Deskripsi Produk:\n$deskripsi"
    }

    companion object CREATOR : Parcelable.Creator<BarangModel> {
        override fun createFromParcel(parcel: Parcel): BarangModel {
            return BarangModel(parcel)
        }

        override fun newArray(size: Int): Array<BarangModel?> {
            return arrayOfNulls(size)
        }
    }
}