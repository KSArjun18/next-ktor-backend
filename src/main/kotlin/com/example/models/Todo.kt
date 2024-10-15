package com.example.models

import kotlinx.serialization.Serializable
 
@Serializable
data class Todo(
    val id: Int,
    val title: String,
    val isCompleted: Boolean
)
