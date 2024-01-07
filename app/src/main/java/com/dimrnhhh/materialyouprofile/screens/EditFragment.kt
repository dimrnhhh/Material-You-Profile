package com.dimrnhhh.materialyouprofile.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dimrnhhh.materialyouprofile.databinding.FragmentEditBinding
import com.dimrnhhh.materialyouprofile.utils.NotificationService

class EditFragment : Fragment() {

    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {
            Toast.makeText(requireActivity(), "Berhasil Disimpan", Toast.LENGTH_LONG).show()
            activity?.let { NotificationService(it.applicationContext) }
                ?.showNotification()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}