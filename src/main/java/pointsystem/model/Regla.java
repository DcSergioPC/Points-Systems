package pointsystem.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

// 3) Administracióndereglasdeasignación depuntos
//  Este módulo permite definir las reglas que rigen la cantidad de puntos a asignar a un cliente
//  en base al rango de valor de consumo:
// Ejemplo:
//  o 0 a 199.999Gs.: 1 punto cada 50.000
//  o 200.000Gs. a 499.999Gs. 1 punto cada 30.000
//  o 500.000Gs. para arriba: 1 punto cada 20.000
//  Observación: los rangos serán opcionales, es decir, se puede tener una sola regla que asigne 1
//  punto cada X Gs. sin importar en qué rango cae el monto de la operación.
//  Estructura: id autogenerado, limite inferior, límite superior, monto de equivalencia de 1
//  punto
@Entity
@Table(name = "regla")
public class Regla {
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
    @Column(name = "limite_inferior")
    private java.math.BigInteger limiteInf;

    @Basic(optional = false)
    @Column(name = "limite_superior")
    private java.math.BigInteger limiteSup;
    
    @Basic(optional = false)
    @Column(name = "monto")
    private java.math.BigInteger monto;
}