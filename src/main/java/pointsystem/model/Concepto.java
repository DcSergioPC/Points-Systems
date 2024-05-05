package pointsystem.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

// 2) Administracióndeconceptosdeusodepuntos
//  Este módulo contempla la administración de los diferentes conceptos que especifican a qué
//  fueron destinados los puntos utilizados, con su respectiva cantidad de puntos requerida. Por
//  ejemplo: vale de premio, vale de descuento, vale de consumición, etc.
//  Estructura: id autogenerado, descripción de concepto, puntos requeridos.
@Entity
@Table(name = "concepto")
public class Concepto {
    @Id
    @Basic(optional = false)
    @Column(name = "id_concepto")
    @GeneratedValue(generator = "conceptoSec")
    @SequenceGenerator(name = "conceptoSec",sequenceName = "concepto_sec",allocationSize = 0)
    private Integer idConcepto;

    @Basic(optional = false)
    @Column(name = "descripcion", length = 250)
    private String descripcion;
    
    @Basic(optional = false)
    @Column(name = "puntos")
    private java.math.BigInteger puntos;

    public Integer getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getDescripcion() {    
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public java.math.BigInteger getPuntos() {
        return puntos;
    }

    public void setPuntos(java.math.BigInteger puntos) {
        this.puntos = puntos;
    }
}