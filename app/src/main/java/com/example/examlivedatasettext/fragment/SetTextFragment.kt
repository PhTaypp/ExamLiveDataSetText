package com.example.examlivedatasettext.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.example.examlivedatasettext.R
import com.example.examlivedatasettext.viewmodel.SetTextViewModel

class SetTextFragment : Fragment() {
    lateinit var edt1 :EditText
    lateinit var edt2 :EditText
    lateinit var tv1 :TextView
    lateinit var tv2 :TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel = SetTextViewModel()
        super.onViewCreated(view, savedInstanceState)
        edt1 = view.findViewById(R.id.edt1)
        edt2 = view.findViewById(R.id.edt2)
        tv1 = view.findViewById(R.id.tv_1)
        tv2 = view.findViewById(R.id.tv_2)
        edt1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (edt1.text.isNotEmpty()){
                    viewModel.setText1(edt1.text.toString())
                }
            }
        })
        edt2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.setText2(edt2.text.toString())
            }
        })
        viewModel.getText1MutableLiveData().observe(viewLifecycleOwner) { text1 ->
            tv1.text = text1.text
        }
        viewModel.getText2MutableLiveData().observe(viewLifecycleOwner) { text2 ->
            if (text2.text.isNotEmpty()) {
                tv2.text = text2.text
            }
        }
    }
}