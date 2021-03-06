package com.example.jub_jub_android.di.modules

import com.example.jub_jub_android.ui.view.equipment_status.EquipmentStatus_ViewModel
import com.example.jub_jub_android.ui.view.myrentstatus.MyRentList_ViewModel
import com.example.jub_jub_android.ui.view.rent_request.RentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val activityModule = module {

    viewModel {
        EquipmentStatus_ViewModel()
    }

}