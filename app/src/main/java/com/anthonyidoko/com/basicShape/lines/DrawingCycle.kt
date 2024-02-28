package com.anthonyidoko.com.basicShape.lines

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet

class DrawingCycle: SimpleLine {
    private val paint = Paint()
    private var startXPos = 0f
    private var startYPos = 0f
    private var circleRadius = 0f
    private var lineWidth = 0f

    constructor(context: Context?): super(context)
    constructor(context: Context?, attributeSet: AttributeSet?): super(context,attributeSet)
    constructor(context: Context?, attributeSet: AttributeSet?, defStyleAtt: Int = 0): super(context,attributeSet,defStyleAtt)
    constructor(context: Context?, attributeSet: AttributeSet?, defStyleAtt: Int = 0, defStyleRes: Int = 0): super(context,attributeSet,defStyleAtt,defStyleRes)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        lineWidth = dpToPx(LINE_WIDTH_DP)
        startXPos = w/TWO_F
        circleRadius = w/(TWO_F * TWO_F)
        startYPos = h.toFloat()/TWO_F
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.BLUE
        paint.strokeWidth = lineWidth
        paint.style = Paint.Style.STROKE
        canvas.drawCircle(startXPos, startYPos,circleRadius,paint)
    }

    companion object{
        const val LINE_WIDTH_DP = 2f
        const val TWO_F = 2F
    }

}