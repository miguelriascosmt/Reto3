
package Reto3_ciclo3.Reto3_ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class serviciosRoom {
    @Autowired
    private RepositorioRoom metodoCrud;
    
    public List<Room> getAll(){
        return metodoCrud.getAll();
    }
    
    public Optional<Room> getRoom(int roomId){
        return metodoCrud.getRoom(roomId);
    }
    
    public Room save(Room room){
        if (room.getId()==null){
            return metodoCrud.save(room);
        }else{
            Optional<Room> e=metodoCrud.getRoom(room.getId());
            if (e.isEmpty()){
            return metodoCrud.save(room);    
                
        }else{
            return room;
            }
        }
    
}
    public Room update(Room room){
        if(room.getId()!=null){
            Optional<Room> e=metodoCrud.getRoom(room.getId());
            if(!e.isEmpty()){
                if(room.getName()!=null){
                    e.get().setName(room.getName());
                }
                if(room.getHotel()!=null){
                    e.get().setHotel(room.getHotel());
                }
                if(room.getStars()!=null){
                    e.get().setStars(room.getStars());
                }
                if(room.getDescription()!=null){
                    e.get().setDescription(room.getDescription());
                }
                if(room.getCategory()!=null){
                    e.get().setCategory(room.getCategory());
                }
                metodoCrud.save(e.get());
                return e.get();
            }else{
                return room;
            }
        }else{
            return room;
        }
    }


    public boolean deleteRoom(int roomId) {
        Boolean aBoolean = getRoom(roomId).map(room -> {
            metodoCrud.delete(room);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

