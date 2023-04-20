package com.example.vknewsclient.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vknewsclient.R

@Composable
fun NewsBottomPanel(
    viewCount:Int,
    likeCount:Int,
    shareCount:Int,
    commentCount:Int
){
    Row(
        modifier = Modifier.fillMaxSize()
    ){
        Row(
            modifier = Modifier.weight(1f)
        ){
            ImageAndText(icon = painterResource(id = R.drawable.ic_views_count), text = viewCount.toString(),{})
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            ImageAndText(icon = painterResource(id = R.drawable.ic_share_count), text = shareCount.toString(),{})
            ImageAndText(icon = painterResource(id = R.drawable.ic_comment), text = commentCount.toString(),{})
            ImageAndText(icon = rememberVectorPainter(image = Icons.Default.Favorite), text = likeCount.toString(),{})
        }
    }
}

@Composable
fun ImageAndText(icon:Painter,text:String, onIconClick:()->Unit){
    Row(
        modifier = Modifier.clickable {
            onIconClick()
        }
    ) {
        Icon(
            painter = icon,
            contentDescription = "",
            tint = MaterialTheme.colors.onSecondary
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text)
    }
}

@Preview
@Composable
fun BottomPanelPrev(){
    NewsBottomPanel(viewCount = 681, likeCount = 25, shareCount = 9, commentCount = 11)
}