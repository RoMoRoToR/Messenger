package com.example.pr1.data.vo

data class ConversationVO(
    val conversationId: Long,
    val secondPartyUsername: String,
    val messages: ArrayList<MessageVO>
)
