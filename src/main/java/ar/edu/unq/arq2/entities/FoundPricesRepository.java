package ar.edu.unq.arq2.entities;


import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import javax.inject.Inject;
import java.util.List;

public class FoundPricesRepository {


    @Inject
    private Datastore datastore;

    public FoundPrices save(FoundPrices foundPrices){
        final Key<FoundPrices> productKey = datastore.save(foundPrices);
        foundPrices.setId((String) productKey.getId());
        return foundPrices;
    }

    public FoundPrices find(String id){
        return datastore.createQuery(FoundPrices.class).filter("_id ", new ObjectId(id)).get();
    }

    public FoundPrices delete(String id){
        return datastore.findAndDelete(datastore.createQuery(FoundPrices.class).filter("_id ", new ObjectId(id)));
    }

    public List findAll(){
        return datastore.find(FoundPrices.class).asList();
    }

    public FoundPrices update(String id, FoundPrices foundPrices){
        final UpdateOperations<FoundPrices> updateOperations = datastore.createUpdateOperations(FoundPrices.class)
                .set("shop_id", foundPrices.getShop_id())
                .set("product_id",foundPrices.getProduct_id())
                .set("price", foundPrices.getPrice())
                .set("datetime", foundPrices.getDatetime())

                ;
        final Query<FoundPrices> query = datastore.createQuery(FoundPrices.class).filter("_id ", new ObjectId(id));
        datastore.update(query, updateOperations);
        return query.get();
    }
}
