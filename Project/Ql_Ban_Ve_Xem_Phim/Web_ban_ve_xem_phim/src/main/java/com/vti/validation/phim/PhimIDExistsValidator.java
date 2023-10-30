package com.vti.validation.phim;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vti.service.IPhimService;

public class PhimIDExistsValidator implements ConstraintValidator<PhimIDExists, Integer> {

	@Autowired
	private IPhimService service;

	@SuppressWarnings("deprecation")
	@Override
	public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {

		if (StringUtils.isEmpty(id)) {
			return true;
		}

		return service.isPhimExistsByID(id);
	}
}

