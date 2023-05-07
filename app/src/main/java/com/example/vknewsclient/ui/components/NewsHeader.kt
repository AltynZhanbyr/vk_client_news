package com.example.vknewsclient.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vknewsclient.R
import com.example.vknewsclient.ui.theme.VkNewsClientTheme

@Composable
fun NewsHeader(
    headerImageRes:Int,
    headerText:String,
    timeText:String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Image",
            modifier = Modifier
                .clip(CircleShape)
                .size(65.dp)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 15.dp)
        ){
            Text(headerText, maxLines = 1)
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                timeText,
                color = MaterialTheme.colors.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "",
            tint = MaterialTheme.colors.onSecondary,
            modifier = Modifier.padding(end = 5.dp).clickable {

            }
        )
    }
}