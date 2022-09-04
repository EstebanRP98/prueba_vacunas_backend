package com.erosero.kruvacunas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_TIPO_VACUNA")
public class TipoVacuna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_vac_id")
    private Integer tpVacId;

    @Column(name = "tipo_vac_descripcion")
    private String tpVacDescripcion;

    public Integer getTpVacId() {
        return tpVacId;
    }

    public void setTpVacId(Integer tpVacId) {
        this.tpVacId = tpVacId;
    }

    public String getTpVacDescripcion() {
        return tpVacDescripcion;
    }

    public void setTpVacDescripcion(String tpVacDescripcion) {
        this.tpVacDescripcion = tpVacDescripcion;
    }
}
