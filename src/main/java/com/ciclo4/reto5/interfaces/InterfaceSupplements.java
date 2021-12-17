package com.ciclo4.reto5.interfaces;

import com.ciclo4.reto5.modelo.Supplements;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface InterfaceSupplements extends MongoRepository <Supplements, String>{
    public List<Supplements> findByPriceLessThanEqual(double precio);
   
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Supplements> findByDescriptionLike(String description);
}
