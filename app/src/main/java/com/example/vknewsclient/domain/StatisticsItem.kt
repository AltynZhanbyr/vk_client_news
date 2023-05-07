package com.example.vknewsclient.domain

data class StatisticsItem(
    val type: StatisticType,
    var count:Int = 0
)

enum class StatisticType{
    VIEWS,SHARE,COMMENTS,LIKES
}
