package com.example.vknewsclient.ui.components

import android.widget.AdapterView.OnItemClickListener
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.vknewsclient.domain.PostItem
import com.example.vknewsclient.domain.StatisticsItem

@Composable
fun NewsComponent(modifier: Modifier,postItem: PostItem, onStatisticsItemClickListener: (StatisticsItem)->Unit){
    Card(
        modifier = modifier
            .padding(top = 4.dp, start = 4.dp, end = 4.dp),
        elevation = 2.dp,
        shape = RoundedCornerShape(2.dp)
    ){
        Column(
            Modifier.padding(2.dp)
        ) {
            NewsHeader(postItem.avatarResId, postItem.communityName, timeText = postItem.publicationDate)
            Column(
                modifier = Modifier.padding(start = 6.dp, end = 6.dp, bottom = 8.dp)
            ) {
                Text(postItem.contextText)

//                Spacer(modifier = Modifier.height(6.dp))
//
                Image(
                    bitmap = ImageBitmap.imageResource(postItem.contentImageId),
                    modifier = Modifier.size(420.dp,250.dp),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(3.dp))
                NewsBottomPanel(postItem.statistics){
                    onStatisticsItemClickListener(it)
                }
            }
        }
    }
}