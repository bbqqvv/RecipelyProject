package com.anbui.recipely.core.data.repository

interface StepRepository {
    suspend fun getYouTubeVideos(): List<String>
}
