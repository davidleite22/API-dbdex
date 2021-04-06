package br.com.dragonballdex.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dragonballdex.Converter.dbdexConverter;
import br.com.dragonballdex.DTO.dbdexDto;
import br.com.dragonballdex.Repository.dbdexRepository;

@Service
public class dbdexService {

	@Autowired
	dbdexRepository jumprepository;
	@Autowired
	dbdexConverter jumpconverter;
	
	@Transactional
	public dbdexDto salvar(dbdexDto dto) {
		
		try {
			var a = jumpconverter.toEntity(dto);
			var b = jumprepository.save(a);
			var c = jumpconverter.toDTO(b);
			
			return c;
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
  