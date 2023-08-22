package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.TypeQuestion.TypeName;

@Converter(autoApply = true)
public class TypeNameConverter implements AttributeConverter<TypeQuestion.TypeName, String> {

	public String convertToDatabaseColumn(TypeName typeName) {
		if (typeName == null) {
			return null;
		}
		return typeName.getTypeName();
	}

	public TypeName convertToEntityAttribute(String sqlStatus) {
		if (sqlStatus == null) {
			return null;
		}
		return TypeQuestion.TypeName.toEnum(sqlStatus);
	}

}
