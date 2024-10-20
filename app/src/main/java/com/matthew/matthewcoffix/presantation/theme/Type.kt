package com.matthew.matthewcoffix.presantation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.matthew.matthewcoffix.R

// Set of Material typography styles to start with
val openSans = FontFamily(
    Font(
        R.font.opensans_extrabold,
        weight = FontWeight(800),
        style = FontStyle.Normal
    ),
    Font(
        R.font.opensans_bold,
        weight = FontWeight.W700,
        style = FontStyle.Normal
    ),
    Font(
        R.font.opensans_bolditalic,
        weight = FontWeight.W700,
        style = FontStyle.Italic
    ),
    Font(
        R.font.opensans_semibold,
        weight = FontWeight.W600,
        style = FontStyle.Normal
    ),
    Font(
        R.font.opensans_medium,
        weight = FontWeight.W500,
        style = FontStyle.Normal
    ),
    Font(
        R.font.opensans_regular,
        weight = FontWeight.W400,
        style = FontStyle.Normal
    )
)

val raleway = FontFamily(
    Font(
        R.font.raleway_black,
        weight = FontWeight.W900,
        style = FontStyle.Normal
    ),
    Font(
        R.font.raleway_extrabold,
        weight = FontWeight.W800,
        style = FontStyle.Normal
    ),
    Font(
        R.font.raleway_bold,
        weight = FontWeight.W700,
        style = FontStyle.Normal
    ),
    Font(
        R.font.raleway_semibold,
        weight = FontWeight.W600,
        style = FontStyle.Normal
    ),
    Font(
        R.font.raleway_medium,
        weight = FontWeight.W500,
        style = FontStyle.Normal
    ),
    Font(
        R.font.raleway_regular,
        weight = FontWeight.W400,
        style = FontStyle.Normal
    ),
    Font(
        R.font.raleway_light,
        weight = FontWeight.W300,
        style = FontStyle.Normal
    ),
)