package com.example.sessions_clean.android.ui.providers

import androidx.compose.runtime.mutableStateListOf
import com.example.sessions_clean.domain.model.GenericNotification

class NotificationQueueState {
    val queue = mutableStateListOf<GenericNotification>()

    fun addNotification(notificationInfo: GenericNotification.Builder) {
        if (queue.isNotEmpty()) queue.removeFirst()
        queue.add(notificationInfo.build())
    }

    fun removeFirstNotification() {
        if (!queue.isEmpty())
            queue.removeFirst()
    }
}