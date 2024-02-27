package com.anthonyidoko.com.basicShape.lines

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet

class VerticalLines: SimpleLine {
    private val paint = Paint()
    private var startXPos = 0f
    private var endXPos = 0f
    private var startYPos = 0f
    private var endYPos = 0f
    private var lineWidth = 0f

    constructor(context: Context?): super(context)
    constructor(context: Context?, attributeSet: AttributeSet?): super(context,attributeSet)
    constructor(context: Context?, attributeSet: AttributeSet?, defStyleAtt: Int = 0): super(context,attributeSet,defStyleAtt)
    constructor(context: Context?, attributeSet: AttributeSet?, defStyleAtt: Int = 0, defStyleRes: Int = 0): super(context,attributeSet,defStyleAtt,defStyleRes)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        lineWidth = dpToPx(LINE_WIDTH_DP)
        startXPos = w.toFloat()/2.0f
        endXPos = w.toFloat()/2.0f
        startYPos = START_VERT_POS_DP
        endYPos = h.toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.RED
        paint.strokeWidth = lineWidth
        paint.style = Paint.Style.STROKE
        canvas.drawLine(startXPos,startYPos, endXPos, endYPos, paint)
    }

    companion object{
        const val START_VERT_POS_DP = 0F
        const val START_HOR_POS_DP = 0F
        const val LINE_WIDTH_DP = 2f
    }

}