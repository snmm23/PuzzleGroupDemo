package com.sbl.puzzle.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sbl.puzzle.R
import com.sbl.puzzle.databinding.FragmentDetailBinding
import com.sbl.puzzle.view.PuzzleContentBaseBean
import com.sbl.puzzle.view.PuzzleGroupLayout

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val puzzleGroupLayout = PuzzleGroupLayout<Int>(requireContext(), 8, 6)
        puzzleGroupLayout.setGridSpacing(5)
        puzzleGroupLayout.setGridSpacingColor(requireContext().getColor(R.color.white))
        binding.viewGroup.addView(puzzleGroupLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val adapter = DetailPuzzleAdapter(requireContext())
        puzzleGroupLayout.adapter = adapter

        val dataCells = mutableListOf<PuzzleContentBaseBean<Int>>()
        dataCells.add(PuzzleContentBaseBean<Int>(0, 0, 1, 1).apply {
            this.contentData = R.drawable.p1
        })
        dataCells.add(PuzzleContentBaseBean<Int>(0, 1, 1, 5).apply {
            this.contentData = R.drawable.p2
        })
        dataCells.add(PuzzleContentBaseBean<Int>(1, 0, 3, 3).apply {
            this.contentData = R.drawable.p3
        })
        dataCells.add(PuzzleContentBaseBean<Int>(1, 3, 2, 3).apply {
            this.contentData = R.drawable.p4
        })
        dataCells.add(PuzzleContentBaseBean<Int>(3, 3, 1, 3).apply {
            this.contentData = R.drawable.p5
        })
        dataCells.add(PuzzleContentBaseBean<Int>(4, 0, 3, 2).apply {
            this.contentData = R.drawable.p6
        })
        dataCells.add(PuzzleContentBaseBean<Int>(4, 2, 2, 2).apply {
            this.contentData = R.drawable.p7
        })
        dataCells.add(PuzzleContentBaseBean<Int>(4, 4, 2, 1).apply {
            this.contentData = R.drawable.p8
        })
        dataCells.add(PuzzleContentBaseBean<Int>(7, 0, 1, 3).apply {
            this.contentData = R.drawable.p9
        })
        dataCells.add(PuzzleContentBaseBean<Int>(6, 2, 1, 1).apply {
            this.contentData = R.drawable.p10
        })
        dataCells.add(PuzzleContentBaseBean<Int>(6, 3, 2, 2).apply {
            this.contentData = R.drawable.p11
        })
        dataCells.add(PuzzleContentBaseBean<Int>(4, 5, 4, 1).apply {
            this.contentData = R.drawable.p12
        })
        adapter.setData(dataCells)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}