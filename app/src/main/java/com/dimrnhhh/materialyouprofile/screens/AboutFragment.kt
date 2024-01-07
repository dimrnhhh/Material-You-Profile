package com.dimrnhhh.materialyouprofile.screens

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.dimrnhhh.materialyouprofile.databinding.FragmentAboutBinding
import com.dimrnhhh.materialyouprofile.databinding.FragmentEditBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.instagramLink.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.instagram.com/dimrnhhh/")
            startActivity(openURL)
        }
        binding.githubLink.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://github.com/dimrnhhh/")
            startActivity(openURL)
        }
        binding.phoneDial.setOnClickListener {
            val openDIAL = Intent(Intent.ACTION_DIAL)
            openDIAL.data = Uri.parse("tel:0812345678901")
            startActivity(openDIAL)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}