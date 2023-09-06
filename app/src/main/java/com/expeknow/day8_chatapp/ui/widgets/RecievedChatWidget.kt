package com.expeknow.day8_chatapp.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.expeknow.day8_chatapp.R
import com.expeknow.day8_chatapp.ui.theme.grayBackground
import com.expeknow.day8_chatapp.ui.theme.roboto

@Composable
fun RecievedChatWidget(text: String, picId: Int, time: String, isRead: Boolean) {
    Row(
        Modifier
            .padding(10.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically) {
        ProfileIcons(imageId = picId, size = 40, paddingAllSides = 5,
            )
        Spacer(modifier = Modifier.width(3.dp))
        Column(horizontalAlignment = Alignment.Start) {
            Card(shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = grayBackground),
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = text, color = Color.Black, fontSize = 14.sp,
                    modifier = Modifier.padding(12.dp), fontFamily = roboto)
            }
            Row(horizontalArrangement = Arrangement.End) {
                Text(text = time, fontSize = 12.sp, color = Color.LightGray)
            }
        }
        Spacer(modifier = Modifier.width(50.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun RecievedChatWidget() {
    RecievedChatWidget(text = "Hi this is a message I am sending to you for enquiry regarding your production",
        picId = R.drawable.p3, time = "Yesterday 11:45 PM", isRead = true)
}