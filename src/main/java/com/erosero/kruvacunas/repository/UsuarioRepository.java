package com.erosero.kruvacunas.repository;

import com.erosero.kruvacunas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {



    Usuario findByuserUsername(String username);


}
