package com.mkh.news.task.models

data class RepositoriesModel(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)