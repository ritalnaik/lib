package com.rital.myexpensetracker.data.repository

import com.rital.myexpensetracker.data.local.dao.ExpenseDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExpenseRepository @Inject constructor(
    private val expenseDao: ExpenseDao
) {
    fun getExpenseDao(): ExpenseDao {
        return expenseDao
    }
}