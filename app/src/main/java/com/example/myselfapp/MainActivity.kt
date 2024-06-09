package com.example.myselfapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager

// Identitas diri:
// Tanggal Pengerjaan: 10 Juni 2024
// NIM: 10121076
// Nama: Faliq Zuldan Akbar
// Kelas: Pengrogram Android 3

class MainActivity : AppCompatActivity() {

    private lateinit var mSlideViewPager: ViewPager
    private lateinit var mDotLayout: LinearLayout
    private lateinit var backbtn: Button
    private lateinit var nextbtn: Button
    private lateinit var skipbtn: Button

    private lateinit var dots: Array<TextView?>
    private lateinit var viewPagerAdapter: ViewPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        backbtn = findViewById(R.id.back_button)
        nextbtn = findViewById(R.id.next_button)
        skipbtn = findViewById(R.id.skip_button)

        backbtn.setOnClickListener {
            val currentItem = getItem(-1)
            if (currentItem >= 0) {
                mSlideViewPager.currentItem = currentItem
            }
        }

        nextbtn.setOnClickListener {
            val currentItem = getItem(1)
            if (currentItem < viewPagerAdapter.count) {
                mSlideViewPager.currentItem = currentItem
            } else {
                val intent = Intent(this, mainscreen::class.java)
                startActivity(intent)
                finish()
            }
        }

        skipbtn.setOnClickListener {
            mSlideViewPager.currentItem = viewPagerAdapter.count - 1
            val intent = Intent(this, mainscreen::class.java)
            startActivity(intent)
            finish()
        }

        mSlideViewPager = findViewById(R.id.SlideViewPager)
        mDotLayout = findViewById(R.id.indicator_layout)

        viewPagerAdapter = ViewPageAdapter(this)
        mSlideViewPager.adapter = viewPagerAdapter

        setUpIndicator(0)
        mSlideViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                setUpIndicator(position)
                backbtn.visibility = if (position > 0) View.VISIBLE else View.INVISIBLE
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun setUpIndicator(position: Int) {
        dots = Array(viewPagerAdapter.count) { TextView(this) }
        mDotLayout.removeAllViews()

        for (i in dots.indices) {
            dots[i] = TextView(this).apply {
                text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml("•", Html.FROM_HTML_MODE_LEGACY)
                } else {
                    Html.fromHtml("•")
                }
                textSize = 35f
                setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                mDotLayout.addView(this)
            }
        }

        if (dots.isNotEmpty()) {
            dots[position]?.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
    }

    private fun getItem(i: Int): Int {
        return mSlideViewPager.currentItem + i
    }
}
