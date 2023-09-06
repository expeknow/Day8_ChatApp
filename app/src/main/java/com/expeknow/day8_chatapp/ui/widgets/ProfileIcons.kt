package com.expeknow.day8_chatapp.ui.widgets

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.expeknow.day8_chatapp.R
import com.expeknow.day8_chatapp.ui.theme.iconCardColor
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun ProfileIcons(imageId: Int, size: Int, paddingAllSides: Int,
                 navController: NavHostController = rememberNavController()
) {
    Card(shape = RoundedCornerShape(20.dp), modifier = Modifier
        .size(size.dp)
        .padding(paddingAllSides.dp),
        onClick = {navController.navigate("chat")},
        colors = CardDefaults.cardColors( containerColor = iconCardColor),
        elevation = CardDefaults.cardElevation(10.dp)) {
        Image(painter = painterResource(id = imageId), contentDescription = "",
        contentScale = ContentScale.Crop)
    }
}

//
//@Preview
//@Composable
//fun PreviewProfileIcons() {
//    ProfileIcons(R.drawable.p2, 30, 5, rem)
//}