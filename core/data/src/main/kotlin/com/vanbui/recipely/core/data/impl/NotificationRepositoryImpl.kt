package com.vanbui.recipely.core.data.impl

import com.vanbui.recipely.core.data.NotificationService
import com.vanbui.recipely.core.data.mapper.toNotificationEntity
import com.vanbui.recipely.core.data.repository.NotificationRepository
import com.vanbui.recipely.core.database.dao.NotificationDao
import com.vanbui.recipely.core.datastore.RecipelyPreferencesDataSource
import com.vanbui.recipely.core.model.Notification
import com.vanbui.recipely.core.model.NotificationType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NotificationRepositoryImpl @Inject constructor(
    private val notificationDao: NotificationDao,
    private val preferencesDataSource: RecipelyPreferencesDataSource,
    private val notificationService: NotificationService
) : NotificationRepository {
    override fun getCurrentUserNotification(
    ): Flow<List<Notification>> {
        return flow {
            val id = preferencesDataSource.loggedId.first()
            notificationDao.getUserNotification(id).map { map ->
                map.map { notification ->
                    notification.toNotification()
                }
            }.collect {
                emit(it)
            }
        }
    }

    override suspend fun insertNotification(notification: Notification) {

        notification.toNotificationEntity().let {
            notificationDao.insertNotification(it)
            val title = when (notification.notificationType) {
                NotificationType.Like -> "Recipely Like"
                NotificationType.Order -> "Recipely Order"
            }
            notificationService.showNotification(notification.message, title, 2)
        }
    }

    override suspend fun readNotification(notificationId: String) {
        notificationDao.readNotification(notificationId)
    }
}