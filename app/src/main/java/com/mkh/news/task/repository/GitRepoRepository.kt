package com.mkh.news.task.repository

import com.mkh.news.task.data.ApiService
import javax.inject.Inject

class GitRepoRepository @Inject
constructor(private val apiService: ApiService){
    suspend fun getRepo(q: String) = apiService.getRepositories(q)
}