package com.anthonyidoko.com.basicShape.lines

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.anthonyidoko.com.R

class Slider: SimpleLine {
    private val paint = Paint()

    private var rectangle = RectF()
    private var rectLeft = 0f
    private var rectRight = 0f
    private var rectTop = 0f
    private var rectBottom = 0f

    private var lineWidth = 0f
    private var xHorLineStart = 0f
    private var xHorLineEnd = 0f
    private var yHorLineStart = 0f
    private var yHorLineEnd = 0f

    private var cXStart = 0f
    private var cYStart = 0f
    private var cRadius = 0f


    constructor(context: Context?): super(context)
    constructor(context: Context?, attributeSet: AttributeSet?): super(context,attributeSet)
    constructor(context: Context?, attributeSet: AttributeSet?, defStyleAtt: Int = 0): super(context,attributeSet,defStyleAtt)
    constructor(context: Context?, attributeSet: AttributeSet?, defStyleAtt: Int = 0, defStyleRes: Int = 0): super(context,attributeSet,defStyleAtt,defStyleRes)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        lineWidth = dpToPx(LINE_WIDTH_DP)

        rectLeft = dpToPx(MARGIN_HOR_DP)
        rectRight = w - dpToPx(MARGIN_HOR_DP)
        rectTop = h/2f - dpToPx(RECT_HALF_HEIGHT)
        rectBottom = h/2f + dpToPx(RECT_HALF_HEIGHT)
        rectangle.set(rectLeft, rectTop, rectRight, rectBottom)

        xHorLineStart = dpToPx(LINE_MARGIN_HOR_DP)
        xHorLineEnd = w - dpToPx(LINE_MARGIN_HOR_DP)
        yHorLineStart = h/LINE_VERT_POS_FRACTION
        yHorLineEnd = h/LINE_VERT_POS_FRACTION

        cXStart = w/2f
        cYStart = h/2f
        cRadius = dpToPx(CIRCLE_RADIUS)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //RECTANGLE
        paint.apply {
            color = ContextCompat.getColor(context, R.color.light_gray)
            style = Paint.Style.FILL
        }
        canvas.drawRect(rectangle,paint)

        //Horizontal Line
        paint.apply {
            color = ContextCompat.getColor(context, R.color.dark_gray)
            style = Paint.Style.STROKE
            strokeWidth = lineWidth
        }
        canvas.drawLine(xHorLineStart,yHorLineStart, xHorLineEnd, yHorLineEnd,paint)

        //Circle
        paint.apply {
            color = ContextCompat.getColor(context, R.color.dark_blue)
            style = Paint.Style.FILL
        }
        canvas.drawCircle(cXStart, cYStart,cRadius, paint)

    }

    companion object{
        const val LINE_WIDTH_DP = 3f
        const val LINE_VERT_POS_FRACTION = 2f
        const val CIRCLE_RADIUS = 10f
        const val MARGIN_HOR_DP = 30F
        const val LINE_MARGIN_HOR_DP = 60F
        const val RECT_HALF_HEIGHT = 60F

    }

}