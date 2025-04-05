package com.igoparking.adapter.`in`.common.converter

import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.pattern.color.ANSIConstants
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase

class LogbackHighlightConverter : ForegroundCompositeConverterBase<ILoggingEvent>() {
    override fun getForegroundColorCode(event: ILoggingEvent): String =
        when (event.level.toString()) {
            "ERROR" -> ANSIConstants.BOLD + ANSIConstants.RED_FG
            "WARN" -> ANSIConstants.BOLD + ANSIConstants.YELLOW_FG
            "INFO" -> ANSIConstants.BOLD + ANSIConstants.GREEN_FG
            "DEBUG" -> ANSIConstants.BOLD + ANSIConstants.BLUE_FG
            "TRACE" -> ANSIConstants.BLUE_FG
            else -> ANSIConstants.DEFAULT_FG
        }
}
