package br.com.alura.aluvery.sampledata

import br.com.alura.aluvery.R
import br.com.alura.aluvery.model.Product
import java.math.BigDecimal


val sampleProducts = listOf(
    Product(
        name = "Coca-cola",
        price = BigDecimal("7.99"),
        image = R.drawable.ic_launcher_background
    ),
    Product(
        name = "Sprite",
        price = BigDecimal("6.99"),
        image = R.drawable.ic_launcher_background
    ),
    Product(
        name = "Fanta",
        price = BigDecimal("6.99"),
        image = R.drawable.ic_launcher_background
    )
)