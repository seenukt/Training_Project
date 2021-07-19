package com.example.customviewandlayout


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class MyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val pain = Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.color= Color.CYAN
            it.textSize=width/5 .toFloat()
        }
//        canvas!!.drawCircle((width/2).toFloat(),height/2 .toFloat(), min(width/2.5.toFloat(),height/2.5.toFloat()),pain)
//        canvas!!.drawText("X",(width/2.5).toFloat(),(height/2.5).toFloat(),pain)
        val rec = RectF(width/2 .toFloat(),height/2 .toFloat(),0f,0f)
        canvas!!.drawRect(rec,pain)
    }



//        private var radius = 0.0f                   // Radius of the circle.
//    private var fanSpeed = FanSpeed.MEDIUM         // The active selection.
//    // position variable which will be used to draw label and indicator circle position
//    private val pointPosition: PointF = PointF(0.0f, 0.0f)
//    private  val RADIUS_OFFSET_LABEL = 40
//    private  val RADIUS_OFFSET_INDICATOR = -35
//
//    private enum class FanSpeed(val label: Int) {
//        OFF(R.string.fan_off),
//        LOW(R.string.fan_low),
//        MEDIUM(R.string.fan_medium),
//        HIGH(R.string.fan_high);
//    }
//
//    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
//        style = Paint.Style.FILL_AND_STROKE
//        textAlign = Paint.Align.CENTER
//        textSize = 55.0f
//        typeface = Typeface.create( "", Typeface.BOLD)
//    }
//
//    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        super.onSizeChanged(w, h, oldw, oldh)
//        radius = (min(width, height) / 2.0 * 0.8).toFloat()
//    }
//    private fun PointF.computeXYForSpeed(pos: FanSpeed, radius: Float) {
//        // Angles are in radians.
//        val startAngle = Math.PI * (9 / 8.0)
//        val angle = startAngle + pos.ordinal * (Math.PI / 4)
//        x = (radius * cos(angle)).toFloat() + width / 2
//        y = (radius * sin(angle)).toFloat() + height / 2
//    }
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        paint.color = if (fanSpeed == FanSpeed.OFF) Color.GRAY else Color.GREEN
//        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paint)
//        val markerRadius = radius + RADIUS_OFFSET_INDICATOR
//        pointPosition.computeXYForSpeed(fanSpeed, markerRadius)
//        paint.color = Color.BLACK
//        canvas.drawCircle(pointPosition.x, pointPosition.y, radius/12, paint)
//        // Draw the text labels.
//        val labelRadius = radius + RADIUS_OFFSET_LABEL
//        for (i in FanSpeed.values()) {
//            pointPosition.computeXYForSpeed(i, labelRadius)
//            val label = resources.getString(i.label)
//            canvas.drawText(label, pointPosition.x, pointPosition.y, paint)
//        }
//    }
}