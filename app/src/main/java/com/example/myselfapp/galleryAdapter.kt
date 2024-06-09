package com.example.myselfapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

// Identitas diri:
// Tanggal Pengerjaan: 10 Juni 2024
// NIM: 10121076
// Nama: Faliq Zuldan Akbar
// Kelas: Pengrogram Android 3

class GalleryAdapter(private val activity: gallery, private val galleryList: List<GalleryItem>) :
    RecyclerView.Adapter<GalleryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.galleryImg.setImageResource(galleryList[position].image)

        holder.cardView.setOnClickListener {
            Toast.makeText(activity.context, "Clicked on: ${galleryList[position].image}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return galleryList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val galleryImg: ImageView = itemView.findViewById(R.id.gallery_img)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }
}
