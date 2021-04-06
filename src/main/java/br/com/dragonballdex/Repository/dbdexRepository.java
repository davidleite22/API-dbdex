package br.com.dragonballdex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dragonballdex.Entity.dbdexEntity;

@Repository
public interface dbdexRepository  extends JpaRepository<dbdexEntity, Long>{
	
	public dbdexEntity findByNome(String nome);
	
}
