package com.rital.myexpensetracker.data.repository

import com.rital.myexpensetracker.data.local.dao.ExpenseDao
import com.rital.myexpensetracker.data.local.entity.Expense
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExpenseRepository @Inject constructor(
    private val expenseDao: ExpenseDao
) {
    suspend fun addExpense(expense: Expense) {
        withContext(Dispatchers.IO) {
            expenseDao.insertExpense(expense)
        }
    }
}