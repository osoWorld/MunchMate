package com.example.munchmate.bottomFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.munchmate.R
import com.example.munchmate.databinding.FragmentProfileBinding
import com.example.munchmate.registration.Activities.LoginActivity
import com.example.munchmate.registration.Classes.authRepo.AuthRepo
import com.example.munchmate.registration.Classes.authViewModel.AuthViewModel
import com.example.munchmate.registration.Classes.authViewModelFactory.AuthViewModelFactory

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var authViewModel: AuthViewModel
    private val authRepo = AuthRepo()
    private val authViewModelFactory = AuthViewModelFactory(authRepo)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authViewModel = ViewModelProvider(requireActivity(),authViewModelFactory)[AuthViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logoutButton.setOnClickListener {
            authViewModel.byeBye()
            authViewModel.bye.observe(requireActivity()){bye ->
                if (bye){
                    startActivity(Intent(requireActivity(),LoginActivity::class.java))
                }
            }
        }
    }
}