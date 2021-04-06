package br.com.dragonballdex.Converter;

import org.springframework.stereotype.Component;

import br.com.dragonballdex.DTO.dbdexDto;
import br.com.dragonballdex.Entity.dbdexEntity;

@Component
public class dbdexConverter {
	
	public dbdexDto toDTO(dbdexEntity entity) {
		dbdexDto jd = new dbdexDto ();
		jd.setNome(entity.getNome());
		jd.setRaca(entity.getRaca());
		
		return jd;
		
	}
	public dbdexEntity toEntity(dbdexDto dto) {
		dbdexEntity ej = new dbdexEntity();
		ej.setNome(dto.getNome());
		ej.setRaca(dto.getRaca());
		return ej;
	}
}