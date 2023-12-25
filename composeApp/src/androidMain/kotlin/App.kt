import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            val scope = rememberCoroutineScope()
            val mars = remember { mutableStateListOf<MarsPhoto>() }
            LaunchedEffect(true) {
                scope.launch {
                    mars.addAll(Greeting().greeting())
                }
            }
            GreetingView(mars.map { it.toPhoto() })
        }
    }
}

@Composable
fun GreetingView(mars: List<PhotoMars>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(mars, key = {it.id}, contentType = {
            PhotoMars::class
        }){
            Text(it.imgSrc)
            AsyncImage(it.imgSrc, contentDescription = it.id)
        }
    }
}