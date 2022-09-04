package com.erosero.kruvacunas.repository;

import com.erosero.kruvacunas.entity.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacunaRepository extends JpaRepository<Vacuna, Integer> {


}
