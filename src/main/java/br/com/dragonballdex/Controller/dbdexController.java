package br.com.dragonballdex.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dragonballdex.DTO.dbdexDto;
import br.com.dragonballdex.Entity.dbdexEntity;
import br.com.dragonballdex.Repository.dbdexRepository;
import br.com.dragonballdex.Service.dbdexService;
import br.com.dragonballdex.exception.ErrorMessage;

@RestController
@RequestMapping("/dbdex")
public class dbdexController {

	@Autowired
	dbdexService jumpservice;

	@Autowired
	dbdexRepository jumprepository;

//Inserir	
	@PostMapping
	public ResponseEntity<?> salvarPersonagens(@RequestBody dbdexDto dto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(jumpservice.salvar(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

//Deletar
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable long id) {
		try {
			jumprepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

//Editar
	@PutMapping
	public ResponseEntity<?> update(@RequestBody dbdexEntity updto) {
		try { 
			return ResponseEntity.status(HttpStatus.OK).body(jumprepository.saveAndFlush(updto));
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body
					(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

// Buscar Lista Completa
	@GetMapping("/personagens")
	public ResponseEntity<?>findAllProduct() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(jumprepository.findAll());
			
		}catch (Exception e){ 
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body
					(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

//Buscar por ID
	@GetMapping("/personagens/{id}")
	public ResponseEntity<?> findForId(@PathVariable long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(jumprepository.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}
	@GetMapping ("/busca/{nome}")
	public ResponseEntity<?> findByNome(@PathVariable String nome){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(jumprepository.findByNome(nome));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}
}
   