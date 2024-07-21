import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.opliska.shared.core.presentation.theme.F1Theme
import com.opliska.shared.main.MainScreen
import com.opliska.shared.main.MainViewModel
import com.opliska.shared.platform.StatusBarColors
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
fun F1App(
    mainViewModel: MainViewModel = koinInject()
) {
    val darkTheme = when (mainViewModel.appTheme.collectAsState().value) {
        1 -> true
        else -> false
    }
    KoinContext {
        F1Theme(
            useDarkTheme = darkTheme,
        ) {
            StatusBarColors(
                statusBarColor = MaterialTheme.colorScheme.background,
                navBarColor = MaterialTheme.colorScheme.background,
            )
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Navigator(
                    screen = MainScreen(),
                    content = {
                        CurrentScreen()
                    },
                )
            }
        }
    }
}