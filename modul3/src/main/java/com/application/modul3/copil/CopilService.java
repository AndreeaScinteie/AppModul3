package com.application.modul3.copil;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CopilService {

	@Autowired
	private CopilRepository copilRepository;
	
	public Copil createCopil(Copil copil)
	{
		return copilRepository.saveAndFlush(copil);
	}
	
	public List<Copil> getListaCopii()
	{
		return copilRepository.findAll();
	}
	
	public Copil getCopilById(Integer id)
	{
		Optional<Copil> copilOpt = copilRepository.findById(id);
		if(copilOpt.isPresent())
		{
			return copilOpt.get();
		}
		return null;
	}
	
	public Copil updateCopil(Copil copil, Integer id)
	{
		Copil copilUpdate = getCopilById(id); 
		copilUpdate.setNume(copil.getNume());
		copilUpdate.setVarsta(copil.getVarsta());
		copilRepository.flush();
		return copilUpdate;
	}
	
	public void deleteCopilById(Integer id)
	{
		Copil copil = getCopilById(id);
		copil.setListaJucarii(null);
		copilRepository.deleteById(id);
	}
}
