package com.anbui.marsphoto.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import model.MarsPhoto
import viewmodel.MarsViewModel

@Composable
fun MarsScreen() {
    val viewModel by remember {
        mutableStateOf(MarsViewModel())
    }
    
    val marsPhotos by viewModel.marsPhotos.collectAsState()
    
    Mars(marsPhotos)
    
}

@Composable
fun Mars(
    mars: List<MarsPhoto>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(mars, key = {it.id}){
            Text(it.imgSrc)
            AsyncImage(it.imgSrc, contentDescription = it.id)
        }
    }
}