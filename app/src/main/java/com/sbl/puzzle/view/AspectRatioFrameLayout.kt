package com.sbl.puzzle.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.sbl.puzzle.R
import com.sbl.puzzle.view.AspectRatioMeasure.updateMeasureSpec

class AspectRatioFrameLayout : FrameLayout {

    private val mMeasureSpec = AspectRatioMeasure.Spec()
    private var mAspectRatio = 0f

    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        analysisAttrs(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!, attrs, defStyleAttr
    ) {
        analysisAttrs(attrs)
    }

    private fun analysisAttrs(attrs: AttributeSet?) {
        if (attrs != null) {
            val gdhAttrs = context.obtainStyledAttributes(
                attrs,
                R.styleable.AspectRatioLayout
            )
            val indexCount = gdhAttrs.indexCount
            for (i in 0 until indexCount) {
                val attr = gdhAttrs.getIndex(i)
                if (attr == R.styleable.AspectRatioLayout_aspectRatio) {
                    mAspectRatio = gdhAttrs.getFloat(attr, 0f)
                }
            }
            gdhAttrs.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        mMeasureSpec.width = widthMeasureSpec
        mMeasureSpec.height = heightMeasureSpec
        updateMeasureSpec(
            mMeasureSpec,
            mAspectRatio,
            layoutParams,
            paddingLeft + paddingRight,
            paddingTop + paddingBottom
        )
        super.onMeasure(mMeasureSpec.width, mMeasureSpec.height)
    }

    fun setAspectRatio(aspectRatio: Float) {
        if (aspectRatio == mAspectRatio) {
            return
        }
        mAspectRatio = aspectRatio
        requestLayout()
    }
}