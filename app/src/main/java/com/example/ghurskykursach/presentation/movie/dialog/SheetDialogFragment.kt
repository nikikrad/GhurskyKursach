package com.example.ghurskykursach.presentation.movie.dialog

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.ghurskykursach.R
import com.example.ghurskykursach.databinding.DialogSheetFragmentDescriptionBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SheetDialogFragment: BottomSheetDialogFragment() {

    private lateinit var binding: DialogSheetFragmentDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogSheetFragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.tvDescription.text = arguments?.getString("DESCRIPTION")
//        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        setStyle(DialogFragment.STYLE_NO_FRAME, R.drawable.back_for_sheet_dialog)
    }

}