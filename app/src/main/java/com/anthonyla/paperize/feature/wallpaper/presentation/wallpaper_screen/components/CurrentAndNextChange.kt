package com.anthonyla.paperize.feature.wallpaper.presentation.wallpaper_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QueuePlayNext
import androidx.compose.material.icons.outlined.RemoveFromQueue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.anthonyla.paperize.R

/**
 * Contains the current and next change components that shows the last and next set time
 */
@Composable
fun CurrentAndNextChange(
    lastSetTime: String?,
    nextSetTime: String?
) {
    val textFirst = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center, fontWeight = FontWeight.W500)
    val textSecond = MaterialTheme.typography.labelSmall.copy(textAlign = TextAlign.Center, fontWeight = FontWeight.W400)
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Surface(
            tonalElevation = 10.dp,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .weight(1f)
                .padding(PaddingValues(16.dp, 8.dp, 8.dp, 8.dp))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    Icons.Outlined.RemoveFromQueue,
                    contentDescription = stringResource(R.string.last_change),
                    modifier = Modifier.padding(end = 16.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Column {
                    lastSetTime?.split(" ", "\n")?.let { parts ->
                        if (parts.size == 2) {
                            Text(stringResource(R.string.last_change), style = textFirst, modifier = Modifier.align(Alignment.CenterHorizontally))
                            Text(parts[0].replace(',', ' '), style = textSecond, modifier = Modifier.align(Alignment.CenterHorizontally))
                            Text(parts[1], style = textSecond, modifier = Modifier.align(Alignment.CenterHorizontally))
                        }
                        else if (parts.size == 3) {
                            Text(stringResource(R.string.next_change), style = textFirst, modifier = Modifier.align(Alignment.CenterHorizontally))
                            Text(parts[0].replace(',', ' '), style = textSecond, modifier = Modifier.align(Alignment.CenterHorizontally))
                            Text(parts[1] + ' ' + parts[2], style = textSecond, modifier = Modifier.align(Alignment.CenterHorizontally))
                        }
                    }
                }

            }
        }
        Surface(
            tonalElevation = 10.dp,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .weight(1f)
                .padding(PaddingValues(16.dp, 8.dp, 8.dp, 8.dp))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    Icons.Outlined.QueuePlayNext,
                    contentDescription = stringResource(R.string.next_change),
                    modifier = Modifier.padding(end = 16.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Column {
                    nextSetTime?.split(" ", "\n")?.let { parts ->
                        if (parts.size == 2) {
                            Text(stringResource(R.string.next_change), style = textFirst, modifier = Modifier.align(Alignment.CenterHorizontally))
                            Text(parts[0].replace(',', ' '), style = textSecond, modifier = Modifier.align(Alignment.CenterHorizontally))
                            Text(parts[1], style = textSecond, modifier = Modifier.align(Alignment.CenterHorizontally))
                        }
                        else if (parts.size == 3) {
                            Text(stringResource(R.string.last_change), style = textFirst, modifier = Modifier.align(Alignment.CenterHorizontally))
                            Text(parts[0].replace(',', ' '), style = textSecond, modifier = Modifier.align(Alignment.CenterHorizontally))
                            Text(parts[1] + ' ' + parts[2], style = textSecond, modifier = Modifier.align(Alignment.CenterHorizontally))
                        }
                    }
                }
            }
        }
    }
}