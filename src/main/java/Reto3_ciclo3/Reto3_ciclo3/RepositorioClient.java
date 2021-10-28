package Reto3_ciclo3.Reto3_ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClient {
    
    @Autowired
    private InterfaceClient crud1;
    
    
    public List<Client> getAll(){
        return (List<Client>) crud1.findAll();
    }
    
    public Optional <Client> getClient (int clientId){
        return crud1.findById(clientId);
    }
    
    public Client save (Client client){
        return crud1.save(client);
    }
    
    public void delete (Client client){
        crud1.delete(client);
    }
    
}