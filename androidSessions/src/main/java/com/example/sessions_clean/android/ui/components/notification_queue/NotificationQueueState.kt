package com.example.sessions_clean.android.ui.components.notification_queue

import androidx.compose.runtime.mutableStateListOf
import com.example.sessions_clean.domain.model.GenericNotification

class NotificationQueueState {
    val queue = mutableStateListOf<GenericNotification>()

    fun addNotification(notificationInfo: GenericNotification.Builder) {
        queue.add(notificationInfo.build())
    }

    fun removeFirstNotification() {
        if (!queue.isEmpty())
            queue.removeFirst()
    }
}