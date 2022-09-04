package com.erosero.kruvacunas.modelDto;

import com.erosero.kruvacunas.entity.Empleado;
import com.erosero.kruvacunas.entity.TipoVacuna;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class VacunaDto {

    private Integer vacId;
    private int vacTipoVacuna;
    private Date vacFecha;
    private int vacNumeroDosis;


    public Integer getVacId() {
        return vacId;
    }

    public void setVacId(Integer vacId) {
        this.vacId = vacId;
    }

    public int getVacTipoVacuna() {
        return vacTipoVacuna;
    }

    public void setVacTipoVacuna(int vacTipoVacuna) {
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


}
