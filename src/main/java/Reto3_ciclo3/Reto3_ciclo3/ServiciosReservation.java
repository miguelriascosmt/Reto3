package Reto3_ciclo3.Reto3_ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosReservation {
    @Autowired
    private RepositorioReservation metodoCrud;
    
    public List<Reservation> getAll(){
        return metodoCrud.getAll();
    }
    
    public Optional<Reservation> getReservation(int idReservation){
        return metodoCrud.getReservation(idReservation);
    }
    
    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null){
            return metodoCrud.save(reservation);
        }else{
            Optional<Reservation> e=metodoCrud.getReservation(reservation.getIdReservation());
            if (e.isEmpty()){
            return metodoCrud.save(reservation);    
                
        }else{
            return reservation;
            }
        }
    
}
    public Reservation update (Reservation reservation){
        if (reservation.getIdReservation()!=null){
            Optional <Reservation> e = metodoCrud.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()){
                if (reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                
                if (reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                
                if (reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                
                metodoCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
        
            
    }
    
    public boolean deleteReservation(int reservationId){
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodoCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
