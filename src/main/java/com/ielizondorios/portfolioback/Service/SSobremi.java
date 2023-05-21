
package com.ielizondorios.portfolioback.Service;


import com.ielizondorios.portfolioback.Entity.Sobremi;
import com.ielizondorios.portfolioback.Repository.RSobremi;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SSobremi {
    @Autowired
    RSobremi rSobremi;
    
    public List<Sobremi> list(){
        return rSobremi.findAll();
    }
    public Optional<Sobremi> getOne(int id){
        return rSobremi.findById(id);
    }
    public void save(Sobremi sobremi){
        rSobremi.save(sobremi);
    }
    
    public void delete(int id){
        rSobremi.deleteById(id);
    }
    public boolean existsById(int id){
        return rSobremi.existsById(id);
    }
}
