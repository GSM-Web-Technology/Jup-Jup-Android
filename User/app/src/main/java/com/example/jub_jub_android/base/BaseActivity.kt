package com.example.jub_jub_android.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.jub_jub_android.BR

abstract class BaseActivity <B: ViewDataBinding, VM: BaseViewModel>(
    @LayoutRes private val layoutResId: Int
    ): AppCompatActivity() {

    lateinit var binding: B
    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this

    }


}