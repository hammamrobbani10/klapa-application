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
    val deskripsi: String,
    val alamat: String
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
        parcel.writeString(alamat)
    }

    override fun describeContents(): Int {
        return 0
    }

    // Fungsi untuk mengambil detail produk dengan format yang sesuai
    fun formatDetailProduk(): String {
        return "Kondisi: $kondisi\n" +
                "Pesanan: $pesanan\n" +
                "Kategori: $kategori\n" +
                "Detail: $detail\n" +
                "Alamat: $alamat"
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
