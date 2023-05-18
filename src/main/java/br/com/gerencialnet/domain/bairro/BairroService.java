package br.com.gerencialnet.domain.bairro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencialnet.domain.tipoBairro.TipoBairro;
import br.com.gerencialnet.domain.tipoBairro.TipoBairroRepository;

@Service
public class BairroService {
	
	@Autowired
	private BairroRepository bairroRepository;
	
	@Autowired
	private TipoBairroRepository tipoBairroRepository;
	
	public DetalhamentoBairroDTO gravar(CadastroBairroDTO dados) {
		
		var tipoBairro = new TipoBairro();
		
		if( dados.idTipoBairro() != null ) {
			tipoBairro = tipoBairroRepository.getReferenceById(dados.idTipoBairro());			
		}else {
			tipoBairro = null;
		}
		
		var bairro = new Bairro( null, dados.nome(), tipoBairro );
		
		bairroRepository.save(bairro);
		return new DetalhamentoBairroDTO( bairro );
	}	

	
    public DetalhamentoBairroDTO atualizarInformacoes(AtualizacaoBairroDTO dados) {
    	
    	var bairro = bairroRepository.getReferenceById(dados.id());
    	
        if(dados.nome() != null){
            bairro.setNome(dados.nome());
        }        
        
        if(dados.idTipoBairro() != null) {
        	bairro.setTipoBairro(tipoBairroRepository.getReferenceById(dados.idTipoBairro()));
        }
        
        return new DetalhamentoBairroDTO( bairro );
    }
}
