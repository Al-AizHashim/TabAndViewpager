package alaiz.hashim.tabandviewpager

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var textview1: TextView
lateinit var mainlayoutfragment:FrameLayout

class FirstFragment : Fragment() {


    private var param1: Int? = null
    private var param2: String? = null

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v=inflater.inflate(R.layout.fragment_first, container, false  )
        textview1= v.findViewById(R.id.textView1)
        mainlayoutfragment=v.findViewById(R.id.mainFragment1)
        when(param1){
            0->{textview1.text="the First page"
                mainlayoutfragment.setBackgroundColor(R.color.material_on_primary_disabled)
            }
            1->{textview1.text="the second page"
            mainlayoutfragment.setBackgroundColor(R.color.design_default_color_primary_dark)
        }
            2->{textview1.text="the third page"
                mainlayoutfragment.setBackgroundColor(R.color.colorPrimaryDark)
            }
            else ->{textview1.text="the third page"
               mainlayoutfragment.setBackgroundColor(R.color.colorAccent)
            }
        }




        // Inflate the layout for this fragment
        return v
    }

    override fun onStart() {
        super.onStart()

    }
    companion object {


        fun newInstance(param1: Int, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {

                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}