package com.sbl.puzzle.ui

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.sbl.puzzle.view.PuzzleContentAdapter
import com.sbl.puzzle.view.PuzzleGroupLayout

class DetailPuzzleAdapter(private val context: Context): PuzzleContentAdapter<Int>() {

    override fun getView(parent: PuzzleGroupLayout<Int>, position: Int, t: Int): View {
        val imageView = ImageView(context)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.setImageResource(t)
        return imageView
    }
}