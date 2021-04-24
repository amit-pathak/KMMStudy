package com.ap.kmmstudy.shared.network_client

import com.ap.kmmstudy.shared.entity.GitRepoResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json

import io.ktor.client.request.*

class GithubRepoClient {
    private val httpClient = HttpClient() {
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
        install(Logging) {
            /*val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)*/
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    suspend fun getAllRepositories(): GitRepoResponse {
        return httpClient.get(ENDPOINT)
    }


    companion object {
        private const val ENDPOINT = "https://api.github.com/search/repositories?q=android%20studio"
    }
}