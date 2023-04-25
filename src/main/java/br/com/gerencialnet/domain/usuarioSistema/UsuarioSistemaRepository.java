package br.com.gerencialnet.domain.usuarioSistema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioSistemaRepository extends JpaRepository<UsuarioSistema, Long> {

    UserDetails findByLogin(String login);
}
