package com.vti.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.PhimDTO;
import com.vti.entity.Phim;
import com.vti.entity.User;
import com.vti.form.phim.CreatingPhimForm;
import com.vti.service.IPhimService;
import com.vti.service.IUserService;
import com.vti.validation.phim.PhimIDExists;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/v1/phims")
@Validated
public class PhimController {

	@Autowired
	private IPhimService service;
	
	private IUserService userService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MessageSource messageSource;

	@GetMapping(value = "/lists")
	public List<PhimDTO> getListPhims() {
		List<Phim> lst = service.getListPhims();

		// convert entities --> dtos
		List<PhimDTO> dtos = modelMapper.map(lst, new TypeToken<List<PhimDTO>>() {
		}.getType());

		return dtos;
	}

	@GetMapping(value = "/{id}")
	public PhimDTO getPhimByID(@PathVariable(name = "id") @PhimIDExists int id) {
		Phim entity = service.getPhimByID(id);

		// convert entity to dto
		PhimDTO dto = modelMapper.map(entity, PhimDTO.class);

		dto.add(linkTo(methodOn(PhimController.class).getPhimByID(id)).withSelfRel());

		return dto;
	}

	@GetMapping(value = "tenPhim/{tenPhim}")
	public boolean existsByTenPhim(@PathVariable(name = "tenPhim") String tenPhim) {
		
		return service.isPhimExistsByName(tenPhim);
		
	}

	@PostMapping()
	public ResponseEntity<?> createDepartment(Authentication authentication, @RequestBody @Valid CreatingPhimForm form) {
		// get user info
		User user = userService.findUserByUserName(authentication.getName());
		
		service.createPhim(user.getUserId(), form);
		
		return new ResponseEntity<>("Create sucesssfully!", HttpStatus.OK);
	}

	@GetMapping("/messages")
	public String getMessages(@RequestParam(value = "key") String key){
		return messageSource.getMessage(
				key, 
				null, 
				"Default message", 
				LocaleContextHolder.getLocale());
	}
	
	@GetMapping("/messages/vi")
	public String getMessagesVi(@RequestParam(value = "key") String key){
		return messageSource.getMessage(
				key, 
				null, 
				"Default message", 
				new Locale("vi", "VN"));
	}
	
	@GetMapping("/messages/en")
	public String getMessagesOther(@RequestParam(value = "key") String key){
		return messageSource.getMessage(
				key, 
				null, 
				"Default message", 
				Locale.US);
	}
}
