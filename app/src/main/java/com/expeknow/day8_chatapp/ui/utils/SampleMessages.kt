package com.expeknow.day8_chatapp.ui.utils

import com.expeknow.day8_chatapp.R

class SampleMessage (
    val message: String,
    val time: String,
    val sendersPicId: Int,
    val receiversPicId: Int,
    val isSent: Boolean,
    val isRead : Boolean
    )


val sampleMessages = listOf(
    SampleMessage(
        message = "Hey! How was the movie Your Name?",
        time = "Today 11:07 AM",
        sendersPicId = R.drawable.p2,
        receiversPicId = R.drawable.profile,
        isSent = true,
        isRead = true
    ),
    SampleMessage(
        message = "It was amazing! The animation and storyline were incredible.",
        time = "Today 11:10 AM",
        sendersPicId = R.drawable.profile,
        receiversPicId = R.drawable.p2,
        isSent = false,
        isRead = true
    ),
    SampleMessage(
        message = "I'm glad you liked it! I've been meaning to watch it too.",
        time = "Today 11:12 AM",
        sendersPicId = R.drawable.p2,
        receiversPicId = R.drawable.profile,
        isSent = true,
        isRead = true
    ),
    SampleMessage(
        message = "You should definitely give it a watch. You won't be disappointed!",
        time = "Today 11:15 AM",
        sendersPicId = R.drawable.profile,
        receiversPicId = R.drawable.p2,
        isSent = false,
        isRead = true
    ),
    SampleMessage(
        message = "I will! Thanks for the recommendation.",
        time = "Today 11:18 AM",
        sendersPicId = R.drawable.p2,
        receiversPicId = R.drawable.profile,
        isSent = true,
        isRead = true
    ),
    SampleMessage(
        message = "No problem! Let me know how you like it.",
        time = "Today 11:20 AM",
        sendersPicId = R.drawable.profile,
        receiversPicId = R.drawable.p2,
        isSent = false,
        isRead = true
    ),
    SampleMessage(
        message = "Sure, I'll share my thoughts with you. Thanks again!",
        time = "Today 11:22 AM",
        sendersPicId = R.drawable.p2,
        receiversPicId = R.drawable.profile,
        isSent = true,
        isRead = false
    )
)
