/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author maribelmoreno
 */
public class Aspirante {
    private String cedula;
    private String nombrecompleto;
    private int edad;
    private int experiencia;
    private String profesion;
    private String telefono;
 
    public Aspirante() {}

    public Aspirante(String cedula, String nombreCompleto, int edad, int experiencia, String profesion, String telefono) {
        this.cedula = cedula;
        this.nombrecompleto = nombreCompleto;
        this.edad = edad;
        this.experiencia = experiencia;
        this.profesion = profesion;
        this.telefono = telefono;
    }

    // Getters y setters para los atributos
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    
    public String getNombreCompleto() { return nombrecompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombrecompleto = nombreCompleto; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public int getExperiencia() { return experiencia; }
    public void setExperiencia(int experiencia) { this.experiencia = experiencia; }

    public String getProfesion() { return profesion; }
    public void setProfesion(String profesion) { this.profesion = profesion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
}
