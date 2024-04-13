package pointsystem.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

// 4)  Parametrización de vencimientos de puntos
//  Este módulo permite definir el tiempo de validez de los puntajes asignados a los clientes. Una
//  vez alcanzado el tiempo determinado, los puntos son descontados de la bolsa por
//  vencimiento.
//  Estructura: id autogenerado, fecha de inicio de validez, fecha fin de validez, días de
//  duración del puntaje.

@Entity
@Table(name = "regla")
public class Vencimiento {
    @Id
    @Basic(optional = false)
    @Column(name = "id_vencimiento")
    @GeneratedValue(generator = "vencimientoSec")
    @SequenceGenerator(name = "vencimientoSec",sequenceName = "vencimiento_sec",allocationSize = 0)
    private Integer idConcepto;

    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    private java.sql.Date fechaInicio;

    @Basic(optional = false)
    @Column(name = "fecha_fin")
    private java.sql.Date fechaFin;
    
    @Basic(optional = false)
    @Column(name = "duracion")
    private java.math.BigInteger duracion;
}