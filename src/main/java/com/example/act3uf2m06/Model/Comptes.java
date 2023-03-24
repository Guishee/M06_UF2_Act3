package com.example.act3uf2m06.Model;
import com.example.act3uf2m06.Model.Clients;
import jakarta.persistence.*;

@Entity
@Table(name = "Comptes")
public class Comptes {
    @Id
    @Column(name = "cuenta")
    private String cuenta;

    @Column(name = "ingresoInicial")
    private int ingresoInicial;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "dni")
    private Clients idClients;


    public Comptes() {

    }

    public Comptes(String cuenta, int ingreso, Clients idClients) {
        this.cuenta = cuenta;
        this.ingresoInicial = ingreso;
        this.idClients = idClients;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public int getIngresoInicial() {
        return ingresoInicial;
    }

    public void setIngresoInicial(int ingresoInicial) {
        this.ingresoInicial = ingresoInicial;
    }

    public Clients getIdClients() {
        return idClients;
    }

    public void setIdClients(Clients idClients) {
        this.idClients = idClients;
    }
}