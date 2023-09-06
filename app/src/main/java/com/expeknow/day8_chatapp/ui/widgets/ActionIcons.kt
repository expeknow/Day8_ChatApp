package com.expeknow.day8_chatapp.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.expeknow.day8_chatapp.R
import com.expeknow.day8_chatapp.ui.theme.iconCardColor


@Composable
fun ActionIcons(iconId: Int, size : Int, paddingAllSide: Int, elevation : Int = 10) {
    Card(shape = RoundedCornerShape(20.dp), modifier = Modifier
        .size(size.dp)
        .padding(paddingAllSide.dp), elevation = CardDefaults.cardElevation(elevation.dp),
        colors = CardDefaults.cardColors( containerColor = iconCardColor)) {
        Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Icon(painter = painterResource(id = iconId), contentDescription = "",
                tint = Color.White)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWidget() {
    ActionIcons(iconId = R.drawable.search, size = 20, 5)
}