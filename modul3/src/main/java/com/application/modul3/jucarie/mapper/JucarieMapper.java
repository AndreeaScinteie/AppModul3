package com.application.modul3.jucarie.mapper;

import org.springframework.stereotype.Service;

import com.application.modul3.jucarie.Jucarie;
import com.application.modul3.jucarie.dto.JucarieDTO;

@Service
public class JucarieMapper {

	public JucarieDTO jucarie2JucarieDTO(Jucarie jucarie)
	{
		JucarieDTO jucarieDTO = new JucarieDTO();
		jucarieDTO.setId(jucarie.getId());
		jucarieDTO.setNume(jucarie.getNume());
		jucarieDTO.setTip(jucarie.getTip());
		jucarieDTO.setPret(jucarie.getPret());
		return jucarieDTO;
	}
	
	public Jucarie jucarieDTO2Jucarie(JucarieDTO jucarieDTO) {
		Jucarie jucarie = new Jucarie();
		jucarie.setId(jucarieDTO.getId());
		jucarie.setNume(jucarieDTO.getNume());
		jucarie.setTip(jucarieDTO.getTip());
		jucarie.setPret(jucarieDTO.getPret());
		return jucarie;
	}
	
}
