package com.erosero.kruvacunas.config;

import com.erosero.kruvacunas.entity.Usuario;
import com.erosero.kruvacunas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioConfig implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByuserUsername(username);
		String rol = usuario.getTipoRol().getRolNombre().toUpperCase();
		return org.springframework.security.core.userdetails.User.withUsername(username)
				.password(usuario.getUserPassword()).roles(rol).build();
	}

}
