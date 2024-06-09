package com.example.myselfapp

import MediaItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

// Identitas diri:
// Tanggal Pengerjaan: 10 Juni 2024
// NIM: 10121076
// Nama: Faliq Zuldan Akbar
// Kelas: Pengrogram Android 3

class MediaAdapter(private val mediaList: List<MediaItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return mediaList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == MediaType.SONG) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
            SongViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
            VideoViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mediaList[position]
        if (holder is SongViewHolder) {
            holder.bind(item)
        } else if (holder is VideoViewHolder) {
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int = mediaList.size

    class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val songTitle: TextView = itemView.findViewById(R.id.songTitle)
        private val albumImage: ImageView = itemView.findViewById(R.id.albumImage)

        fun bind(item: MediaItem) {
            songTitle.text = item.title
            albumImage.setImageResource(item.imageUrl)
        }
    }


    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val videoView: VideoView = itemView.findViewById(R.id.videoView)

        fun bind(item: MediaItem) {
            videoView.setVideoPath(item.videoUrl)
            videoView.start()
        }
    }
}
