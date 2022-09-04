package com.erosero.kruvacunas.repository;

import com.erosero.kruvacunas.entity.TipoVacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoVacunaRepository extends JpaRepository<TipoVacuna, Integer> {


}
