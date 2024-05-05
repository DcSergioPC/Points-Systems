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

// 6) Uso de puntos
//  Debe utilizarse en un esquema FIFO (primero se utilizan las bolsas más antiguas). Tiene un
//  detalle debido a que para satisfacer una petición de puntos se puede utilizar más de una bolsa.
//  Estructura:
// Cabecera: id autogenerado, identificador del cliente, puntaje utilizado, fecha,
//  concepto de uso de punto

@Entity
@Table(name = "usoPuntos")
public class UsoPuntos {
    @Id
    @Basic(optional = false)
    @Column(name = "id_usoPuntos")
    @GeneratedValue(generator = "usoPuntosSec")
    @SequenceGenerator(name = "usoPuntosSec",sequenceName = "usoPuntos_sec",allocationSize = 0)
    private Integer idUsoPuntos;

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
}