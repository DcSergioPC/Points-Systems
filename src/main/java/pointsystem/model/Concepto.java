package pointsystem.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

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
}