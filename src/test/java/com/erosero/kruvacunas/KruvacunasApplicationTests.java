package com.erosero.kruvacunas;

import com.erosero.kruvacunas.entity.Empleado;
import com.erosero.kruvacunas.entity.TipoRol;
import com.erosero.kruvacunas.entity.Usuario;
import com.erosero.kruvacunas.repository.EmpleadoRepository;
import com.erosero.kruvacunas.repository.TipoRolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class KruvacunasApplicationTests {

    @Autowired
    EmpleadoRepository empleadoRepository;
    @Autowired
    TipoRolRepository tipoRolRepository;

    @Test
    void encontrarEmpleadoPorId(){
        Optional<Empleado> empleado = empleadoRepository.findById(1);
        assertTrue(empleado.isPresent());
        assertEquals("1708306046", empleado.get().getEmpCedula());
    }

    @Test
    void saveEmpleado(){
        Optional<TipoRol> tipoRol = tipoRolRepository.findById(2);

        Usuario usuario = new Usuario(2, "eperez","david5perez", tipoRol.get());

        Empleado empleado = new Empleado(1, "1708306046", "david alejandro", "pinto perez",
                "david@gmail.com", new Date(), "Quito",
                "0992958166", true, new ArrayList<>(), usuario);

        Empleado empleadoGuardado = empleadoRepository.save(empleado);


        assertEquals("1708306046", empleadoGuardado.getEmpCedula());
        assertEquals("0992958166", empleadoGuardado.getEmpTelefono());
    }

}
