package com.opliska.f1calendarapplication.presentation.race_list.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.opliska.f1calendarapplication.State
import com.opliska.f1calendarapplication.presentation.RaceUI
import com.opliska.f1calendarapplication.ui.theme.F1Theme

@Composable
internal fun RaceList(
    raceState: State.Success,
    modifier: Modifier = Modifier,
) {
    RaceList(races = raceState.races, modifier)
}

@Preview
@Composable
internal fun RaceList(
    @PreviewParameter(ArticlesPreviewProvider::class, limit = 1) races: List<RaceUI>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(races) { races ->
            key(races.id) {
                Race(races)
            }
        }
    }
}

@Preview
@Composable
internal fun Race(
    @PreviewParameter(ArticlePreviewProvider::class, limit = 1) race: RaceUI,
    modifier: Modifier = Modifier,
) {
    Row(modifier.padding(bottom = 4.dp)) {
        //Todo create UI according to Design (currently is setup for mock up / testing)
        Spacer(modifier = Modifier.size(4.dp))
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = race.title ?: "",
                style = F1Theme.typography.headlineMedium,
                maxLines = 1
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = race.description ?: "",
                style = F1Theme.typography.bodyMedium,
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
    override val values =
        sequenceOf(
            RaceUI(
                id = "1",
                "Title 1",
                "Description 1",
                imageUrl = null
            ),
            RaceUI(
                id = "2",
                "Title 2",
                "Description 2",
                imageUrl = null
            ),
            RaceUI(
                id = "3",
                "Title 3",
                "Description 3",
                imageUrl = null
            )
        )
}
