package com.erosero.kruvacunas;

import com.erosero.kruvacunas.entity.Usuario;
import com.erosero.kruvacunas.repository.TipoRolRepository;
import com.erosero.kruvacunas.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SecurityScheme(name = "basicAuth", // can be set to anything
		type = SecuritySchemeType.HTTP, scheme = "basic", in = SecuritySchemeIn.HEADER)
@SpringBootApplication
public class KruvacunasApplication implements ApplicationRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private TipoRolRepository tipoRolRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario usuario = new Usuario();
		if (usuarioRepository.findByuserUsername("ADMIN") != null) {
			System.out.println("El Usuario Administrador ya existe");
		} else {
			usuario.setUserUsername("ADMIN");
			usuario.setUserPassword(passwordEncoder.encode("ADMIN"));
			usuario.setTipoRol(tipoRolRepository.findByRolNombre("ADMIN"));
			usuarioRepository.save(usuario);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(KruvacunasApplication.class, args);
	}

}
