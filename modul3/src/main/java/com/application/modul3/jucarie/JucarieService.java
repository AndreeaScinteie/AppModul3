package com.application.modul3.jucarie;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class JucarieService {

	@Autowired
	private JucarieRepository jucarieRepository;
	
	public Jucarie createJucarie(Jucarie jucarie)
	{
		return jucarieRepository.saveAndFlush(jucarie);
	}
	
	public Jucarie getJucarieById(Integer id)
	{
		Optional<Jucarie> jucarieOpt = jucarieRepository.findById(id);
		if(jucarieOpt.isPresent())
		{
			return jucarieOpt.get();
		}
		return null;
	}
	
	public void deleteJucarieById(Integer id)
	{
		Jucarie jucarie = getJucarieById(id);
		jucarie.setCopil(null);
		jucarieRepository.deleteById(id);
	}
}
