package com.expeknow.day8_chatapp.ui.windows

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.expeknow.day8_chatapp.R
import com.expeknow.day8_chatapp.ui.theme.primaryBlue
import com.expeknow.day8_chatapp.ui.theme.roboto
import com.expeknow.day8_chatapp.ui.theme.unreadTextColor
import com.expeknow.day8_chatapp.ui.utils.ChatRowObject
import com.expeknow.day8_chatapp.ui.utils.chatRowObjectList
import com.expeknow.day8_chatapp.ui.widgets.ActionIcons
import com.expeknow.day8_chatapp.ui.widgets.ProfileIcons
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainWindow(navController: NavHostController) {
    Scaffold(
        topBar = {TopBar()},
    ) {
        Column(Modifier.padding(it)) {
            Card(shape = RoundedCornerShape(0.dp, 0.dp, 40.dp, 40.dp),
                colors = CardDefaults.cardColors(containerColor = primaryBlue),
                elevation = CardDefaults.cardElevation(
                    30.dp
                )) {
                ChatIconsRow(navController)
            }

            Column(
                Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())) {
                Spacer(modifier = Modifier.height(20.dp))
                repeat(10) {
                    val rowData = chatRowObjectList[it]
                    ChatRows(navController, rowData)
                }
            }
        }
    }
}

@Composable
fun ChatRows(navController: NavHostController, data: ChatRowObject) {
    val interactionSource  = MutableInteractionSource()
    Row(Modifier.padding(horizontal = 20.dp, vertical = 12.dp)) {
        ProfileIcons(
            imageId = data.picId,
            size = 50,
            paddingAllSides = 0,
            navController = navController
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
                .clickable(interactionSource, null)
                { navController.navigate("chat") }) {
            Text(text = data.name,
                fontSize = 16.sp,
                color = unreadTextColor,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = data.lastMessage,
                fontSize = 13.sp,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = data.time,
                fontSize = 12.sp,
                color = Color.LightGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)

            Spacer(modifier = Modifier.height(10.dp))

            if(data.unreadMessageCount != 0)
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .size(20.dp)) {
                Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
                    drawCircle(color = primaryBlue)
                })
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically) {
                    Text(text = data.unreadMessageCount.toString(), color = Color.White, fontSize = 12.sp)
                }

            }
        }
    }
}

@Composable
fun ChatIconsRow(navController: NavHostController) {

    val profileImages = listOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5,
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5,
    )

    LazyRow(
        Modifier
            .padding(vertical = 24.dp, horizontal = 10.dp)
            .fillMaxWidth()) {
        item {
            ActionIcons(iconId = R.drawable.search, size = 65, 10)
        }

        items (profileImages.size) {
            val imageId = profileImages[it]
            ProfileIcons(imageId = imageId, size = 65, 8, navController)
        }
    }
}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "messages".uppercase(), fontSize = 16.sp, fontWeight = FontWeight.Light,
            color = Color.White, modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center, letterSpacing = 2.sp)},
//        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
        navigationIcon = { Icon(painter = painterResource(id = R.drawable.menu),
            contentDescription = "menu", tint = Color.White, modifier = Modifier
                .size(70.dp)
                .padding(horizontal = 20.dp)
            )},
        actions = {
            Card(shape = RoundedCornerShape(15.dp), modifier = Modifier
                .width(80.dp)
                .height(40.dp)
                .padding(horizontal = 20.dp)
            ){
                Image(painter = painterResource(id = R.drawable.profile),
                    contentDescription = "", contentScale = ContentScale.Crop,
                   )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = primaryBlue
        )
    )
}


@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun Preview() {
    MainWindow(rememberAnimatedNavController())
}