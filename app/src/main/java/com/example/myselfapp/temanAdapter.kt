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

class temanAdapter(private val temanList : List<teman>) :
    RecyclerView.Adapter<temanAdapter.temanViewHolder>() {

    class  temanViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val temanImageView : ImageView = itemView.findViewById(R.id.friend_image)
        val namaTeman : TextView = itemView.findViewById(R.id.nama_teman)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): temanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.friend_layout, parent ,false)
        return temanViewHolder(view)
    }

    override fun getItemCount(): Int {
        return temanList.size
    }

    override fun onBindViewHolder(holder: temanViewHolder, position: Int) {
        val teman = temanList[position]
        holder.temanImageView.setImageResource(teman.gambarTeman)
        holder.namaTeman.text = teman.friendname

    }

}