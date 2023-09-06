package com.expeknow.day8_chatapp.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.expeknow.day8_chatapp.R
import com.expeknow.day8_chatapp.ui.theme.primaryBlue
import com.expeknow.day8_chatapp.ui.theme.roboto

@Composable
fun SentChatWidget(text: String, picId: Int, time: String, isRead: Boolean,) {
    Row(
        Modifier
            .padding(10.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically) {
        Spacer(modifier = Modifier.width(50.dp))
        Column(horizontalAlignment = Alignment.End) {
            Card(shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = primaryBlue),
            modifier = Modifier.width(200.dp)
            ) {
                Text(text = text, color = Color.White, fontSize = 14.sp,
                modifier = Modifier.padding(12.dp), fontFamily = roboto
                )
            }
            Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                Text(text = time, fontSize = 12.sp, color = Color.LightGray)
                if(isRead){
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(painter = painterResource(id = R.drawable.eye), contentDescription = "read",
                        tint = primaryBlue, modifier = Modifier.size(14.dp))
                }
            }
        }
        Spacer(modifier = Modifier.width(3.dp))
        ProfileIcons(imageId = picId, size = 40, paddingAllSides = 5,)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSentChat() {
    SentChatWidget(text = "Hi this is a message I am sending to you for enquiry regarding your production",
        picId = R.drawable.p3, time = "Yesterday 11:45 PM", isRead = true)
}