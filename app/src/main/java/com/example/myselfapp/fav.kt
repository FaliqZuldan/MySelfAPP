package com.example.myselfapp

import MediaItem
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

// Identitas diri:
// Tanggal Pengerjaan: 10 Juni 2024
// NIM: 10121076
// Nama: Faliq Zuldan Akbar
// Kelas: Pengrogram Android 3

class fav : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fav, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val mediaList = listOf(
            MediaItem(MediaType.SONG, "N95 - Kendrick Lamar", null, R.drawable.kendrik),
            MediaItem(MediaType.SONG, "United In Grief - Kendrick Lamar", null, R.drawable.united),
            MediaItem(MediaType.SONG, "Thnks fr th Mmrs - Fall Out Boys", null, R.drawable.thnks),
            MediaItem(MediaType.SONG, "Love From The Other Side - Fall Out Boys", null, R.drawable.love),
            MediaItem(MediaType.SONG, "The Way I Am - Eminem", null, R.drawable.em),


        )

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MediaAdapter(mediaList)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fav().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
