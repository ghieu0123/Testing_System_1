package com.vti.validation.phim;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vti.service.IPhimService;

public class PhimNameNotExistsValidator implements ConstraintValidator<PhimNameNotExists, String> {

	@Autowired
	private IPhimService service;

	@SuppressWarnings("deprecation")
	@Override
	public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {

		if (StringUtils.isEmpty(name)) {
			return true;
		}

		return !service.isPhimExistsByName(name);
	}
}