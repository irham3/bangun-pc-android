package com.kaizen.bangunpc.utils

import java.text.NumberFormat
import java.util.Locale

fun Int.toRupiahFormat(): String {
    val localeID = Locale("in", "ID")
    val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
    return formatRupiah.format(this.toDouble().toInt())
}