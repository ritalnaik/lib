package com.rital.myexpensetracker.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rital.myexpensetracker.data.local.entity.Expense
import com.rital.myexpensetracker.data.repository.ExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed class ExpenseEvent {
    data class InsertSuccess(val message: String) : ExpenseEvent()
    data class Error(val message: String) : ExpenseEvent()
}

@HiltViewModel
class ExpenseViewModel @Inject constructor(
    private val expenseRepository: ExpenseRepository
): ViewModel() {
    init {
        viewModelScope.launch {
            expenseRepository.addExpense( Expense(
                type = "type",
                amount = 100.0,
                date = System.currentTimeMillis(),
                comment = "comments",
                category = "category",
                paymentMode= "category"
            ))
        }
    }
    private val _eventFlow = MutableSharedFlow<ExpenseEvent>()
    val eventFlow: SharedFlow<ExpenseEvent> = _eventFlow

    fun onAddExpenseClicked(type:String,amount: String, comments:String, category: String, dateTime: Long) {
        viewModelScope.launch {
            try {
                val newExpense = Expense(
                    type = type,
                    amount = amount.toDouble(),
                    date = dateTime,
                    comment = comments,
                    category = category,
                    paymentMode= category
                )
                expenseRepository.addExpense(newExpense)
                _eventFlow.emit(ExpenseEvent.InsertSuccess("Expense added successfully!"))
            } catch (e: Exception) {
                Log.d("ExpenseViewModel", "Error adding expense: ${e}")
                _eventFlow.emit(ExpenseEvent.Error("Failed to add expense: ${e}"))
            }
        }
    }
}