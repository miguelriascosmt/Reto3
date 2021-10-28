package Reto3_ciclo3.Reto3_ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMessage {
    @Autowired
    private RepositorioMessage metodoCrud;
    
    public List<Message> getAll(){
        return metodoCrud.getAll();
    }
    
    public Optional<Message> getMessage(int idMessage){
        return metodoCrud.getMessage(idMessage);
    }
    
    public Message save(Message message){
        if (message.getIdMessage()==null){
            return metodoCrud.save(message);
        }else{
            Optional<Message> e=metodoCrud.getMessage(message.getIdMessage());
            if (e.isEmpty()){
            return metodoCrud.save(message);    
                
        }else{
            return message;
            }
        }
    
}
    public Message update (Message message){
        if (message.getIdMessage()!=null){
            Optional <Message> e = metodoCrud.getMessage(message.getIdMessage());
            if (!e.isEmpty()){
                if (message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodoCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
        
            
    }
    
    public boolean deleteMessage(int messageId){
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodoCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}