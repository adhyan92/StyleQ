package com.example.styleq.data

import androidx.compose.foundation.shape.GenericShape
import androidx.compose.ui.geometry.Rect

data class VoucherItem(
    val title: String,
    val subtitle: String,
    val validity: String
) {
    companion object {
        val TicketShape = GenericShape { size, _ ->
            val cornerRadius = 40f
            val cutoutY = size.height * 0.32f
            val cutoutRadius = 24f


            moveTo(cornerRadius, 0f)


            lineTo(size.width - cornerRadius, 0f)
            arcTo(
                rect = Rect(size.width - cornerRadius * 2, 0f, size.width, cornerRadius * 2),
                startAngleDegrees = 270f, sweepAngleDegrees = 90f, forceMoveTo = false
            )


            lineTo(size.width, cutoutY - cutoutRadius)
            arcTo(
                rect = Rect(size.width - cutoutRadius, cutoutY - cutoutRadius, size.width + cutoutRadius, cutoutY + cutoutRadius),
                startAngleDegrees = 270f, sweepAngleDegrees = -180f, forceMoveTo = false
            )


            lineTo(size.width, size.height - cornerRadius)
            arcTo(
                rect = Rect(size.width - cornerRadius * 2, size.height - cornerRadius * 2, size.width, size.height),
                startAngleDegrees = 0f, sweepAngleDegrees = 90f, forceMoveTo = false
            )


            lineTo(cornerRadius, size.height)
            arcTo(
                rect = Rect(0f, size.height - cornerRadius * 2, cornerRadius * 2, size.height),
                startAngleDegrees = 90f, sweepAngleDegrees = 90f, forceMoveTo = false
            )


            lineTo(0f, cutoutY + cutoutRadius)
            arcTo(
                rect = Rect(-cutoutRadius, cutoutY - cutoutRadius, cutoutRadius, cutoutY + cutoutRadius),
                startAngleDegrees = 90f, sweepAngleDegrees = -180f, forceMoveTo = false
            )


            lineTo(0f, cornerRadius)
            arcTo(
                rect = Rect(0f, 0f, cornerRadius * 2, cornerRadius * 2),
                startAngleDegrees = 180f, sweepAngleDegrees = 90f, forceMoveTo = false
            )

            close()
        }
    }
}