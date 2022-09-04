package com.erosero.kruvacunas.repository;

import com.erosero.kruvacunas.entity.TipoRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRolRepository extends JpaRepository<TipoRol, Integer> {


    TipoRol findByRolNombre(String rolNombre);




}
