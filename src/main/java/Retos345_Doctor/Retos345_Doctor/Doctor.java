/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Retos345_Doctor.Retos345_Doctor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
* Entity
*/
@Entity
/**
* nombre de la tabla
*/
@Table(name = "doctor")
/**
* Clase principal
*/
public class Doctor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
/**
* definicipon de la variable id
*/
    private Integer id;
/**
* definicipon de la variable name
*/
    private String name;
/**
* definicipon de la variable department
*/
    private String department;
/**
* definicipon de la variable year
*/
    private Integer year;
/**
* definicipon de la variable description
*/
    private String description;
/**
* Relación de muchos a 1
*/
    @ManyToOne
    @JoinColumn(name = "specialtyId")
    @JsonIgnoreProperties("doctors")
    private Especialidad specialty;
/**
* Relación de 1 a muchos
*/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<Mensaje> messages;
/**
* Relación de 1 a muchos
*/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<Reservaciones> reservations;

    /**
     * Métodos getter and setter
     */
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Especialidad getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Especialidad specialty) {
        this.specialty = specialty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservaciones> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
    
}
