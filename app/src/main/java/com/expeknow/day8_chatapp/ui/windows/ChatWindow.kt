package com.expeknow.day8_chatapp.ui.windows

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.expeknow.day8_chatapp.R
import com.expeknow.day8_chatapp.ui.theme.grayBackground
import com.expeknow.day8_chatapp.ui.theme.primaryBlue
import com.expeknow.day8_chatapp.ui.utils.sampleMessages
import com.expeknow.day8_chatapp.ui.widgets.ActionIcons
import com.expeknow.day8_chatapp.ui.widgets.ProfileIcons
import com.expeknow.day8_chatapp.ui.widgets.RecievedChatWidget
import com.expeknow.day8_chatapp.ui.widgets.SentChatWidget
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatWindow(navController: NavHostController) {

    val scrollState = rememberScrollState()
    Scaffold {
        Column(Modifier.padding(it)) {
            TopChatDetailBar(navController)
            Column(
                Modifier
                    .weight(1f).padding(top = 20.dp)
                    .verticalScroll(scrollState, reverseScrolling = true)) {
                Card(modifier = Modifier.fillMaxSize(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(0.dp)
                ) {
                    val chatData = sampleMessages
                    repeat(chatData.size){
                        val chatItem = chatData[it]
                        if (chatItem.isSent) {
                            SentChatWidget(text = chatItem.message,
                                picId = chatItem.receiversPicId, time = chatItem.time, isRead = chatItem.isRead)
                        }
                        else
                            RecievedChatWidget(text = chatItem.message,
                            picId = chatItem.receiversPicId, time = chatItem.time, isRead = chatItem.isRead)
                    }
                }
            }
            TextInputField()
        }
    }
}



@Composable
fun TextInputField() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(20.dp)) {
        Card(shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors( containerColor = grayBackground)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier.padding(vertical = 10.dp)) {
                    Icon(painter = painterResource(id = R.drawable.camera),
                        contentDescription = "", tint = primaryBlue,
                        modifier = Modifier.size(24.dp))
                }
                Text(text = "Type Your Message", fontSize = 14.sp, color = Color.Gray,
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 20.dp))
                SendButton(R.drawable.send, 60, 6)
            }
        }
    }
}

@Composable
fun SendButton(iconId: Int, size: Int, paddingAllSide: Int) {
    Card(shape = RoundedCornerShape(20.dp), modifier = Modifier
        .size(size.dp)
        .padding(paddingAllSide.dp),
        colors = CardDefaults.cardColors( containerColor = primaryBlue)) {
        Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Icon(painter = painterResource(id = iconId), contentDescription = "",
                tint = Color.White)
        }

    }
}

@Composable
fun TopChatDetailBar(navController: NavHostController) {
    Card(shape = RoundedCornerShape(0.dp, 0.dp, 40.dp, 40.dp),
    colors = CardDefaults.cardColors(containerColor = primaryBlue),
    elevation = CardDefaults.cardElevation(10.dp)) {
        
        Row(Modifier.padding(horizontal = 10.dp, vertical = 20.dp)) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(painter = painterResource(id = R.drawable.arrow_back), contentDescription = "",
                tint = Color.White)
            }
            ProfileIcons(
                imageId = R.drawable.p2,
                size = 50,
                paddingAllSides = 5,
                navController = navController
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Molly Clark", fontSize = 16.sp, fontWeight = FontWeight.SemiBold,
                color = Color.White)
                Spacer(modifier = Modifier.height(1.dp))
                Text(text = "Online", fontSize = 12.sp, color = Color.LightGray, )
            }

            ActionIcons(iconId = R.drawable.call, size = 45, paddingAllSide = 5, elevation = 0)
            ActionIcons(iconId = R.drawable.video, size = 45 , paddingAllSide = 5, elevation = 0)
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun PreviewChatWindow() {
    ChatWindow(rememberAnimatedNavController())
}