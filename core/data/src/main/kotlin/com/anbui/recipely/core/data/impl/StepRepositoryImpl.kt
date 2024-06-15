package com.anbui.recipely.core.data.impl

import com.anbui.recipely.core.data.repository.StepRepository
import com.anbui.recipely.core.database.dao.StepDao

class StepRepositoryImpl(private val stepDao: StepDao) : StepRepository {

    override suspend fun getYouTubeVideos(): List<String> {
        return stepDao.getYouTubeVideos()
    }
}
