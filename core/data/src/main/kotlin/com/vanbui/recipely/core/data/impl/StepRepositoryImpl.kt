package com.vanbui.recipely.core.data.impl

import com.vanbui.recipely.core.data.repository.StepRepository
import com.vanbui.recipely.core.database.dao.StepDao

class StepRepositoryImpl(private val stepDao: StepDao) : StepRepository {

    override suspend fun getYouTubeVideos(): List<String> {
        return stepDao.getYouTubeVideos()
    }
}
