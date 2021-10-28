
package Reto3_ciclo3.Reto3_ciclo3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class serviciosCategory {
    @Autowired
    private RepositorioCategory metodoCrud;
    
    public List<Category> getAll(){
        return metodoCrud.getAll();
    }
    
    public Optional<Category> getCategory(int categoryid){
        return metodoCrud.getCategory(categoryid);
    }
    
    public Category save(Category category){
        if (category.getId()==null){
            return metodoCrud.save(category);
        }else{
            Optional<Category> categoria1=metodoCrud.getCategory(category.getId());
            if (categoria1.isEmpty()){
            return metodoCrud.save(category);    
                
        }else{
            return category;
            }
        }
    
    }
    
    public Category update (Category category){
        if (category.getId()!=null){
            Optional <Category> g = metodoCrud.getCategory(category.getId());
            if (!g.isEmpty()){
                if (category.getName()!=null){
                    g.get().setName(category.getName());
                }
                
                if (category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                
                return metodoCrud.save(g.get());
                
            }
        }
        
            return category;
        
    }
    
    public boolean deleteCategory(int categoryId){
        Boolean d = getCategory(categoryId).map(category -> {
            metodoCrud.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}
