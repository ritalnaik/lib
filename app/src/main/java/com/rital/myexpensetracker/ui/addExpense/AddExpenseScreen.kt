package com.rital.myexpensetracker.ui.addExpense

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rital.myexpensetracker.R
import com.rital.myexpensetracker.ui.components.DropDown
import com.rital.myexpensetracker.ui.components.PrimaryButton
import com.rital.myexpensetracker.ui.viewmodel.ExpenseEvent
import com.rital.myexpensetracker.ui.viewmodel.ExpenseViewModel
import com.rital.myexpensetracker.utils.theme.BackgroundColor
import com.rital.myexpensetracker.utils.theme.PrimaryColor
import kotlinx.coroutines.flow.collectLatest
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpenseScreen(
    navController: NavController,
    viewModel: ExpenseViewModel = hiltViewModel()
) {
    var expenseTypeText by remember { mutableStateOf("Select Option") }
    var expenseCategoryText by remember { mutableStateOf("Select Option") }
    var amountText by remember { mutableStateOf("") }
    var commentText by remember { mutableStateOf("") }
    var dateText by remember { mutableStateOf("25/11/2025") }
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is ExpenseEvent.InsertSuccess -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_LONG).show()
//                    todo navigate back to previous screen
                //                    onCloseScreen()
                }
                is ExpenseEvent.Error -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.title_activity_add_expense)) },
                    colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryColor,
                    titleContentColor = BackgroundColor
                ))
        },
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(innerPadding)
            .padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))) {
            DropDown(option = listOf("Expense","Income"),
                selectedItem = expenseTypeText,
                onItemSelected = {
                expenseTypeText = it
            })
            DropDown(option = listOf("Food","Travel","Shopping","Health","Education","Other"),
                selectedItem = expenseCategoryText,
                onItemSelected = {
                expenseCategoryText = it
            })
            OutlinedTextField(
                value = amountText,
                onValueChange = { amountText = it },
                label = { Text(stringResource(R.string.hint_enter_amount)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                modifier = Modifier.fillMaxWidth()
                    .height(dimensionResource(R.dimen.edit_text_height))
            )
            OutlinedTextField(
                value = commentText,
                onValueChange = { commentText = it },
                label = { Text(stringResource(R.string.hint_expense_comments)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Unspecified
                ),
                modifier = Modifier.fillMaxWidth()
                    .height(dimensionResource(R.dimen.edit_text_height))
            )
            OutlinedTextField(
                value = dateText,
                onValueChange = { dateText = it },
                label = { Text(stringResource(R.string.hint_date)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Unspecified
                ),
                modifier = Modifier.fillMaxWidth()
                    .height(dimensionResource(R.dimen.edit_text_height))
            )
            PrimaryButton(
                text = stringResource(R.string.btn_save_expense),
                onClick = {
                    viewModel.onAddExpenseClicked(
                        type = expenseTypeText, // Replace with actual input value
                        amount = amountText, // Replace with actual input value
                        comments = commentText, // Replace with actual input value
                        category = expenseCategoryText, // Replace with actual input value
                        dateTime = Calendar.getInstance().timeInMillis,
                    )
                }
            )
        }

    }
}