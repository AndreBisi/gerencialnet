package br.com.gerencialnet.domain.servico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
	
	/*@Query("""
            select s from Servico s
            where
            s.nome like %:nome%""")*/
	Page<Servico> findByNomeContaining(String nome, Pageable paginacao);

}
