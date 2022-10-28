package com.seda.basic_android_kotlin_compose_lazygrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seda.basic_android_kotlin_compose_lazygrid.data.DataSource
import com.seda.basic_android_kotlin_compose_lazygrid.model.Topic
import com.seda.basic_android_kotlin_compose_lazygrid.ui.theme.BasicandroidkotlincomposeLazyGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicandroidkotlincomposeLazyGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopicGrid()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicGrid(modifier: Modifier=Modifier) {
   LazyVerticalGrid(cells = GridCells.Adaptive(128.dp),  verticalArrangement = Arrangement.spacedBy(8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = modifier.padding(8.dp) ){
       items(DataSource.topics){topic ->
TopicCard(topic = topic)
       }
   }
}
@Composable
fun TopicCard(topic: Topic,modifier: Modifier=Modifier){
    Card() {
        Row(modifier =Modifier.wrapContentHeight().height(98.dp)) {
            Box(modifier =Modifier.wrapContentHeight().height(98.dp) ) {
                Image(painter = painterResource(id = topic.imageRes), contentDescription = stringResource(
                    id = topic.name
                ), modifier = modifier
                    .size(width = 98.dp, height = 98.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop)
            }
            Column() {
                Text(
                    text = stringResource(id = topic.name),
                     style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    ))
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.ic_grain), contentDescription ="",
                    modifier= Modifier
                        .padding(start = 16.dp)
                        .size(22.dp))
                    Text(text = topic.availableCourses.toString(),modifier=modifier.padding(start = 8.dp))
                }
            }


        }

    }
    
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BasicandroidkotlincomposeLazyGridTheme {
        TopicGrid()
    }
}