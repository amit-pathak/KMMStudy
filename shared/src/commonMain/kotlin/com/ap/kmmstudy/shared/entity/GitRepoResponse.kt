package com.ap.kmmstudy.shared.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitRepoResponse constructor(@SerialName("items") val items: List<GitRepository>)

@Serializable
data class GitRepository constructor(@SerialName("id") val id : Double,
                                     @SerialName("full_name") val fullName : String,
                                     @SerialName("owner") val owner : RepoOwner)
@Serializable
data class RepoOwner constructor(val id : Double,
                                 @SerialName("avatar_url") val avatarUrl : String)
