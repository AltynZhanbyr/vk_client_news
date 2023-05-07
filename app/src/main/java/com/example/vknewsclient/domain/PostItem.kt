package com.example.vknewsclient.domain

import com.example.vknewsclient.R

data class PostItem(
    val communityName:String = "Qumash",
    val publicationDate:String = "21:05",
    val avatarResId:Int = R.drawable.ic_launcher_foreground,
    val contextText:String = "Tigr go bizdyn prezident mashina at crush",
    val contentImageId:Int = R.drawable.tkv,
    val statistics:List<StatisticsItem> = listOf<StatisticsItem>(
        StatisticsItem(StatisticType.VIEWS,681),
        StatisticsItem(StatisticType.SHARE,9),
        StatisticsItem(StatisticType.COMMENTS,11),
        StatisticsItem(StatisticType.LIKES,25)
    )
)