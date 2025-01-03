package br.com.alura.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.sampledata.sampleSections
import br.com.alura.aluvery.ui.components.ProductSection
import br.com.alura.aluvery.ui.theme.AluveryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    Column {
        //states
        var text by remember {mutableStateOf("")}

        //composable
        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            Modifier.padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp
            ).fillMaxWidth(),
            shape = RoundedCornerShape(100),
            leadingIcon = {
                Box() {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "icone de lupa"
                    )
                }
            },
            label = {
                Text(
                    text = "Produto"
                )
            },
            placeholder = {
                Text(text= "O que você procura?")
            }
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            sections.forEach { section ->
                val title = section.key
                val products = section.value
                item {
                    ProductSection(
                        title,
                        products
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(
                sampleSections
            )
        }
    }
}