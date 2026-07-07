package com.example.styleq.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density

/**
 * Semua layar di app ini didesain dengan ukuran dp tetap (padding, size, height)
 * yang dihitung berdasarkan SATU ukuran layar acuan (kira-kira ukuran emulator
 * default Pixel: 411dp x 891dp). Karena dp tetap tidak otomatis menyesuaikan
 * proporsi layar yang berbeda, tampilan jadi terlihat berbeda antara emulator
 * dan HP asli (elemen kepotong, posisi geser, gambar kebesaran/kekecilan, dll).
 *
 * ResponsiveScale membungkus seluruh konten app dan menghitung faktor skala
 * berdasarkan perbandingan ukuran layar aktual device terhadap ukuran acuan,
 * lalu menerapkannya ke LocalDensity. Dengan begitu, SEMUA nilai .dp dan .sp
 * yang sudah ada di kode (di semua 16 layar) otomatis ikut menyesuaikan
 * secara proporsional tanpa perlu mengubah satu per satu, sehingga tata letak
 * dan ukuran konsisten di emulator maupun device asli, di layar kecil maupun
 * besar.
 */

// Ukuran acuan (dp) tempat desain awal dibuat. Sesuaikan jika layar referensi
// desain berbeda (mis. Figma frame), tapi nilai ini cocok untuk emulator
// Pixel-class yang umum dipakai saat pengembangan.
private const val REFERENCE_WIDTH_DP = 411f
private const val REFERENCE_HEIGHT_DP = 891f

// Batas aman agar skala tidak terlalu ekstrem di tablet / layar sangat kecil.
private const val MIN_SCALE = 0.80f
private const val MAX_SCALE = 1.20f

@Composable
fun ResponsiveScale(content: @Composable () -> Unit) {
    val configuration = LocalConfiguration.current
    val baseDensity = LocalDensity.current

    val widthScale = configuration.screenWidthDp.toFloat() / REFERENCE_WIDTH_DP
    val heightScale = configuration.screenHeightDp.toFloat() / REFERENCE_HEIGHT_DP

    // Pakai skala terkecil (width vs height) supaya layout tidak overflow ke
    // arah manapun, baik di layar pendek/lebar atau panjang/sempit.
    val rawScale = minOf(widthScale, heightScale)
    val scale = rawScale.coerceIn(MIN_SCALE, MAX_SCALE)

    val scaledDensity = Density(
        density = baseDensity.density * scale,
        fontScale = baseDensity.fontScale
    )

    CompositionLocalProvider(LocalDensity provides scaledDensity) {
        content()
    }
}