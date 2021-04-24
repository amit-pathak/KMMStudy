package com.ap.kmmstudy.shared.repository

import com.ap.kmmstudy.shared.entity.GitRepository

interface GitRepoRepository {

    suspend fun getRepository() : List<GitRepository>
}