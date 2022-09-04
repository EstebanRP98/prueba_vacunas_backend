package com.erosero.kruvacunas.modelDto;

import java.util.Date;

public class VacunaDto {

    private int vacTipoVacuna;
    private Date vacFecha;
    private int vacNumeroDosis;

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
