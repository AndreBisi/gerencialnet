package br.com.gerencialnet.domain.usuarioSistema;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tbusuariosist")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioSistema implements UserDetails {

    @Id
    @Column(name="usuariocod", nullable = false)
    @SequenceGenerator(name="squsuariosist", sequenceName = "squsuariosist", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "squsuariosist")
    private Long id;

    @Column(name="usuarionome")
    private String login;

    @Column(name="usuarioativo")
    private Boolean ativo;

    @Column(name="usuariosenha")
    private String senha;

    @Column(name="usuariotipo")
    private String tipo;

    @Column(name="usuariosenhahash")
    private String senhaHash;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senhaHash;
    }

    @Override
    public String getUsername() { return login; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
