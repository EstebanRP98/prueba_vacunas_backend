package com.erosero.kruvacunas.controller;

import com.erosero.kruvacunas.entity.Empleado;
import com.erosero.kruvacunas.entity.TipoVacuna;
import com.erosero.kruvacunas.modelDto.EmpleadoDto;
import com.erosero.kruvacunas.services.EmpleadoService;
import com.erosero.kruvacunas.util.GenericResponse;
import com.erosero.kruvacunas.util.ParametersApp;
import com.erosero.kruvacunas.util.UtilsApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/empleado")
@SecurityRequirement(name = "basicAuth")
@Tag(name = "Empleado", description = "API de Empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @Operation(
            summary = "Encontrar todos los Empleados",
            description = "Api para encontrar todos los empleados registrados"
    )
    @GetMapping(value = "/listarEmpleados")
    public ResponseEntity<GenericResponse> listarEmpleados() {
        GenericResponse<List<Empleado>> empleadoGR = new GenericResponse<>();
        try {
            empleadoGR.setObject(empleadoService.listarEmpleados());
            empleadoGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            empleadoGR.setObject(null);
            empleadoGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            empleadoGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(empleadoGR, HttpStatus.OK);
    }

    @Operation(
            summary = "Crear Empleado",
            description = "Api para crear un empleado"
    )
    @PostMapping(value = "/crearEmpleado")
    public ResponseEntity<GenericResponse> crearEmpleado(@RequestBody EmpleadoDto empleado) {
        GenericResponse<Empleado> empleadoGR = new GenericResponse<>();
        try {
            empleadoGR.setObject(empleadoService.crearEmpleado(empleado));
            empleadoGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            empleadoGR.setObject(null);
            empleadoGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            empleadoGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(empleadoGR, HttpStatus.OK);
    }

    @Operation(
            summary = "Actualizar Empleado",
            description = "Api para actualizar un empleado"
    )
    @PutMapping("/actualizarEmpleado/{id}")
    public ResponseEntity<GenericResponse> actualizarEmpleado(@PathVariable(value = "id") Integer empleadoId,
                                                          @RequestBody EmpleadoDto empleado) {
        GenericResponse<Empleado> empleadoGR = new GenericResponse<>();
        try {
            empleadoGR.setObject(empleadoService.actualizarEmpleado(empleadoId, empleado));
            empleadoGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            empleadoGR.setObject(null);
            empleadoGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            empleadoGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(empleadoGR, HttpStatus.OK);
    }

    @Operation(
            summary = "Eliminar Empleado",
            description = "Api para eliminar un empleado"
    )
    @DeleteMapping("/eliminarEmpleado/{id}")
    public ResponseEntity<GenericResponse> eliminarEmpleado(@PathVariable(value = "id") Integer empleadoId) {
        GenericResponse<Empleado> empleadoGR = new GenericResponse<>();
        try {
            empleadoGR.setObject(empleadoService.eliminarEmpleado(empleadoId));
            empleadoGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            empleadoGR.setObject(null);
            empleadoGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            empleadoGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(empleadoGR, HttpStatus.OK);
    }

    @Operation(
            summary = "Encontrar Empleado por Id",
            description = "Api para encontrar un empleado por Id"
    )
    @GetMapping(value = { "/encontrarEmpleadoPorId/{id}" })
    public ResponseEntity<GenericResponse> encontrarEmpleadoPorId(@PathVariable(value = "id") Integer empleadoId) {
        GenericResponse<Empleado> empleadoGR = new GenericResponse<>();
        try {
            empleadoGR.setObject(empleadoService.encontrarEmpleadoPorId(empleadoId));
            empleadoGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            empleadoGR.setObject(null);
            empleadoGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            empleadoGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(empleadoGR, HttpStatus.OK);
    }
    @Operation(
            summary = "Encontrar Empleado por parametro de busqueda",
            description = "Se puede filtrar por si el empleado esta vacunado, " +
                    "tipoVacuna, o rango de fechas de la vacunacion "
    )
    @PostMapping("/filtrarEmpleados")
    public ResponseEntity<GenericResponse> filtrarEmpleados(
                                           @RequestParam("fechaInicial") @DateTimeFormat(pattern="dd-MM-yyyy") Date fechaInicial,
                                           @RequestParam("fechaFinal") @DateTimeFormat(pattern="dd-MM-yyyy") Date fechaFinal,
                                           @RequestParam("vacunado") Boolean vacunado,
                                           @RequestParam("tipoVacuna") Integer tipoVacuna) {
        GenericResponse<List<Empleado>> empleadoGR = new GenericResponse<>();
        try {
            empleadoGR.setObject(empleadoService.busquedaFiltros(fechaInicial, fechaFinal, vacunado, tipoVacuna));
            empleadoGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            empleadoGR.setObject(null);
            empleadoGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            empleadoGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(empleadoGR, HttpStatus.OK);
    }



}
