package com.example.sopkathon

import android.view.View
import android.widget.EditText

fun View.underLineSelector(underLine : View, ed : EditText){
    if (ed.text.isNotEmpty())
        underLine.setBackgroundColor(resources.getColor(R.color.main))
    else
        underLine.setBackgroundColor(resources.getColor(R.color.underline))
}