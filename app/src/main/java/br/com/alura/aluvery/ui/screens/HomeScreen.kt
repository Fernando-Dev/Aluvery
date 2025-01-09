package br.com.alura.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.sampledata.sampleCandies
import br.com.alura.aluvery.sampledata.sampleDrinks
import br.com.alura.aluvery.sampledata.sampleProducts
import br.com.alura.aluvery.sampledata.sampleSections
import br.com.alura.aluvery.ui.components.CardProductItem
import br.com.alura.aluvery.ui.components.ProductSection
import br.com.alura.aluvery.ui.components.SearchTextField
import br.com.alura.aluvery.ui.theme.AluveryTheme


//gerenciador de estado do composable homescreen
class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {}
) {

    //nessa parte verificamos com o remember se a variavel text
    // tem modificacao, e no caso positivo devemos executar o filtro
    // na lista caso ela não seja nula

    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }




}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {
    Column {
        val sections = state.sections
        var text = state.searchText
        val searchProducts = state.searchedProducts

        //composable
        SearchTextField(
            searchText = text,
            onSearchChange = state.onSearchChange
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (state.isShowSections()) {
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
            } else {
                items(searchProducts) { p ->
                    CardProductItem(
                        product = p,
                        Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(products: List<Product>) {
    //quem chama o composable
    //fica responsavel em mandar o estado
    val sections = mapOf(
        "Todos produtos" to products,
        "Promoções" to sampleDrinks + sampleDrinks,
        "Doces" to sampleCandies,
        "Bebidas" to sampleDrinks
    )

    var text by remember {
        mutableStateOf("")
    }

    fun contaisnInNameOrDescription() = { product: Product ->
        product.name.contains(text, ignoreCase = true) ||
                product.description?.contains(
                    text, ignoreCase = true
                ) ?: false
    }

    val searchedProducts = remember(text, products) {
        if (text.isNotBlank()) {
            sampleProducts.filter(contaisnInNameOrDescription())+
                    products.filter(contaisnInNameOrDescription())
        } else {
            emptyList()
        }
    }

    val state = remember (products, text) { HomeScreenUiState(
        searchedProducts = searchedProducts,
        sections = sections,
        searchText = text,
        onSearchChange = { newText ->
            text = newText
        }
    ) }

    HomeScreen(state = state)
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(
                HomeScreenUiState(
                    sampleSections
                )
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenWithSearchTextPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(
                state = HomeScreenUiState(
                    sections = sampleSections,
                    searchText = "pizza"
                )
            )
        }
    }
}