package com.example.newsappcompose.presentation.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.newsappcompose.R
import com.example.newsappcompose.domain.model.Article
import com.example.newsappcompose.presentation.common.SearchBar
import com.example.newsappcompose.presentation.navgraph.Route
import com.example.newsappcompose.presentation.screens.home.components.ArticlesList
import com.example.newsappcompose.presentation.utils.Dimens.MediumPadding1
import com.example.newsappcompose.presentation.utils.Dimens.SmallPadding
import java.io.File.separator

/**
 * @property [HomeScreen] composable for showing home screen.
 *
 * @param articles
 * @param navigateToSearch
 * @param navigateToDetails
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Article) -> Unit,
) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logoanim))

        Row() {

            LottieAnimation(
                modifier = Modifier
                    .width(120.dp)
                    .height(60.dp)
                    .padding(horizontal = MediumPadding1),
                composition = composition,
                iterations = LottieConstants.IterateForever,
            )

            Spacer(modifier = Modifier.height(SmallPadding))

            SearchBar(
                modifier = Modifier
                    .padding(horizontal = MediumPadding1),
                text = "",
                readOnly = true,
                onValueChange = {},
                onClick = {
                    navigateToSearch()
                },
                onSearch = {}
            )

        }

        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = MediumPadding1)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        ArticlesList(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MediumPadding1),
            articles = articles,
            onItemClick = {
                navigateToDetails(it)
            }
        )
    }
}