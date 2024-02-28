package com.anthonyidoko.com.basicShape.lines

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet

class Rectangle: SimpleLine {
    private val paint = Paint()
    private var rectLeft = 0f
    private var rectTop = 0f
    private var rectRight = 0f
    private var rectBottom = 0f
    private var lineWidth = 0f
    private var rectangle = RectF()

    constructor(context: Context?): super(context)
    constructor(context: Context?, attributeSet: AttributeSet?): super(context,attributeSet)
    constructor(context: Context?, attributeSet: AttributeSet?, defStyleAtt: Int = 0): super(context,attributeSet,defStyleAtt)
    constructor(context: Context?, attributeSet: AttributeSet?, defStyleAtt: Int = 0, defStyleRes: Int = 0): super(context,attributeSet,defStyleAtt,defStyleRes)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        lineWidth = dpToPx(LINE_WIDTH_DP)
        rectLeft = dpToPx(MARGIN_HOR_DP)
        rectTop = h / 2.5f
        rectRight = w - dpToPx(MARGIN_HOR_DP)
        rectBottom = rectTop + rectTop/2
        rectangle.set(rectLeft, rectTop, rectRight,rectBottom)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.BLUE
        paint.strokeWidth = lineWidth
        paint.style = Paint.Style.STROKE
        canvas.drawRect(rectangle,paint)
    }

    companion object{
        const val LINE_WIDTH_DP = 2f
        const val TWO_F = 2f
        const val MARGIN_HOR_DP = 20f
    }

}