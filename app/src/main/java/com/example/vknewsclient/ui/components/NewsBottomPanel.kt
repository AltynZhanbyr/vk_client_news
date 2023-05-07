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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vknewsclient.R
import com.example.vknewsclient.domain.StatisticType
import com.example.vknewsclient.domain.StatisticsItem

@Composable
fun NewsBottomPanel(
    statisticsList:List<StatisticsItem>,
    onItemClickListener:(StatisticsItem)->Unit
){
    Row(
        modifier = Modifier.fillMaxSize()
    ){
        Row(
            modifier = Modifier.weight(1f)
        ){
            val viewItem = getItemByType(statisticsList, StatisticType.VIEWS)
            ImageAndText(icon = painterResource(id = R.drawable.ic_views_count),viewItem.count) {
                onItemClickListener(viewItem)
            }
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            val shareItem = getItemByType(statisticsList, StatisticType.SHARE)
            ImageAndText(icon = painterResource(id = R.drawable.ic_share_count), shareItem.count) {
                onItemClickListener(shareItem)
            }
            val commentItem = getItemByType(statisticsList, StatisticType.COMMENTS)
            ImageAndText(icon = painterResource(id = R.drawable.ic_comment), commentItem.count) {
                onItemClickListener(commentItem)
            }
            val likeItem = getItemByType(statisticsList, StatisticType.LIKES)
            ImageAndText(icon = rememberVectorPainter(image = Icons.Default.Favorite), likeItem.count){
                onItemClickListener(likeItem)
            }
        }
    }
}

private fun getItemByType(statisticsList:List<StatisticsItem>, type:StatisticType):StatisticsItem{
    for (statisticsItem in statisticsList) {
        if(statisticsItem.type == type)
            return statisticsItem
    }
    throw NullPointerException("There is no element of statistics like this")
}

@Composable
fun ImageAndText(icon:Painter,count:Int, onIconClick:()->Unit){
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
        Text(count.toString())
    }
}
