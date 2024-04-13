package pointsystem.model;

import jakarta.persistence.*;

// 1) Administración de datos del cliente
//  Este módulo contempla la administración de datos del cliente, los cuales serán los que
//  acumulen puntos de fidelidad con sus operaciones.
//  Los datos de clientes a almacenar serán los siguientes: nombre, apellido, número de
//  documento, tipo de documento, nacionalidad, email, teléfono, fecha de nacimiento.
//  Estructura: id autogenerado, nombre, apellido, número de documento, tipo de documento,
//  nacionalidad, email, teléfono, fecha de nacimiento.
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Basic(optional = false)
    @Column(name = "id_cliente")
    @GeneratedValue(generator = "clienteSec")
    @SequenceGenerator(name = "clienteSec",sequenceName = "cliente_sec",allocationSize = 0)
    private Integer idCliente;

    @Basic(optional = false)
    @Column(name = "nombre", length = 50)
    private String nombre;

    @Basic(optional = false)
    @Column(name = "apellido", length = 50)
    private String apellido;

    @Basic(optional = false)
    @Column(name = "ci", length = 13,unique = true)
    private String cedula;

    @Basic(optional = false)
    @Column(name = "tipo", length = 50)
    private String tipo;
    
    @Basic(optional = true)
    @Column(name = "nacionalidad", length = 50)
    private String nacionalidad;

    @Basic(optional = false)
    @Column(name = "email", length = 50)
    private String email;

    @Basic(optional = true)
    @Column(name = "telefono", length = 20)
    private String telefono;

    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    private java.sql.Date fechaNacimiento;

    public Cliente() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public java.util.Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(java.sql.Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}