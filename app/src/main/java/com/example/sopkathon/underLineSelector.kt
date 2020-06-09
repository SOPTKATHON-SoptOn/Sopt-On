package com.example.sopkathon

import android.view.View
import android.widget.EditText

fun EditText.underLineSelector(underLine : View){
    if (this.text.isNotEmpty())
        underLine.setBackgroundColor(resources.getColor(R.color.main))
    else
        underLine.setBackgroundColor(resources.getColor(R.color.underline))
}