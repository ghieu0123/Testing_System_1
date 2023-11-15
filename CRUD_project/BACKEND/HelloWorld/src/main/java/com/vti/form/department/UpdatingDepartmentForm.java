package com.vti.form.department;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.vti.entity.Department.Type;
import com.vti.validation.department.DepartmentIDExists;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdatingDepartmentForm {

	@NotBlank(message = "{Department.createDepartment.form.id.NotBlank}")
	@DepartmentIDExists(message = "{Department.createDepartment.form.departmentId.NotExists}")
	private int id;
	
	@NotBlank
	private String name;
	
	@NotBlank(message = "{Department.createDepartment.form.type.NotBlank}")
	@Pattern(regexp = "DEV|TEST|PM|ScrumMaster", message = "{Department.createDepartment.form.type.pattern}")
	private Type type;

//	private List<@Valid Account> accounts;
//
//	@Data
//	@NoArgsConstructor
//	public static class Account {
//		
//		@NotNull(message = "{Account.createAccount.form.id.NotBlank}")
//		@AccountIDExists
//		private Integer id;
//		
//	}

}
