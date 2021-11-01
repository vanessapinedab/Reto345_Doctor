/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Retos345_Doctor.Retos345_Doctor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* service
*/
@Service
//clase pública serviciosReservaciones
public class serviciosReservaciones {
    
    /**
* @Autowired
*/
   @Autowired
/**
* variable privada metodoCrud
*/
    private RepositorioReservaciones metodosCrud;
/**
* Método para obtener los datos
*/
    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }
/**
* Método optional
*/
    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
/**
* Método para guardar los datos
*/
    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservaciones> reser= metodosCrud.getReservation(reservation.getIdReservation());
            if(reser.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
/**
* Método para actualizar los datos
*/
    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> reser= metodosCrud.getReservation(reservation.getIdReservation());
            if(!reser.isEmpty()){

                if(reservation.getStartDate()!=null){
                    reser.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    reser.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    reser.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(reser.get());
                return reser.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
/**
* Método para eliminar los datos
*/
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
/**
* Método para realizar reportes
*/
    public StatusReservaciones reporteStatusServicio(){
        List<Reservaciones>completed=metodosCrud.ReservacionStatusRepositorio("completed");
        List<Reservaciones>cancelled=metodosCrud.ReservacionStatusRepositorio("cancelled");
        return new StatusReservaciones(completed.size(), cancelled.size());
    }
/**
* Método para realizar reportes del tiempo
*/
    public List<Reservaciones> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();
/**
* Try
*/
        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
/**
* catch
*/
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }   
    }
/**
* Método para reporte de clientes
*/
    public List<ContadorClientes> reporteClientesServicio() {
        return metodosCrud.getClientesRepositorio();
    }
    
}
