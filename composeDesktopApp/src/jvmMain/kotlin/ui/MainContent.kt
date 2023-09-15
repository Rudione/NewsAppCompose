package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Article
import utils.handCursor
import utils.loadPicture
import utils.openURL
import java.net.URI

@Composable
fun MainContent(headerTitle: String, articles: List<Article>) {

    when(articles.isNotEmpty()) {
        true -> {
            Column(
                modifier = Modifier.fillMaxSize().background(Color.White).padding(8.dp)
            ) {
                Text(text = headerTitle, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
                Spacer(Modifier.padding(4.dp))
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 300.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(articles) {
                        Card(
                            modifier = Modifier.width(400.dp).height(200.dp).padding(5.dp).pointerHoverIcon(handCursor())
                                .clickable {
                                    if (!it.url.isNullOrEmpty()) {
                                        openURL(URI(it.url))
                                    }
                                }
                        ) {
                            Box {
                                val bitmap = useResource("img.png") {
                                    loadImageBitmap(it)
                                }

                                if(it.urlToImage.isNullOrEmpty()) {
                                    Image(
                                        bitmap,
                                        "no image available",
                                        modifier = Modifier.size(100.dp).align(Alignment.TopCenter),
                                        contentScale = ContentScale.Crop
                                    )
                                } else {
                                    Image(
                                        loadPicture(it.urlToImage),
                                        "news thumbnail",
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        false -> {
            Column(
                modifier = Modifier.fillMaxSize().background(Color.White).padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Loading...")
            }
        }
        else -> {}
    }
}