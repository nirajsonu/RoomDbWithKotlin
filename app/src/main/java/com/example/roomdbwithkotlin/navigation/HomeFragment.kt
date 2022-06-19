package com.example.roomdbwithkotlin.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.roomdbwithkotlin.R
import com.example.roomdbwithkotlin.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

lateinit var binding:FragmentHomeBinding
lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(layoutInflater,container,false)

        navController=findNavController()
        binding.changeFragment.setOnClickListener {
            changeFragment()
        }




        return binding.root
    }

    private fun changeFragment() {

    //Though Traditional way
    //  navController.navigate(R.id.settingFragment)

        //Though actions
        navController.navigate(R.id.action_homeFragment2_to_aboutFragment3)

        //Though Direction classes

       // HomeFragmentDirections.actionHomeFragment2ToAboutFragment3()

    }


}