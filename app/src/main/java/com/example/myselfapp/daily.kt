package com.example.myselfapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Identitas diri:
// Tanggal Pengerjaan: 10 Juni 2024
// NIM: 10121076
// Nama: Faliq Zuldan Akbar
// Kelas: Pengrogram Android 3

class daily : Fragment() {

    private lateinit var dailyRecyclerView: RecyclerView
    private lateinit var friendRecyclerView: RecyclerView
    private lateinit var dataList: ArrayList<Dataclass>
    private lateinit var imageList: Array<Int>
    private lateinit var judulList: Array<String>
    private lateinit var jelasanList: Array<String>
    private lateinit var temanList: ArrayList<teman>
    private lateinit var temanAdapter: temanAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_daily, container, false)

        // Initialize the data
        initializeData()

        // Set up the dailyRecyclerView (vertical)
        dailyRecyclerView = rootView.findViewById(R.id.dailyListRecyclerView)
        dailyRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        dailyRecyclerView.setHasFixedSize(true)
        dailyRecyclerView.adapter = DailyAdapter(dataList)

        // Set up the friendRecyclerView (horizontal)
        friendRecyclerView = rootView.findViewById(R.id.friendActivitiesRecyclerView)
        friendRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        friendRecyclerView.setHasFixedSize(true)
        friendRecyclerView.adapter = temanAdapter

        return rootView
    }

    private fun initializeData() {
        // Initialize imageList, judulList, and jelasanList
        imageList = arrayOf(
            R.drawable.baguntidur,
            R.drawable.makanpagi,
            R.drawable.mandi,
            R.drawable.kuliah,
            R.drawable.istirahat,
            R.drawable.belajar,
            R.drawable.makanmalam,
            R.drawable.tidur
        )

        judulList = arrayOf(
            "Bangun",
            "Sarapan",
            "Persiapan",
            "Kampus",
            "Beristirahat",
            "Belajar",
            "Makan Malam",
            "Tidur"
        )

        jelasanList = arrayOf(
            "Saya bangun tidur sekitar jam 5",
            "Memakan sarapan pagi",
            "Bersiap siap untuk berangkat kuliah",
            "Melakukan Perkuliahan",
            "Setelah pulang saya beristirahat sebentar",
            "Mengulang materi yang telah dipelajari di kampus",
            "Mengisi tenaga dengan makan malam",
            "Beristirahat untuk hari esok"
        )

        // Initialize dataList
        dataList = arrayListOf()
        for (i in imageList.indices) {
            val dataclass = Dataclass(imageList[i], judulList[i], jelasanList[i])
            dataList.add(dataclass)
        }

        // Initialize temanList
        temanList = arrayListOf()
        temanList.add(teman(R.drawable.wildan, "Wildan"))
        temanList.add(teman(R.drawable.moris, "Moricio"))
        temanList.add(teman(R.drawable.adrian, "Adrian"))
        temanList.add(teman(R.drawable.nasja, "Nasza"))

        // Initialize temanAdapter
        temanAdapter = temanAdapter(temanList)
    }
}
