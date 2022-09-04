package com.erosero.kruvacunas.modelDto;

import com.erosero.kruvacunas.entity.Usuario;
import com.erosero.kruvacunas.entity.Vacuna;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

public class EmpleadoDto {

    private String empCedula;
    private String empNombre;
    private String empApellido;
    private String empCorreo;
    private Date empFechaNacimiento;
    private String empDireccionDomicilio;
    private String empTelefono;
    private Boolean empVacunado;
    private List<VacunaDto> vacunaList;

    public String getEmpCedula() {
        return empCedula;
    }

    public List<VacunaDto> getVacunaList() {
        return vacunaList;
    }

    public void setVacunaList(List<VacunaDto> vacunaList) {
        this.vacunaList = vacunaList;
    }

    public void setEmpCedula(String empCedula) {
        this.empCedula = empCedula;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpApellido() {
        return empApellido;
    }

    public void setEmpApellido(String empApellido) {
        this.empApellido = empApellido;
    }

    public String getEmpCorreo() {
        return empCorreo;
    }

    public void setEmpCorreo(String empCorreo) {
        this.empCorreo = empCorreo;
    }

    public Date getEmpFechaNacimiento() {
        return empFechaNacimiento;
    }

    public void setEmpFechaNacimiento(Date empFechaNacimiento) {
        this.empFechaNacimiento = empFechaNacimiento;
    }

    public String getEmpDireccionDomicilio() {
        return empDireccionDomicilio;
    }

    public void setEmpDireccionDomicilio(String empDireccionDomicilio) {
        this.empDireccionDomicilio = empDireccionDomicilio;
    }

    public String getEmpTelefono() {
        return empTelefono;
    }

    public void setEmpTelefono(String empTelefono) {
        this.empTelefono = empTelefono;
    }

    public Boolean getEmpVacunado() {
        return empVacunado;
    }

    public void setEmpVacunado(Boolean empVacunado) {
        this.empVacunado = empVacunado;
    }
}
