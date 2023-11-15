package com.upao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "fechas_citas")
public class FechasCitas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha",length = 100)
    private String fecha;    // Fecha de la cita

    @OneToMany(mappedBy = "fechaCita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HorasCitas> horasCitas;     // Lista de horas de citas asociadas a esta fecha

    public FechasCitas(Long id, String fecha, List<HorasCitas> horasCitas) {
        this.id = id;
        this.fecha = fecha;
        this.horasCitas = horasCitas;
    }

    public FechasCitas() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<HorasCitas> getHorasCitas() {
        return horasCitas;
    }

    public void setHorasCitas(List<HorasCitas> horasCitas) {
        this.horasCitas = horasCitas;
    }
}