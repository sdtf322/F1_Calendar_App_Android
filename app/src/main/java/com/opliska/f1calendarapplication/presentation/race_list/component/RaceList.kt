package com.opliska.f1calendarapplication.presentation.race_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.opliska.f1calendarapplication.State
import com.opliska.f1calendarapplication.presentation.RaceUI
import com.opliska.f1calendarapplication.ui.theme.F1Theme

@Composable
internal fun RaceList(
    raceState: State.Success,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = "2024",
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(16.dp)
        )

        RaceList(races = raceState.races, modifier)
    }
}

@Preview
@Composable
internal fun RaceList(
    @PreviewParameter(RaceListPreviewProvider::class, limit = 1) races: List<RaceUI>,
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
    @PreviewParameter(RacePreviewProvider::class, limit = 1) race: RaceUI,
    modifier: Modifier = Modifier,
) {
    Row(modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
        //Later there will be a image source instead of Box
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(
                    color = Color(0xFFFFA500),
                    shape = RoundedCornerShape(4.dp)
                )
        )
        Column(modifier = Modifier.padding(start = 16.dp, top = 2.dp)) {
            Text(
                text = race.title ?: "",
                style = F1Theme.typography.title1,
                maxLines = 1
            )
            Spacer(modifier = Modifier.padding(top = 6.dp))
            Text(
                text = race.description ?: "",
                style = F1Theme.typography.customBody1,
                maxLines = 3
            )
        }
    }
}

private class RaceListPreviewProvider : PreviewParameterProvider<List<RaceUI>> {
    private val articleProvider = RacePreviewProvider()

    override val values =
        sequenceOf(
            articleProvider.values
                .toList()
        )
}

@Suppress("MagicNumber")
private class RacePreviewProvider : PreviewParameterProvider<RaceUI> {
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
