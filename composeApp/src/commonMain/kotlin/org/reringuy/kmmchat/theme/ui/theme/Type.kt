package org.reringuy.kmmchat.theme.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import kmmchat.composeapp.generated.resources.*
import kmmchat.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun NotoSansFontFamily() = FontFamily(
    Font(Res.font.NotoSans_Black, weight = FontWeight.Thin),
    Font(Res.font.NotoSans_Thin, weight = FontWeight.Thin),
    Font(Res.font.NotoSans_ThinItalic, weight = FontWeight.Thin, style = FontStyle.Italic),
    Font(Res.font.NotoSans_ExtraLight, weight = FontWeight.ExtraLight),
    Font(Res.font.NotoSans_ExtraLightItalic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(Res.font.NotoSans_Light, weight = FontWeight.Light),
    Font(Res.font.NotoSans_LightItalic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(Res.font.NotoSans_Regular, weight = FontWeight.Normal),
    Font(Res.font.NotoSans_Italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(Res.font.NotoSans_Medium, weight = FontWeight.Medium),
    Font(Res.font.NotoSans_MediumItalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(Res.font.NotoSans_SemiBold, weight = FontWeight.SemiBold),
    Font(Res.font.NotoSans_SemiBoldItalic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(Res.font.NotoSans_Bold, weight = FontWeight.Bold),
    Font(Res.font.NotoSans_BoldItalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(Res.font.NotoSans_ExtraBold, weight = FontWeight.ExtraBold),
    Font(Res.font.NotoSans_ExtraBoldItalic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(Res.font.NotoSans_Black, weight = FontWeight.Black),
    Font(Res.font.NotoSans_BlackItalic, weight = FontWeight.Black, style = FontStyle.Italic)
)

@Composable
fun NotoSerifFamily() = FontFamily(
    Font(Res.font.NotoSerif_Black, weight = FontWeight.Thin),
    Font(Res.font.NotoSerif_Italic, weight = FontWeight.Thin, style = FontStyle.Italic),
    Font(Res.font.NotoSerif_ExtraLight, weight = FontWeight.ExtraLight),
    Font(Res.font.NotoSerif_ExtraLightItalic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(Res.font.NotoSerif_Light, weight = FontWeight.Light),
    Font(Res.font.NotoSerif_LightItalic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(Res.font.NotoSerif_Regular, weight = FontWeight.Normal),
    Font(Res.font.NotoSerif_Italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(Res.font.NotoSerif_Medium, weight = FontWeight.Medium),
    Font(Res.font.NotoSerif_MediumItalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(Res.font.NotoSerif_SemiBold, weight = FontWeight.SemiBold),
    Font(Res.font.NotoSerif_SemiBoldItalic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(Res.font.NotoSerif_Bold, weight = FontWeight.Bold),
    Font(Res.font.NotoSerif_BoldItalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(Res.font.NotoSerif_ExtraBold, weight = FontWeight.ExtraBold),
    Font(Res.font.NotoSerif_ExtraBoldItalic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(Res.font.NotoSerif_Black, weight = FontWeight.Black),
    Font(Res.font.NotoSerif_BlackItalic, weight = FontWeight.Black, style = FontStyle.Italic)
)

// Default Material 3 typography values
val baseline = Typography()

@Composable
fun AppTypography() = Typography().run {
    val notoSans = NotoSansFontFamily()
    val notoSerif = NotoSerifFamily()
    copy(
        displayLarge = baseline.displayLarge.copy(fontFamily = notoSans),
        displayMedium = baseline.displayMedium.copy(fontFamily = notoSans),
        displaySmall = baseline.displaySmall.copy(fontFamily = notoSans),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = notoSans),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = notoSans),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = notoSans),
        titleLarge = baseline.titleLarge.copy(fontFamily = notoSans),
        titleMedium = baseline.titleMedium.copy(fontFamily = notoSans),
        titleSmall = baseline.titleSmall.copy(fontFamily = notoSans),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = notoSerif),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = notoSerif),
        bodySmall = baseline.bodySmall.copy(fontFamily = notoSerif),
        labelLarge = baseline.labelLarge.copy(fontFamily = notoSerif),
        labelMedium = baseline.labelMedium.copy(fontFamily = notoSerif),
        labelSmall = baseline.labelSmall.copy(fontFamily = notoSerif),
    )
}

