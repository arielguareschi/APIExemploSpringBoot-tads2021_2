package br.unisep.edu.tads.exemplo1.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unisep.edu.tads.exemplo1.exception.ResourceNotFoundException;
import br.unisep.edu.tads.exemplo1.model.Cidade;
import br.unisep.edu.tads.exemplo1.repository.CidadeRepository;

@RestController
@RequestMapping("/api/v1")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping("/cidade")
	public List<Cidade> getAllCidades() {
		return cidadeRepository.findAll();
	}

	@GetMapping("/cidade/{id}")
	public ResponseEntity<Cidade> getCidadeById(@PathVariable(value = "id") Long cidadeId)
			throws ResourceNotFoundException {
		Cidade cidade = cidadeRepository.findById(cidadeId)
				.orElseThrow(() -> new ResourceNotFoundException("Cidade nao encontrada: " + cidadeId));
		return ResponseEntity.ok().body(cidade);
	}

	@PostMapping("/cidade")
	public Cidade createCidade(@RequestBody Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	@PutMapping("/cidade/{id}")
	public ResponseEntity<Cidade> updateCidade(@PathVariable(value = "id") Long cidadeId, @RequestBody Cidade detalhes)
			throws ResourceNotFoundException {
		Cidade cidade = cidadeRepository.findById(cidadeId)
				.orElseThrow(() -> new ResourceNotFoundException("Cidade nao encontrada: " + cidadeId));
		cidade.setNome(detalhes.getNome());
		cidade.setUf(detalhes.getUf());
		cidade.setAlteradoEm(new Date());
		Cidade updateCidade = cidadeRepository.save(cidade);
		return ResponseEntity.ok(updateCidade);
	}

	@DeleteMapping("/cidade/{id}")
	public Map<String, Boolean> deleteCidade(@PathVariable(value = "id") Long cidadeId) throws Exception {
		Cidade cidade = cidadeRepository.findById(cidadeId)
				.orElseThrow(() -> new ResourceNotFoundException("Cidade nao encontrada: " + cidadeId));
		cidadeRepository.delete(cidade);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
