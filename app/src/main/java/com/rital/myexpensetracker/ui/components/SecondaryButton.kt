package com.rital.myexpensetracker.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.rital.myexpensetracker.R
import com.rital.myexpensetracker.utils.theme.PrimaryColor

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(dimensionResource(R.dimen.std_height)),
        enabled = enabled,
        // 🔑 1. Set the rounded corners using the 'shape' parameter
        shape = MaterialTheme.shapes.medium, // Default Material 3 rounded corners
        // OR: shape = RoundedCornerShape(8.dp) // Custom specific radius

        // 🔑 2. Optional: Customize content colors if needed (defaults to primary)
        border = ButtonDefaults.outlinedButtonBorder.copy(width =
        ButtonDefaults.outlinedButtonBorder.width),
        colors = ButtonDefaults.buttonColors(
            containerColor = White,
            contentColor = MaterialTheme.colorScheme.onPrimary // Text color that contrasts with primary
        )
    ) {
        Text(text = text, color = PrimaryColor)
    }
}