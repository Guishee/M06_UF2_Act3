package com.example.act3uf2m06.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Clients")
public class Clients {
    @Id
    @Column(name = "dni")
    private String dni;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;
    @Column(name = "pais")
    private String pais;

    @OneToMany(mappedBy = "idClients", cascade = CascadeType.ALL)
    private List<Comptes> IdCompte = new ArrayList<>();





    public Clients() {
    }

    public Clients(String dni, String nombre, String correo, String pais) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.pais = pais;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Comptes> getIdCompte() {
        return IdCompte;
    }

    public void setIdCompte(List<Comptes> compteByIdCompte) {
        this.IdCompte = compteByIdCompte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return dni == clients.dni && nombre.equals(clients.nombre) && correo.equals(clients.correo) && pais.equals(clients.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, correo, pais);
    }


}