package com.application.modul3.copil.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.copil.Copil;
import com.application.modul3.copil.dto.CopilDTO;

@Service
public class CopilMapper {

	public CopilDTO copil2copilDTO(Copil copil)
	{
		CopilDTO copilDTO = new CopilDTO();
		copilDTO.setId(copil.getId());
		copilDTO.setNume(copil.getNume());
		copilDTO.setVarsta(copil.getVarsta());
		copilDTO.setListaJucarii(copil.getListaJucarii());
		return copilDTO;
	}
	
	public Copil copilDTO2Copil(CopilDTO copilDTO)
	{
		Copil copil = new Copil();
		copil.setId(copilDTO.getId());
		copil.setNume(copilDTO.getNume());
		copil.setVarsta(copilDTO.getVarsta());
		copil.setListaJucarii(copilDTO.getListaJucarii());
		return copil;
		
	}
	
	public List<CopilDTO> listaCopii2ListaCopiiDTO(List<Copil> copii)
	{
		return copii.stream().map(copil->copil2copilDTO(copil)).collect(Collectors.toList());
	}
}
