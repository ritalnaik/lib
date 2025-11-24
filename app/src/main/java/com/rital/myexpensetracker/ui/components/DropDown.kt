package com.rital.myexpensetracker.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.rital.myexpensetracker.R

@Composable
fun DropDown(
    option: List<String> = listOf(),
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val options = option

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopStart) // Aligns the menu to the start of the box
            .border(
                width = dimensionResource(R.dimen.std_border_width),
                color = ColorPrimary,
                shape = MaterialTheme.shapes.extraSmall
            )
            .padding(dimensionResource(R.dimen.padding_small))
            .height(dimensionResource(R.dimen.std_height))
    ) {
        // 1. Clickable Element (The visible button/text)
        Text(
            text = selectedItem,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
                .align(Alignment.CenterStart), // Align text to the start
            style = MaterialTheme.typography.bodyLarge
        )

        // 2. The Dropdown Menu
        DropdownMenu(
            expanded = expanded, // Controls visibility
            onDismissRequest = { expanded = !expanded } // Closes when clicking outside
        ) {
            // Loop through the options to create menu items
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        onItemSelected(selectionOption)
                        expanded = false
                    }
                )
            }
        }
    }
}