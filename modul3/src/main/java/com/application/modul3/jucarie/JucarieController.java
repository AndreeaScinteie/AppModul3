package com.application.modul3.jucarie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.jucarie.dto.JucarieDTO;
import com.application.modul3.jucarie.mapper.JucarieMapper;

@RestController
@RequestMapping("/jucarii")
public class JucarieController {

	@Autowired
	private JucarieService jucarieService;
	
	@Autowired
	private JucarieMapper jucarieMapper;
	
	public JucarieDTO createJucarie(@RequestBody JucarieDTO jucarieDTO)
	{
		Jucarie jucarie = jucarieService.createJucarie(jucarieMapper.jucarieDTO2Jucarie(jucarieDTO));
		return jucarieMapper.jucarie2JucarieDTO(jucarie);
	}
	
	@DeleteMapping("/{id}")
	public void deleteJucarieById(@PathVariable Integer id)
	{
		jucarieService.deleteJucarieById(id);
	}
}
