package com.erosero.kruvacunas.services;

import com.erosero.kruvacunas.entity.Empleado;
import com.erosero.kruvacunas.entity.TipoVacuna;
import com.erosero.kruvacunas.entity.Usuario;
import com.erosero.kruvacunas.entity.Vacuna;
import com.erosero.kruvacunas.modelDto.EmpleadoDto;
import com.erosero.kruvacunas.modelDto.VacunaDto;
import com.erosero.kruvacunas.repository.EmpleadoRepository;
import com.erosero.kruvacunas.repository.TipoRolRepository;
import com.erosero.kruvacunas.repository.TipoVacunaRepository;
import com.erosero.kruvacunas.util.UtilsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private TipoRolRepository tipoRolRepository;

    @Autowired
    private TipoVacunaRepository tipoVacunaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado crearEmpleado(EmpleadoDto empleado) throws Exception {

        if (empleado.getEmpCedula()!=null) {
            Boolean cedulaValida = UtilsApi.validadorDeCedula(empleado.getEmpCedula());
            if (!cedulaValida.booleanValue()) {
                throw new Exception("La cédula ingresada no es una cedula valida");
            }
        }

        //creacion del usuario del empleado
        Usuario usuario = new Usuario();
        String primerNombre = empleado.getEmpNombre().split(" ")[0].toLowerCase();
        String primerApellido = empleado.getEmpApellido().split(" ")[0].toLowerCase();
        String username = primerNombre.charAt(0)
                + primerApellido;
        usuario.setUserUsername(username);
        usuario.setUserPassword(passwordEncoder.encode(primerNombre + primerNombre.length() + primerApellido));
        usuario.setTipoRol(tipoRolRepository.findByRolNombre("USER"));

        Empleado empleadoGuardar = new Empleado();

        empleadoGuardar.setEmpNombre(empleado.getEmpNombre() != null ?  empleado.getEmpNombre() : null);
        empleadoGuardar.setEmpApellido(empleado.getEmpApellido() != null ? empleado.getEmpApellido() : null);
        empleadoGuardar.setEmpCedula(empleado.getEmpCedula() != null ? empleado.getEmpCedula() : null);
        empleadoGuardar.setEmpCorreo(empleado.getEmpCorreo() != null ? empleado.getEmpCorreo() : null);
        empleadoGuardar.setEmpFechaNacimiento(empleado.getEmpFechaNacimiento() != null ? empleado.getEmpFechaNacimiento() : null);
        empleadoGuardar.setEmpDireccionDomicilio(
                empleado.getEmpDireccionDomicilio() != null ? empleado.getEmpDireccionDomicilio() : null);
        empleadoGuardar.setEmpTelefono(empleado.getEmpTelefono() != null ? empleado.getEmpTelefono() : null);
        empleadoGuardar.setEmpVacunado(
                empleado.getEmpVacunado() != null ? empleado.getEmpVacunado() : false);

        empleadoGuardar.setUsuario(usuario);
        return empleadoRepository.save(empleadoGuardar);
    }

    public Empleado actualizarEmpleado(Integer id, EmpleadoDto empleado) throws Exception {
        Optional<Empleado> empleadoBase = empleadoRepository.findById(id);

        if (!empleadoBase.isPresent()) {
            throw new Exception("El Empleado Ingresado No Existe");
        }
        Empleado empleadoEncontrado = empleadoBase.get();

        if (empleado.getEmpVacunado() == true && (empleado.getVacunaList() == null || empleado.getVacunaList().size() == 0)) {
            throw new Exception("Debe Ingresar Informacion sobre sus vacunas");
        }

        if (empleado.getEmpCedula()!=null) {
            Boolean cedulaValida = UtilsApi.validadorDeCedula(empleado.getEmpCedula());
            if (!cedulaValida.booleanValue()) {
                throw new Exception("La cédula ingresada no es una cedula valida");
            }
        }

        empleadoEncontrado.setEmpNombre(
                empleado.getEmpNombre() != null ?  empleado.getEmpNombre() : empleadoEncontrado.getEmpNombre());
        empleadoEncontrado.setEmpApellido(
                empleado.getEmpApellido() != null ? empleado.getEmpApellido()
                : empleadoEncontrado.getEmpApellido());
        empleadoEncontrado.setEmpCedula(
                empleado.getEmpCedula() != null ? empleado.getEmpCedula() : empleadoEncontrado.getEmpCedula());
        empleadoEncontrado.setEmpCorreo(
                empleado.getEmpCorreo() != null ? empleado.getEmpCorreo() : empleadoEncontrado.getEmpCorreo());
        empleadoEncontrado.setEmpFechaNacimiento(
                empleado.getEmpFechaNacimiento() != null ? empleado.getEmpFechaNacimiento()
                : empleadoEncontrado.getEmpFechaNacimiento());
        empleadoEncontrado.setEmpDireccionDomicilio(
                empleado.getEmpDireccionDomicilio() != null ? empleado.getEmpDireccionDomicilio()
                : empleadoEncontrado.getEmpDireccionDomicilio());
        empleadoEncontrado.setEmpTelefono(empleado.getEmpTelefono() != null ? empleado.getEmpTelefono()
                : empleadoEncontrado.getEmpTelefono());
        empleadoEncontrado.setEmpVacunado(
                empleado.getEmpVacunado() != null ? empleado.getEmpVacunado() : empleadoEncontrado.getEmpVacunado());


        for (VacunaDto vacuna : empleado.getVacunaList()) {
            Vacuna vacunaGuardar = new Vacuna();
            vacunaGuardar.setEmpleado(empleadoEncontrado);
            vacunaGuardar.setVacNumeroDosis(vacuna.getVacNumeroDosis());
            vacunaGuardar.setVacFecha(vacuna.getVacFecha());
            Optional<TipoVacuna> tipoVacuna = tipoVacunaRepository.findById(vacuna.getVacTipoVacuna());
            vacunaGuardar.setVacTipoVacuna(tipoVacuna.isPresent() ? tipoVacuna.get() : null);
            empleadoEncontrado.getVacunaList().add(vacunaGuardar);
        }

        empleadoEncontrado = empleadoRepository.save(empleadoEncontrado);
        return empleadoEncontrado;
    }

    public Empleado eliminarEmpleado(Integer empleadoId) throws Exception {
        Optional<Empleado> empleado = empleadoRepository.findById(empleadoId);
        if (!empleado.isPresent()) {
            throw new Exception("El Empleado Ingresado No Existe");
        }
        empleadoRepository.delete(empleado.get());
        return empleado.get();
    }

    public Empleado encontrarEmpleadoPorId(Integer empleadoId) throws Exception {
        Optional<Empleado> empleado = empleadoRepository.findById(empleadoId);
        if (!empleado.isPresent()) {
            throw new Exception("El Empleado Ingresado No Existe");
        }
        return empleado.get();
    }

    public List<Empleado> busquedaFiltros(Date fechaInicial,
                                          Date fechaFinal,
                                          Boolean vacunado,
                                          Integer tipoVacuna) throws Exception {
        List<Empleado> empleadoList = empleadoRepository.filtradoBusqueda(fechaInicial, fechaFinal, vacunado, tipoVacuna);
        if(empleadoList.isEmpty()){
            throw new Exception("Sin resultados");
        }

        return empleadoList;
    }




}
