package com.rital.myexpensetracker.ui.addExpense

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rital.myexpensetracker.R
import com.rital.myexpensetracker.ui.components.PrimaryButton
import com.rital.myexpensetracker.utils.theme.BackgroundColor
import com.rital.myexpensetracker.utils.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpenseScreen(navController: NavController) {
    var amountText by remember { mutableStateOf("") }
    var summaryText by remember { mutableStateOf("") }
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
            .padding(innerPadding),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))) {

            OutlinedTextField(
                value = amountText,
                onValueChange = { amountText = it },
                label = { Text(stringResource(R.string.hint_enter_amount)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = stringResource(R.string.hint_expense_summary),
                onValueChange = { amountText = it },
                label = { Text(stringResource(R.string.hint_enter_amount)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Unspecified
                ),
                modifier = Modifier.fillMaxWidth()
            )
            PrimaryButton(
                text = stringResource(R.string.btn_save_expense),
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            )
        }

    }
}