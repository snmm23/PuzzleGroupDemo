package com.sbl.puzzle.view

import android.content.Context
import android.view.ViewGroup
import com.sbl.puzzle.R
import com.sbl.puzzle.view.PuzzleContentAdapter.OnDataChangedListener

class PuzzleGroupLayout<T> (
    context: Context?,
    private val row: Int, //行
    private val col: Int //列
) : ViewGroup(context), OnDataChangedListener {

    /**
     * 单元格宽度
     */
    private var cellWidth = 0

    /**
     * 单元格高度
     */
    private var cellHeight = 0

    /**
     * 单元格间隙
     */
    private var gridSpacing = 0


    var adapter: PuzzleContentAdapter<T>? = null
        set(adapter) {
            field = adapter
            field!!.setOnDataChangedListener(this)
            changeAdapter()
        }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthValue = MeasureSpec.getSize(widthMeasureSpec)
        val heightValue = MeasureSpec.getSize(heightMeasureSpec)
        cellHeight = (heightValue - gridSpacing * (row + 1)) / row
        cellWidth = (widthValue - gridSpacing * (col + 1)) / col
        val count = childCount
        for (i in 0 until count) {
            adapter?.getItem(i)?.let {
                val itemW = cellWidth * it.colSpan + gridSpacing * (it.colSpan - 1)
                val itemH = cellHeight * it.rowSpan + gridSpacing * (it.rowSpan - 1)
                getChildAt(i).measure(
                    MeasureSpec.makeMeasureSpec(itemW, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(itemH, MeasureSpec.EXACTLY)
                )
            }
        }

        val realWidth = (cellWidth * col) + (gridSpacing * (col + 1))
        val realHeight = (cellHeight * row) + (gridSpacing * (row + 1))
        setMeasuredDimension(realWidth, realHeight)
    }


    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val childCount = childCount
        for (i in 0 until childCount) {
            adapter?.getItem(i)?.let {
                val left = it.col * cellWidth + gridSpacing * (it.col + 1)
                val top = it.row * cellHeight + gridSpacing * (it.row + 1)
                val right = left + cellWidth * it.colSpan + gridSpacing * (it.colSpan - 1)
                val bottom =
                    top + cellHeight * it.rowSpan + gridSpacing * (it.rowSpan - 1)
                getChildAt(i).layout(left, top, right, bottom)
            }
        }
    }


    fun setGridSpacing(spacing: Int) {
        gridSpacing = spacing
    }

    fun setGridSpacingColor(color: Int) {
        setBackgroundColor(color)
    }

    override fun onChanged() {
        changeAdapter()
    }


    private fun changeAdapter() {
        removeAllViews()
        if (adapter == null) {
            return
        }
        for (i in 0 until adapter!!.count) {
            if (adapter!!.getItem(i) != null) {
                val tagView = adapter!!.getView(this, i, adapter!!.getItem(i)!!.contentData!!)
                tagView.setBackgroundColor(context.getColor(R.color.white))
                addView(tagView)
            }
        }
    }
}