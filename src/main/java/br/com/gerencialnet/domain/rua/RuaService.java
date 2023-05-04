package br.com.gerencialnet.domain.rua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencialnet.domain.logradouro.Logradouro;
import br.com.gerencialnet.domain.logradouro.LogradouroRepository;

@Service
public class RuaService {

	@Autowired
	private RuaRepository ruaRepository;
	
	@Autowired
	private LogradouroRepository logradouroRepository;
	
	public DetalhamentoRuaDTO gravar(CadastroRuaDTO dados) {
		
		var logradouro = new Logradouro();
		
		if( dados.idLogradouro() != null ) {
			logradouro = logradouroRepository.getReferenceById(dados.idLogradouro());			
		}else {
			logradouro = new Logradouro();
		}
		
		var rua = new Rua( null, dados.nome(), dados.cep(), logradouro );
		
		ruaRepository.save(rua);
		return new DetalhamentoRuaDTO( rua );
	}
	
	
	
}
