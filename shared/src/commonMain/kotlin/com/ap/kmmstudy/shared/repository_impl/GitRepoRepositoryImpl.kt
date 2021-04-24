package com.ap.kmmstudy.shared.repository_impl

import com.ap.kmmstudy.shared.entity.GitRepository
import com.ap.kmmstudy.shared.network_client.GithubRepoClient
import com.ap.kmmstudy.shared.repository.GitRepoRepository

class GitRepoRepositoryImpl : GitRepoRepository {

    override suspend fun getRepository(): List<GitRepository> {
        return GithubRepoClient().getAllRepositories().items
    }
}