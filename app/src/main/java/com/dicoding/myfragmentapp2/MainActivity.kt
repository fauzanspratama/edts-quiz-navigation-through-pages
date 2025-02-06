package com.dicoding.myfragmentapp2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)
        tabLayout = findViewById(R.id.tab_layout)

        findViewById<Button>(R.id.buttonNext1).setOnClickListener(this)
        findViewById<Button>(R.id.buttonNext2).setOnClickListener(this)
        findViewById<Button>(R.id.buttonNext3).setOnClickListener(this)

        // Set up the adapter
        viewPagerAdapter = ViewPagerAdapter(this)

        // Add the fragments
        viewPagerAdapter.addFragment(Fragment1(), "Page 1")
        viewPagerAdapter.addFragment(Fragment2(), "Page 2")
        viewPagerAdapter.addFragment(Fragment3(), "Page 3")

        // Set the adapter to the ViewPager2
        viewPager.adapter = viewPagerAdapter

        // Link the TabLayout and ViewPager2 using TabLayoutMediator
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = viewPagerAdapter.getPageTitle(position)
        }.attach()
    }

//    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.buttonNext1 -> startActivity(Intent(this, Fragment1::class.java))
//
//        }
//    }
}