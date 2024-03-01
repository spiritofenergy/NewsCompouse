package com.kodex.news.presentation.navigation

sealed class Route(
    val route: String
){
    object  OnBoardingScreen : Route("onBoardingScreen")
    object  HomeScreen : Route("homeScreen")
    object  SearchScreen: Route("searchScreen")
    object  BookmarkScreen: Route("bookmarkScreen")
    object  DetailScreen: Route("detailScreen")
    object  AppStartNavigation: Route("appStartNavigation")
    object  NewsNavigation: Route("newsNavigation")
    object  NewsNavigationScreen: Route("newsNavigator")

}
