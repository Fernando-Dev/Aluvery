package br.com.alura.aluvery.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.ui.theme.AluveryTheme


@Preview(showSystemUi = true)
@Composable
fun ColumnPreview() {
    Column {
        Text(text = "texto 1")
        Text(text = "texto 2")
    }
}


@Preview(showSystemUi = true)
@Composable
fun RowPreview() {
    Row {
        Text(text = "texto 1")
        Text(text = "texto 2")
    }
}


@Preview(showSystemUi = true)
@Composable
fun BoxPreview() {
    Box {
        Text(text = "texto 1")
        Text(text = "texto 2")
    }
}


@Preview(showBackground = true)
@Composable
fun CustomPreview() {
    Column(
        Modifier
            .padding(8.dp)
            .background(color = Color.Blue)
            .padding(all = 8.dp)
    ) {// elementos no vertical
        Text(text = "texto 1")
        Text(text = "texto 2")
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 8.dp,
                    vertical = 16.dp
                )
                .background(
                    color = Color.Green
                )
        ) {// elemento na horizontal
            Text(text = "texto 3")
            Text(text = "texto 4")
        }
        Box(
            Modifier
                .padding(8.dp)
                .background(color = Color.Red)
                .padding(all = 8.dp)
        ) {// elementos sobreposto ao outro
            Row(
                Modifier
                    .padding(8.dp)
                    .background(color = Color.Cyan)
                    .padding(all = 8.dp)
            ) {
                Text(text = "texto 5")
                Text(text = "texto 6")
            }
            Column(
                Modifier
                    .padding(8.dp)
                    .background(color = Color.Yellow)
                    .padding(all = 8.dp)
            ) {
                Text(text = "texto 7")
                Text(text = "texto 8")
            }
        }
    }
}

@Composable
fun MyFirstComposable() {
    Text(text = "meu primeiro texto")
    Text(text = "meu segundo texto maior")
}

@Preview(
    showSystemUi = true, //exibir layout device
    uiMode = Configuration.UI_MODE_NIGHT_YES // modo escuro
)
@Preview(
    name = "Preview Light", //colocar o nome do preview
    showSystemUi = true
)
@Composable
fun MyFirstComposablePreview() {
    AluveryTheme {
        Surface {
            MyFirstComposable()
        }
    }
}