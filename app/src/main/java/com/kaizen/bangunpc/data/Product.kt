package com.kaizen.bangunpc.data

import com.kaizen.bangunpc.R

data class Product(
    val image: Int,
    val title: String,
    val price: String,
)

val dummyProducts = listOf(
    Product(R.drawable.component1, "PC RAKITAN GAMING | INTEL CORE i5 | RX 6600 | SSD 256GB", "Rp 11.641.000"),
    Product(R.drawable.component2, "PC Gaming Ryzen 5 3600/GTX1050Ti 4GB/RAM 8GB 2400Mhz/HDD 500GB/WIFI", "Rp 9.200.000"),
    Product(R.drawable.component3, "PC RAKITAN KANTOR Intel Core I3 | 16GB DDR3 | SSD 256GB - Memory 8GB", "Rp 3.120.000"),
)