package com.example.stateflowexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.stateflowexample.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        initCountObserver()
    }

    private fun initCountObserver() {
        lifecycleScope.launchWhenStarted {
            mainViewModel.counterState.collect {
                binding.result.text=it.toString()
            }
        }
    }

    private fun init() {
        binding.increment.setOnClickListener{
            mainViewModel.incrementCount()
        }
        binding.decrement.setOnClickListener{
            mainViewModel.decrementCount()
        }
    }
}