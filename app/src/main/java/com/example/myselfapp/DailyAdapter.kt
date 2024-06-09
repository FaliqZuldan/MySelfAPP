package com.example.myselfapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Identitas diri:
// Tanggal Pengerjaan: 10 Juni 2024
// NIM: 10121076
// Nama: Faliq Zuldan Akbar
// Kelas: Pengrogram Android 3

class DailyAdapter (private val dataList: ArrayList<Dataclass>): RecyclerView.Adapter<DailyAdapter.ViewHolderClass>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text = currentItem.dataJudul
        holder.rvJelaskan.text =currentItem.dataPenjelasan
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {

        val rvImage:ImageView = itemView.findViewById(R.id.gambar_daily)
        val rvTitle:TextView = itemView.findViewById(R.id.nama_kegiatan)
        val rvJelaskan:TextView = itemView.findViewById(R.id.jelasan_kegiatan)

    }
}