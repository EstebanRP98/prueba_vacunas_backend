package com.erosero.kruvacunas.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_EMPLEADO")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "emp_cedula", length = 10, unique = true)
    @Pattern(regexp = "^[0-9]{10}$", message = "La cedula ingresada no es correcta")
    private String empCedula;

    @NotNull(message = "Nombre requerido")
    @Column(name = "emp_nombre")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "El nombre debe tener solo letras")
    private String empNombre;

    @NotNull(message = "Apellido requerido")
    @Column(name = "emp_apellido")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "El apellido debe tener solo letras")
    private String empApellido;

    @NotNull(message = "Correo es requerido")
    @Column(name = "emp_correo")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "El correo ingresado no es correcto")
    private String empCorreo;

    @Column(name = "emp_fecha_nacimiento")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empFechaNacimiento;

    @Column(name = "emp_direccion_domicilio")
    private String empDireccionDomicilio;

    @Column(name = "emp_telefono")
    @Pattern(regexp = "^[0-9]{10}$", message = "El telefono ingresado no es correcto")
    private String empTelefono;


    @Column(name = "emp_vacunado")
    private Boolean empVacunado;

    @JsonManagedReference
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Vacuna> vacunaList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_user_id", referencedColumnName = "user_id")
    private Usuario usuario;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpCedula() {
        return empCedula;
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

    public List<Vacuna> getVacunaList() {
        return vacunaList;
    }

    public void setVacunaList(List<Vacuna> vacunaList) {
        this.vacunaList = vacunaList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
