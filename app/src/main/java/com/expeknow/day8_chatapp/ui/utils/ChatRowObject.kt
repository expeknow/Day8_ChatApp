package com.expeknow.day8_chatapp.ui.utils

import com.expeknow.day8_chatapp.R

class ChatRowObject (
    val name: String,
    val lastMessage: String,
    val time: String,
    val unreadMessageCount : Int,
    val picId: Int
        )

val chatRowObjectList = listOf(
    ChatRowObject(
        name = "Julian Desliva",
        lastMessage = "Hey, how are you doing?",
        time = "17:40",
        unreadMessageCount = 2,
        picId = R.drawable.p1
    ),
    ChatRowObject(
        name = "Emma Thompson",
        lastMessage = "Can't wait to see you!",
        time = "10:15",
        unreadMessageCount = 1,
        picId = R.drawable.p2
    ),
    ChatRowObject(
        name = "Michael Johnson",
        lastMessage = "Are you coming to the party?",
        time = "21:22",
        unreadMessageCount = 3,
        picId = R.drawable.p3
    ),
    ChatRowObject(
        name = "Sophia Roberts",
        lastMessage = "What's the plan for tonight?",
        time = "19:05",
        unreadMessageCount = 0,
        picId = R.drawable.p4
    ),
    ChatRowObject(
        name = "Ethan Davis",
        lastMessage = "I have some exciting news to share!",
        time = "14:30",
        unreadMessageCount = 5,
        picId = R.drawable.p5
    ),
    ChatRowObject(
        name = "Olivia Wilson",
        lastMessage = "Thanks for your help!",
        time = "11:55",
        unreadMessageCount = 0,
        picId = R.drawable.p6
    ),
    ChatRowObject(
        name = "Alexander Martin",
        lastMessage = "Do you want to grab lunch?",
        time = "13:20",
        unreadMessageCount = 0,
        picId = R.drawable.p7
    ),
    ChatRowObject(
        name = "Emily Anderson",
        lastMessage = "Let's meet at the usual spot.",
        time = "08:45",
        unreadMessageCount = 1,
        picId = R.drawable.p8
    ),
    ChatRowObject(
        name = "Daniel Clark",
        lastMessage = "I'm looking forward to the concert!",
        time = "16:18",
        unreadMessageCount = 0,
        picId = R.drawable.p9
    ),
    ChatRowObject(
        name = "Mia Adams",
        lastMessage = "How was your weekend?",
        time = "12:05",
        unreadMessageCount = 2,
        picId = R.drawable.p10
    )
)
