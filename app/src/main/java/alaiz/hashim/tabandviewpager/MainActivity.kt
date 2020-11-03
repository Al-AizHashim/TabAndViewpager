package alaiz.hashim.tabandviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabItem
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
                tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
                tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_audiotrack_24)
                tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_favorite_24)
                tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

                    override fun onTabSelected(tab: TabLayout.Tab?) {
                         Toast.makeText(this@MainActivity , "the number of current page is: "+tab?.position.toString(), Toast.LENGTH_SHORT).show()
                    }

                    override fun onTabReselected(tab: TabLayout.Tab?) {
                        // Handle tab reselect
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {
                        // Handle tab unselect
                    }
                })

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