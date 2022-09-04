package com.erosero.kruvacunas.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_TIPO_ROL")
public class TipoRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_rol_id")
    private Integer rolId;

    @Column(name = "tipo_rol_nombre")
    private String rolNombre;

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }
}