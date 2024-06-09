package com.example.myselfapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Identitas diri:
// Tanggal Pengerjaan: 10 Juni 2024
// NIM: 10121076
// Nama: Faliq Zuldan Akbar
// Kelas: Pengrogram Android 3

class gallery : Fragment() {

    private lateinit var galleryRecyclerView: RecyclerView
    private lateinit var imageList: ArrayList<GalleryItem>
    private lateinit var galleryAdapter: GalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_gallery, container, false)

        // Initialize the data
        initializeData()

        // Set up the galleryRecyclerView (grid layout)
        galleryRecyclerView = rootView.findViewById(R.id.gallery_list)
        galleryRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        galleryRecyclerView.setHasFixedSize(true)
        galleryRecyclerView.adapter = galleryAdapter

        return rootView
    }

    private fun initializeData() {
        // Initialize imageList
        imageList = arrayListOf(
            GalleryItem(R.drawable.foto1),
            GalleryItem(R.drawable.foto2),
            GalleryItem(R.drawable.foto3),
            GalleryItem(R.drawable.foto4)

        )

        // Initialize galleryAdapter
        galleryAdapter = GalleryAdapter(this, imageList)
    }
}
