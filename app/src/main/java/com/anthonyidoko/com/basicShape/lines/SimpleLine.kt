package com.anthonyidoko.com.basicShape.lines

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

open class SimpleLine : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attr: AttributeSet?) : super(context, attr)
    constructor(context: Context?, attr: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attr,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attr: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attr, defStyleAttr, defStyleRes)



    fun dpToPx(dp: Float): Float{
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,//The type we wiah to convert from
            dp,
            context.resources.displayMetrics
        )
    }


}