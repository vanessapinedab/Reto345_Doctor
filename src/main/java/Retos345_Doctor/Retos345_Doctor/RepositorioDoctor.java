/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Retos345_Doctor.Retos345_Doctor;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class RepositorioDoctor {
    
    @Autowired
    private InterfaceDoctor crud;

    public List<Doctor> getAll(){
        return (List<Doctor>) crud.findAll();
    }

    public Optional<Doctor> getDoctor(int id){
        return crud.findById(id);
    }

    public Doctor save(Doctor doctor){
        return crud.save(doctor);
    }
    public void delete(Doctor doctor){
        crud.delete(doctor);
    }
    
}
