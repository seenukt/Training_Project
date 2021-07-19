package com.example.redbushome_page_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val frg = FragmentAdapter(supportFragmentManager, lifecycle)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        frg.adddata(Home())
        frg.adddata(Mybooking())
        frg.adddata(Help())
        frg.adddata(MyAccount())
        viewpager.adapter=frg

        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "HOME"
                    tab.setIcon(R.drawable.ic_baseline_home_24)
                }
                1 -> {
                    tab.text = "BOOKING"
                    tab.setIcon(R.drawable.ic_booking)

                }
                2 -> {
                    tab.text = "HELP"
                    tab.setIcon(R.drawable.ic_help)
                }
                3 -> {
                    tab.text = "MY ACCOUNT"
                    tab.setIcon(R.drawable.ic_baseline_account_circle_24)
                }

            }
        }.attach()
    }
}