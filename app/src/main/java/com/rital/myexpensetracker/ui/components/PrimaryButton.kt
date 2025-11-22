package com.rital.myexpensetracker.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.rital.myexpensetracker.R

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(dimensionResource(id = R.dimen.std_height)),
        enabled = enabled,
        // 🔑 1. Set the rounded corners using the 'shape' parameter
        shape = MaterialTheme.shapes.medium, // Default Material 3 rounded corners
        // OR: shape = RoundedCornerShape(8.dp) // Custom specific radius

        // 🔑 2. Optional: Customize content colors if needed (defaults to primary)
        colors = ButtonDefaults.buttonColors(
            containerColor = ColorPrimary,
            contentColor = MaterialTheme.colorScheme.onPrimary // Text color that contrasts with primary
        )
    ) {
        Text(text = text.uppercase(), color = White)
    }
}