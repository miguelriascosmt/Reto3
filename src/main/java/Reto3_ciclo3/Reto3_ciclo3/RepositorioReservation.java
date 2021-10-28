package Reto3_ciclo3.Reto3_ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservation {
     @Autowired
    private InterfaceReservation crud4;
    
    
    public List<Reservation> getAll(){
        return (List<Reservation>) crud4.findAll();
    }
    
    public Optional <Reservation> getReservation (int id){
        return crud4.findById(id);
    }
    
    public Reservation save (Reservation reservation){
        return crud4.save(reservation);
    }
    
    public void delete (Reservation reservation){
        crud4.delete(reservation);
    }
}