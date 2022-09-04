package com.erosero.kruvacunas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_VACUNA")
public class Vacuna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vac_id")
    private Integer vacId;

    @OneToOne
    @JoinColumn(name = "vac_tipo_vacuna_id", referencedColumnName = "tipo_vac_id")
    private TipoVacuna vacTipoVacuna;

    @Column(name = "vac_fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date vacFecha;

    @Column(name = "vac_numero_dosis")
    private int vacNumeroDosis;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Empleado.class)
    @JoinColumn(name = "vac_emp_id", referencedColumnName = "emp_id")
    private Empleado empleado;


    public Integer getVacId() {
        return vacId;
    }

    public void setVacId(Integer vacId) {
        this.vacId = vacId;
    }

    public TipoVacuna getVacTipoVacuna() {
        return vacTipoVacuna;
    }

    public void setVacTipoVacuna(TipoVacuna vacTipoVacuna) {
        this.vacTipoVacuna = vacTipoVacuna;
    }

    public Date getVacFecha() {
        return vacFecha;
    }

    public void setVacFecha(Date vacFecha) {
        this.vacFecha = vacFecha;
    }

    public int getVacNumeroDosis() {
        return vacNumeroDosis;
    }

    public void setVacNumeroDosis(int vacNumeroDosis) {
        this.vacNumeroDosis = vacNumeroDosis;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
