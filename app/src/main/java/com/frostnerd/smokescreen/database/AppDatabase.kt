package com.frostnerd.smokescreen.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.frostnerd.smokescreen.database.dao.CachedResponseDao
import com.frostnerd.smokescreen.database.dao.DnsQueryDao
import com.frostnerd.smokescreen.database.entities.CachedResponse
import com.frostnerd.smokescreen.database.entities.DnsQuery
import com.frostnerd.smokescreen.database.repository.CachedResponseRepository
import com.frostnerd.smokescreen.database.repository.DnsQueryRepository

/**
 * Copyright Daniel Wolf 2018
 * All rights reserved.
 * Code may NOT be used without proper permission, neither in binary nor in source form.
 * All redistributions of this software in source code must retain this copyright header
 * All redistributions of this software in binary form must visibly inform users about usage of this software
 *
 * development@frostnerd.com
 */

@Database(entities = [CachedResponse::class, DnsQuery::class], version = AppDatabase.currentVersion)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val currentVersion:Int = 5
    }

    abstract fun cachedResponseDao(): CachedResponseDao
    abstract fun dnsQueryDao():DnsQueryDao

    fun cachedResponseRepository() = CachedResponseRepository(cachedResponseDao())
    fun dnsQueryRepository() = DnsQueryRepository(dnsQueryDao())
}