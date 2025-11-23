package com.rital.myexpensetracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rital.myexpensetracker.data.local.entity.Expense
import com.rital.myexpensetracker.data.repository.ExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject


sealed class ExpenseEvent {
    data class InsertSuccess(val message: String) : ExpenseEvent()
    data class Error(val message: String) : ExpenseEvent()
}

@HiltViewModel
class ExpenseViewModel @Inject constructor(
    private val expenseRepository: ExpenseRepository
): ViewModel() {
    private val _eventFlow = MutableSharedFlow<ExpenseEvent>()
    val eventFlow: SharedFlow<ExpenseEvent> = _eventFlow

    fun onAddExpenseClicked(type:String,amount: String, summary:String, category: String) {
        viewModelScope.launch {
            try {
                val newExpense = Expense(
                    type = "Expense",
                    amount = amount.toDouble(),
                    date = Calendar.getInstance().timeInMillis,
                    comment = "$summary",
                    category = "$category",
                    paymentMode="$category"
                )
                expenseRepository.addExpense(newExpense)
                _eventFlow.emit(ExpenseEvent.InsertSuccess("Expense added successfully!"))
            } catch (e: Exception) {
                // 4. Emit error event if insertion fails
                _eventFlow.emit(ExpenseEvent.Error("Failed to add expense: ${e.localizedMessage}"))
            }
        }
    }
}