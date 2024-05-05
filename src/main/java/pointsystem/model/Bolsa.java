package pointsystem.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

// 5) Bolsa de puntos
//  Estructura: id autogenerado, identificador del cliente, fecha de asignación de puntaje, fecha
//  de caducidad de puntaje, puntaje asignado, puntaje utilizado, saldo de puntos, monto de la
//  operación

@Entity
@Table(name = "bolsa")
public class Bolsa {
    @Id
    @Basic(optional = false)
    @Column(name = "id_bolsa")
    @GeneratedValue(generator = "bolsaSec")
    @SequenceGenerator(name = "bolsaSec",sequenceName = "bolsa_sec",allocationSize = 0)
    private Integer idConcepto;
    
    // Definición de la clave foránea
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @Basic(optional = false)
    @Column(name = "fecha_asignacion")
    private java.sql.Date fechaAsignacion;
    
    @Basic(optional = false)
    @Column(name = "fecha_caducidad")
    private java.sql.Date fechaCaducidad;

    @Basic(optional = false)
    @Column(name = "puntaje")
    private java.math.BigInteger puntaje;
    
    @Basic(optional = false)
    @Column(name = "saldo")
    private java.math.BigInteger saldo;
    
    @Basic(optional = false)
    @Column(name = "monto")
    private java.math.BigInteger monto;

    public Integer getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public java.sql.Date getFechaAsignacion() { 
        return fechaAsignacion;
    }

    public void setFechaAsignacion(java.sql.Date fechaAsignacion) { 
        this.fechaAsignacion = fechaAsignacion;
    }

    public java.sql.Date getFechaCaducidad() {  
        return fechaCaducidad;
    }

    public void setFechaCaducidad(java.sql.Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public java.math.BigInteger getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(java.math.BigInteger puntaje) {
        this.puntaje = puntaje;
    }

    public java.math.BigInteger getSaldo() {
        return saldo;
    }

    public void setSaldo(java.math.BigInteger saldo) {
        this.saldo = saldo;
    }

    public java.math.BigInteger getMonto() {
        return monto;
    }

    public void setMonto(java.math.BigInteger monto) {
        this.monto = monto;
    }
}