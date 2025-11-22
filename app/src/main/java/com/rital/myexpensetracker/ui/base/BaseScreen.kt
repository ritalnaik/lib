package com.rital.myexpensetracker.ui.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen(title: String,
               showBackButton: Boolean = false,
               onBackClick: (() -> Unit)? = null,
               actions: @Composable RowScope.() -> Unit = {},
               content: @Composable (PaddingValues) -> Unit){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    if (showBackButton && onBackClick != null) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Add Item"
                            )
                    } else null
                },
                actions = actions
            )
        },
        content = content
    )
}
