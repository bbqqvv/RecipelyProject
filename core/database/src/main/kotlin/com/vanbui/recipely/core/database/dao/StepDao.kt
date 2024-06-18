package com.vanbui.recipely.core.database.dao

import androidx.room.Dao
import androidx.room.Query


@Dao
interface StepDao {
    @Query("SELECT media_url FROM Step WHERE media_url LIKE '%youtube.com%' OR media_url LIKE '%youtu.be%'")
    fun getYouTubeVideos(): List<String>
}
