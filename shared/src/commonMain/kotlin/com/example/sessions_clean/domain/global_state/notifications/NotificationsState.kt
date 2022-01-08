package com.example.sessions_clean.domain.global_state.notifications

import com.example.sessions_clean.domain.model.GenericNotification
import com.example.sessions_clean.domain.util.Queue

class NotificationsState(
    var queue: Queue<GenericNotification> = Queue(mutableListOf())
) {
    constructor() : this(
        queue = Queue(mutableListOf())
    )
}