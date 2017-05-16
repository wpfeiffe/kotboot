package com.wspfeiffer.kotlin.converter

import java.sql.Date
import java.time.LocalDate
import javax.persistence.AttributeConverter
import javax.persistence.Converter


/**
 * Convert Date/LocalDate
 */

@SuppressWarnings("UnusedDeclaration")
@Converter(autoApply = true)
class LocalDateConverter : AttributeConverter<LocalDate, Date> {
    override fun convertToDatabaseColumn(attribute: LocalDate?): Date? {
        return if (attribute == null) null else Date.valueOf(attribute)
    }

    override fun convertToEntityAttribute(dbData: Date?): LocalDate? {
        return dbData?.toLocalDate()
    }
}