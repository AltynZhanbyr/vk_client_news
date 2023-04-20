package com.example.vknewsclient.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MyScaffold(){
    val scope = rememberCoroutineScope()
    val state = rememberScaffoldState()
    val isVisible= remember {
        mutableStateOf(true)
    }
    val snackbarHostState = remember{
        SnackbarHostState()
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        floatingActionButton ={
            if(isVisible.value){
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            val action = snackbarHostState.showSnackbar(
                                message = "Hello brother from another mother",
                                actionLabel = "Hide",
                                duration = SnackbarDuration.Long
                            )

                            if(action == SnackbarResult.ActionPerformed){
                                isVisible.value = false
                            }
                        }
                    },
                    contentColor = MaterialTheme.colors.onBackground,
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "")
                }
            }
        },
        scaffoldState = state,
        topBar = {
            MyAppTopBar(state,scope)
        },
        bottomBar = {
            MyBottomNavigation()
        },
        drawerContent = {
            Column {
                Row(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(imageVector = Icons.Default.Menu , contentDescription = "")
                    Spacer(modifier = Modifier
                        .width(10.dp)
                        .clickable {
                            scope.launch {
                                state.drawerState.close()
                            }
                        })
                    Image(imageVector = Icons.Default.AccountCircle, modifier = Modifier
                        .clip(
                            CircleShape
                        )
                        .size(40.dp), contentDescription = "")
                    Spacer(modifier = Modifier.width(15.dp))
                    Text("Drawer", fontSize = 18.sp)
                }
                Divider(modifier = Modifier
                    .height(2.dp)
                    .background(Color.Black))
            }
        }
    ){
        Column(
            modifier = Modifier.padding(it)
        ){
            Text("Hello world")
        }
    }
}

@Composable
fun MyAppTopBar(scaffoldState: ScaffoldState, scope: CoroutineScope){
    Card{
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.background)
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Spacer(
                modifier = Modifier.width(7.dp)
            )
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "",
                tint = MaterialTheme.colors.onBackground,
                modifier = Modifier.clickable{
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
            Spacer(
                modifier = Modifier.width(15.dp)
            )
            Text(
                "Top App Bar",
                color = MaterialTheme.colors.onBackground,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun MyBottomNavigation(){
    var selectedItem = remember{
        mutableStateOf(0)
    }
    var items = listOf(NavigationItems.Home, NavigationItems.Favorite, NavigationItems.Profile)
    BottomNavigation(
        modifier = Modifier.background(MaterialTheme.colors.background)
    ) {
        items.forEachIndexed{index, item->
            BottomNavigationItem(
                selected = index==selectedItem.value,
                onClick = { selectedItem.value=index },
                icon = {Icon(item.icon, "")},
                label = {Text(item.title)}
            )
        }

    }
}