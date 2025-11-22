package com.rital.myexpensetracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.rital.myexpensetracker.data.repository.ExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(
    private val expenseRepository: ExpenseRepository
): ViewModel() {

}