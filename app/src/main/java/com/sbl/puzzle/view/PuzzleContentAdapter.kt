package com.sbl.puzzle.view

import android.view.View


abstract class PuzzleContentAdapter<T> {

    private var mList: MutableList<PuzzleContentBaseBean<T>> = mutableListOf()

    private var mOnDataChangedListener: OnDataChangedListener? = null


    fun setData(data: MutableList<PuzzleContentBaseBean<T>>) {
        mList.clear()
        mList.addAll(data)
        notifyDataChanged()
    }


    fun setOnDataChangedListener(listener: OnDataChangedListener?) {
        mOnDataChangedListener = listener
    }


    val count: Int
        get() = if (mList.size == 0) 0 else mList.size


    private fun notifyDataChanged() {
        mOnDataChangedListener!!.onChanged()
    }


    fun getItem(position: Int): PuzzleContentBaseBean<T>? {
        return if(mList.size >= 0) mList[position] else null
    }


    abstract fun getView(parent: PuzzleGroupLayout<T>, position: Int, t: T): View


    interface OnDataChangedListener {
        fun onChanged()
    }
}