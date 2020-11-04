package alaiz.hashim.tabandviewpager

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

lateinit var tabLayout:TabLayout
lateinit var tabViewPager:ViewPager2
lateinit var mainLinearLayoutFragment: LinearLayout


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
                        FirstFragment.newInstance(position, "green")

                    }
                    1 -> {
                        FirstFragment.newInstance(position, "")
                    }
                    2 -> {
                        FirstFragment.newInstance(position, "")
                    }
                    else -> {
                        FirstFragment.newInstance(position, "")
                    }
                }
            }
            override fun getItemCount(): Int {
                return 3
            }

        }

        TabLayoutMediator(tabLayout, tabViewPager){tab,position->
            when(position){
                0 -> {
                    tab.text ="tab1"}
                1 ->tab.text = "tab2"
                2 ->tab.text = "tab3"
                else -> null
            }

        }.attach()

    }
}