package br.com.alura.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.sampledata.sampleProducts

class ProductDao {

    companion object {
        private val products = mutableStateListOf<Product>()
    }

    fun products() = products.toList()

    fun save(product: Product) {
        products.add(product)
    }

}