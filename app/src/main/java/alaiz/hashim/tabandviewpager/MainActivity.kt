package alaiz.hashim.tabandviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

lateinit var tabLayout:TabLayout
lateinit var tabViewPager:ViewPager2
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout=findViewById(R.id.tabs)
        tabViewPager=findViewById(R.id.pager)
        tabViewPager.adapter=object :FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {


               return when (position) {
                    0 -> {
                        FirstFragment.newInstance("", "")

                    }
                    1 -> {
                        SecondFragment.newInstance("", "")
                    }
                    2 -> {
                        ThirdFragment.newInstance("", "")
                    }
                    else -> {
                        SecondFragment.newInstance("", "")
                    }
                }
            }
            override fun getItemCount(): Int {
                return 3
            }
        }
        TabLayoutMediator(tabLayout, tabViewPager){tab,position->
            tab.text=when(position){
                0 ->"tab1"
                1 ->"tab2"
                2 ->"tab3"
                else -> null
            }

        }.attach()

    }
}