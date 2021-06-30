package com.sbl.puzzle.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sbl.puzzle.R
import com.sbl.puzzle.databinding.FragmentSelectBinding

class SelectFragment : Fragment() {

    companion object {
        const val SELECT_STYLE_INDEX = "select_style_index"
    }

    private var _binding: FragmentSelectBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonOne.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt(SELECT_STYLE_INDEX, 1)
            findNavController().navigate(R.id.action_Select_to_Detail, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}