package com.vanbui.recipely.core.data.repository

interface StepRepository {
    suspend fun getYouTubeVideos(): List<String>
}
