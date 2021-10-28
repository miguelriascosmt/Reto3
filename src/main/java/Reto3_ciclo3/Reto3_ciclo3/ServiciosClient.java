
package Reto3_ciclo3.Reto3_ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosClient {
    @Autowired
    private RepositorioClient metodoCrud;
    
    public List<Client> getAll(){
        return metodoCrud.getAll();
    }
    
    public Optional<Client> getClient(int clientId){
        return metodoCrud.getClient(clientId);
    }
    
    public Client save(Client client){
        if (client.getIdClient()==null){
            return metodoCrud.save(client);
        }else{
            Optional<Client> e=metodoCrud.getClient(client.getIdClient());
            if (e.isEmpty()){
            return metodoCrud.save(client);    
                
        }else{
            return client;
            }
        }
    
}
    public Client update (Client client){
        if (client.getIdClient()!=null){
            Optional <Client> e = metodoCrud.getClient(client.getIdClient());
            if (!e.isEmpty()){
                if (client.getName()!=null){
                    e.get().setName(client.getName());
                }
                
                if (client.getEmail()!=null){
                    e.get().setEmail(client.getEmail());
                }
                
                if (client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                
                if (client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                
                metodoCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
        
            
    }
    
    public boolean deleteClient(int clientId){
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodoCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
