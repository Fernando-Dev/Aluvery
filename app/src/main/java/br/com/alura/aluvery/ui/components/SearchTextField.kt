package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    searchText: String,
    modifier: Modifier = Modifier,
    onSearchChange: (String) -> Unit
) {

    //composable
    OutlinedTextField(
        value = searchText,
        onValueChange = { newText ->
            //aqui interceptamos o state da variavel text
            //ou seja recuperamos o novo valor
            // digitado para executar a atualizacao
            // do texto
            onSearchChange(newText)
        },
        Modifier
            .padding(
                16.dp
            )
            .fillMaxWidth(),
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
            Text(text = "O que você procura?")
        }
    )
}