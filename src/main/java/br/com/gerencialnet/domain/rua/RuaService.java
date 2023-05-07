package br.com.gerencialnet.domain.rua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencialnet.domain.logradouro.AtualizacaoLogradouroDTO;
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
			logradouro = null;
		}
		
		var rua = new Rua( null, dados.nome(), dados.cep(), logradouro );
		
		ruaRepository.save(rua);
		return new DetalhamentoRuaDTO( rua );
	}
	
    public DetalhamentoRuaDTO atualizarInformacoes(AtualizacaoRuaDTO dados) {
    	
    	var rua = ruaRepository.getReferenceById(dados.id());
    	
        if(dados.nome() != null){
            rua.setNome(dados.nome());
        }
        
        if(dados.cep() != null) {
        	rua.setCep(dados.cep());
        }
        
        if(dados.idlogradouro() != null) {
        	rua.setLogradouro(logradouroRepository.getReferenceById(dados.idlogradouro()));
        }
        
        return new DetalhamentoRuaDTO( rua );
    }	
	
}
