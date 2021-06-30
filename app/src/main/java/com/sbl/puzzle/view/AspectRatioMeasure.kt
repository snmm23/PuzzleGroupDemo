package com.sbl.puzzle.view

import android.view.View
import android.view.ViewGroup

internal object AspectRatioMeasure {

    @JvmStatic
    fun updateMeasureSpec(
        spec: Spec,
        aspectRatio: Float,
        layoutParams: ViewGroup.LayoutParams?,
        widthPadding: Int,
        heightPadding: Int
    ) {
        if (aspectRatio <= 0 || layoutParams == null) {
            return
        }
        if (shouldAdjust(layoutParams.height)) {
            val widthSpecSize = View.MeasureSpec.getSize(spec.width)
            val desiredHeight =
                ((widthSpecSize - widthPadding) / aspectRatio + heightPadding).toInt()
            val resolvedHeight = View.resolveSize(desiredHeight, spec.height)
            spec.height = View.MeasureSpec.makeMeasureSpec(resolvedHeight, View.MeasureSpec.EXACTLY)
        } else if (shouldAdjust(layoutParams.width)) {
            val heightSpecSize = View.MeasureSpec.getSize(spec.height)
            val desiredWidth =
                ((heightSpecSize - heightPadding) * aspectRatio + widthPadding).toInt()
            val resolvedWidth = View.resolveSize(desiredWidth, spec.width)
            spec.width = View.MeasureSpec.makeMeasureSpec(resolvedWidth, View.MeasureSpec.EXACTLY)
        }
    }

    private fun shouldAdjust(layoutDimension: Int): Boolean {
        // Note: wrap_content is supported for backwards compatibility, but should not be used.
        return layoutDimension == 0 || layoutDimension == ViewGroup.LayoutParams.WRAP_CONTENT
    }

    /**
     * Holder for width and height measure specs.
     */
    class Spec {
        @JvmField
        var width = 0
        @JvmField
        var height = 0
    }
}