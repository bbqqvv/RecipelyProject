package com.vanbui.recipely.feature.account.setting

import androidx.lifecycle.ViewModel
import com.vanbui.recipely.core.data.repository.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val accountRepository: AccountRepository
) : ViewModel() {
    suspend fun logout() {
        accountRepository.logout()
    }
}
