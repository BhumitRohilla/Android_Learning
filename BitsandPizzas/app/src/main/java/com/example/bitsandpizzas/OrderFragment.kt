package com.example.bitsandpizzas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar:MaterialToolbar?=view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val fab=view.findViewById<FloatingActionButton>(R.id.help_Floating)
        fab.setOnClickListener {
            Toast.makeText(activity,"Cry about it",Toast.LENGTH_SHORT).show()
        }
        val fabSend=view.findViewById<FloatingActionButton>(R.id.send_fab)
        val pizzaType=view.findViewById<RadioGroup>(R.id.pizza_group)
        fabSend.setOnClickListener {
            if (pizzaType.checkedRadioButtonId == -1) {
                Toast.makeText(activity, "Select pizza", Toast.LENGTH_SHORT).show()
            } else {
                var text=when (pizzaType.checkedRadioButtonId){
                    R.id.radio_diavolo -> "Divavolo pizza"
                    else    -> "Fungi Pizza"
                }
                var extra:String
                extra=if(view.findViewById<Chip>(R.id.parmesan).isChecked) " + Parmesan" else ""
                extra+=if(view.findViewById<Chip>(R.id.chili_oil).isChecked) " + Chili Oil" else ""
                text+=extra

                Snackbar.make(view, "Order $text", Snackbar.LENGTH_SHORT).show()
            }

        }
        return view;
    }
}