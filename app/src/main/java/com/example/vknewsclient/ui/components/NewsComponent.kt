package com.example.vknewsclient.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.vknewsclient.R

@Composable
fun NewsComponent(){
    Card(){
        Column() {
            NewsHeader(headerImageRes = 0, headerText = "Qumash", timeText = "20:58")
            Column(
                modifier = Modifier.padding(start = 6.dp, end = 6.dp, bottom = 8.dp)
            ) {
                Text(stringResource(id = R.string.header_text))

//                Spacer(modifier = Modifier.height(6.dp))
//
                Image(
                    bitmap = ImageBitmap.imageResource(id = R.drawable.tkv),
                    modifier = Modifier.size(420.dp,500.dp),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                NewsBottomPanel(viewCount = 681, likeCount = 25, shareCount = 9, commentCount = 11)
            }
        }
    }
}