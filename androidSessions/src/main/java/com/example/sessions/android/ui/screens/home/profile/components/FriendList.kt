package com.example.sessions.android.ui.screens.home.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.sessions.android.ui.components.Avatar
import com.example.sessions.android.ui.theme.ExtendedTheme
import com.example.sessions.android.ui.theme.Spacing
import com.example.sessions.model.Friend
import com.example.sessions.model.Profile
import com.example.sessions.presentation.home.profile.FriendListState
import org.koin.androidx.compose.get

@Composable
fun FriendList(
    state: FriendListState = get<FriendListViewModel>().state.value
) {
    LazyRow(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Spacing.s),
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add friend")
            }
        }
        items(items = state.friends, itemContent = { friend ->
            Avatar(profile = friend)
        })
        if (state.isLoading)
            item {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.5.dp
                )
            }
    }
}
