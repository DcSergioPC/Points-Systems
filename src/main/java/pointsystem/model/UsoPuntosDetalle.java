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

// Detalle: id autogenerado, identificador de la cabecera, puntaje utilizado, identificador
//  de la bolsa de puntos utilizada

@Entity
@Table(name = "usoPuntosDetalle")
public class UsoPuntosDetalle {
    @Id
    @Basic(optional = false)
    @Column(name = "id_usoPuntosDetalle")
    @GeneratedValue(generator = "usoPuntosDetalleSec")
    @SequenceGenerator(name = "usoPuntosDetalleSec",sequenceName = "usoPuntosDetalle_sec",allocationSize = 0)
    private Integer idUsoPuntosDetalle;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;
    
    @Basic(optional = false)
    @Column(name = "puntosUtilizados")
    private java.math.BigInteger puntosUtilizados;
    
    @Basic(optional = false)
    @Column(name = "fecha")
    private java.sql.Date fecha;

    @Basic(optional = false)
    @Column(name = "conceptoUso", length = 250)
    private String conceptoUso;

    public Integer getIdUsoPuntosDetalle() {
        return idUsoPuntosDetalle;
    }

    public void setIdUsoPuntosDetalle(Integer idUsoPuntosDetalle) {
        this.idUsoPuntosDetalle = idUsoPuntosDetalle;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public java.math.BigInteger getPuntosUtilizados() {
        return puntosUtilizados;
    }

    public void setPuntosUtilizados(java.math.BigInteger puntosUtilizados) {
        this.puntosUtilizados = puntosUtilizados;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public String getConceptoUso() {
        return conceptoUso;
    }

    public void setConceptoUso(String conceptoUso) {
        this.conceptoUso = conceptoUso;
    }
}