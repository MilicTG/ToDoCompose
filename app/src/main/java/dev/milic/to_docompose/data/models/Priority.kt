package dev.milic.to_docompose.data.models

import androidx.compose.ui.graphics.Color
import dev.milic.to_docompose.ui.theme.HighPriorityColor
import dev.milic.to_docompose.ui.theme.LowPriorityColor
import dev.milic.to_docompose.ui.theme.MediumPriorityColor
import dev.milic.to_docompose.ui.theme.NonePriorityColor


enum class Priority(val color: Color){
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}