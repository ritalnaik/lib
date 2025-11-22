package com.rital.myexpensetracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rital.myexpensetracker.data.local.dao.ExpenseDao
import com.rital.myexpensetracker.data.local.entity.Expense

@Database(
    entities = [Expense::class],
    version = 1,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract  fun expenseDao(): ExpenseDao
}