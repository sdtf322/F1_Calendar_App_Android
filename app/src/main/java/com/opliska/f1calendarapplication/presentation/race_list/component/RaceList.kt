package com.opliska.f1calendarapplication.presentation.race_list.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.opliska.f1calendarapplication.R
import com.opliska.f1calendarapplication.presentation.RaceUI

@Composable
internal fun RaceList(
    articleState: State.Success,
    modifier: Modifier = Modifier,
) {
    RaceList(races = articleState.articles, modifier)
}

@Preview
@Composable
internal fun RaceList(
    @PreviewParameter(ArticlesPreviewProvider::class, limit = 1) races: List<RaceUI>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(races) { article ->
            key(article.id) {
                Article(article)
            }
        }
    }
}

@Preview
@Composable
internal fun Article(
    @PreviewParameter(ArticlePreviewProvider::class, limit = 1) race: RaceUI,
    modifier: Modifier = Modifier,
) {
    Row(modifier.padding(bottom = 4.dp)) {
        race.imageUrl?.let { imageUrl ->
            var isImageVisible by remember { mutableStateOf(true) }
            if (isImageVisible) {
                AsyncImage(
                    model = imageUrl,
                    onState = { state ->
                        if (state is AsyncImagePainter.State.Error) {
                            isImageVisible = false
                        }
                    },
                    contentDescription = stringResource(R.string.content_desc_item_article_image),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(150.dp)
                )
            }
        }
        Spacer(modifier = Modifier.size(4.dp))
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = race.title,
                style = F1CalendarApplicationTheme.typography.headlineMedium,
                maxLines = 1
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = race.description,
                style = NewsTheme.typography.bodyMedium,
                maxLines = 3
            )
        }
    }
}

private class ArticlesPreviewProvider : PreviewParameterProvider<List<RaceUI>> {
    private val articleProvider = ArticlePreviewProvider()

    override val values =
        sequenceOf(
            articleProvider.values
                .toList()
        )
}

@Suppress("MagicNumber")
private class ArticlePreviewProvider : PreviewParameterProvider<RaceUI> {
    override val values = emptyList()
//    override val values =
//        sequenceOf(
//            ArticleUI(
//                1,
//                "Android Studio Iguana is Stable!",
//                "New stable version on Android IDE has been release",
//                imageUrl = null,
//                url = ""
//            ),
//            ArticleUI(
//                2,
//                "Gemini 1.5 Release",
//                "Upgraded version of Google AI is available",
//                imageUrl = null,
//                url = ""
//            ),
//            ArticleUI(
//                3,
//                "Shape animations (10 min)",
//                "How to use shape transform animations in Compose",
//                imageUrl = null,
//                url = ""
//            )
//        )
}