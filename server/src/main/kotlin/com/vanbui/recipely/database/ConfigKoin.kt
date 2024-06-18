package com.vanbui.recipely.database

import com.vanbui.recipely.database.di.databaseModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.configKoin() {
    install(Koin) {
        modules(databaseModule)
    }
}