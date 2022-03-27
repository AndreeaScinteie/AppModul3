package com.application.modul3.copil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.copil.dto.CopilDTO;
import com.application.modul3.copil.mapper.CopilMapper;

@RestController
@RequestMapping("/copii")
public class CopilController {

	@Autowired
	private CopilService copilService;
	
	@Autowired
	private CopilMapper copilMapper;
	
	@PostMapping
	public CopilDTO createCopil(@RequestBody CopilDTO copilDTO)
	{
		Copil createCopil = copilService.createCopil(copilMapper.copilDTO2Copil(copilDTO));
		return copilMapper.copil2copilDTO(createCopil);
	}
	
	@GetMapping("/list")
	public List<CopilDTO> getListaCopii()
	{
		return copilMapper.listaCopii2ListaCopiiDTO(copilService.getListaCopii());
	}
	
	@PutMapping("/{id}")
	public Copil updateCopil(@RequestBody Copil copil, @PathVariable Integer id)
	{
		return copilService.updateCopil(copil, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCopilById(@PathVariable Integer id)
	{
		copilService.deleteCopilById(id);
	}
}
