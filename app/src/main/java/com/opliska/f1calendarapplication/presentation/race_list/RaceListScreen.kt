package com.opliska.f1calendarapplication.presentation.race_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.opliska.f1calendarapplication.State
import com.opliska.f1calendarapplication.presentation.race_list.component.RaceList
import com.opliska.f1calendarapplication.ui.theme.F1Theme

@Composable
fun RaceListScreen(modifier: Modifier = Modifier) {
    RaceListScreen(viewModel = viewModel(), modifier = modifier)
}

@Composable
internal fun RaceListScreen(
    viewModel: RaceListViewModel,
    modifier: Modifier = Modifier,
) {
    val state by viewModel.state.collectAsState()
    val currentState = state
    RaceListContent(currentState, modifier)
}

@Composable
private fun RaceListContent(
    currentState: State,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        when (currentState) {
            is State.None -> Unit
            is State.Error -> ErrorMessage(currentState)
            is State.Loading -> ProgressIndicator(currentState)
            is State.Success -> RaceList(currentState)
        }
    }
}

@Composable
private fun ErrorMessage(
    state: State.Error,
    modifier: Modifier = Modifier,
) {
    Column {
        Box(
            modifier
                .fillMaxWidth()
                .background(F1Theme.colorScheme.error)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Error during update", color = F1Theme.colorScheme.onError)
        }

        val races = state.races
        if (races != null) {
            RaceList(races = races, modifier = modifier)
        }
    }
}

@Composable
private fun ProgressIndicator(
    state: State.Loading,
    modifier: Modifier = Modifier,
) {
    Column {
        Box(
            modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        val races = state.races
        if (races != null) {
            RaceList(races = races, modifier = modifier)
        }
    }
}