package com.rital.myexpensetracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rital.myexpensetracker.data.local.entity.Expense

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: Expense)

    @Query("SELECT * FROM ${Expense.TABLE_NAME} ORDER BY ${Expense.COLUMN_DATE} DESC")
    suspend fun getAllExpenses(): List<Expense>

    @Query("SELECT * FROM ${Expense.TABLE_NAME}  WHERE ${Expense.COLUMN_ID} = :id ORDER BY ${Expense.COLUMN_DATE} DESC")
    suspend fun getExpense(id: Long): List<Expense>
}