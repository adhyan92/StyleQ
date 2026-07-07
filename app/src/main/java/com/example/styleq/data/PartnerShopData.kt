package com.example.styleq.data

data class PartnerShopData(
    val logoRes: Int,
    val name: String,
    val sizes: String = "Ready Size S, M, L, XL",
    val address: String,
    val shopeeUrl: String = "https://shopee.co.id/product/1234567890",
    val tokopediaUrl: String = "https://www.tokopedia.com/nama-toko/nama-produk-123456789",
    val price: String,
    val rating: String
)