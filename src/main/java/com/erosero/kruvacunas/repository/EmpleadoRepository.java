package com.erosero.kruvacunas.repository;

import com.erosero.kruvacunas.entity.Empleado;
import com.erosero.kruvacunas.entity.TipoVacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {


    @Query(value = "select e " +
            "from Empleado e " +
            "inner join Vacuna v on v.empleado=e " +
            "where e.empVacunado=:vacunado or v.vacTipoVacuna.tpVacId=:tipoVacuna " +
            "or v.vacFecha BETWEEN :fechaInicial AND :fechaFinal")
    List<Empleado> filtradoBusqueda(Date fechaInicial,
                                    Date fechaFinal,
                                    Boolean vacunado,
                                    Integer tipoVacuna);



}
