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

    public FoundPrice save(FoundPrice foundPrice){
        final Key<FoundPrice> productKey = datastore.save(foundPrice);
        foundPrice.setId((String) productKey.getId());
        return foundPrice;
    }

    public FoundPrice find(String id){
        return getQuery().filter("_id ", new ObjectId(id)).get();
    }

    public FoundPrice delete(String id){
        return datastore.findAndDelete(getQuery().filter("_id ", new ObjectId(id)));
    }

    public List<FoundPrice> findAll(Integer offset, Integer limit) {
        return datastore.find(FoundPrice.class).offset(offset).limit(limit).asList();
    }

    public FoundPrice update(String id, FoundPrice foundPrice){
        final UpdateOperations<FoundPrice> updateOperations = datastore.createUpdateOperations(FoundPrice.class)
                .set("shop_id", foundPrice.getShop_id())
                .set("product_id", foundPrice.getProduct_id())
                .set("price", foundPrice.getPrice())
                .set("datetime", foundPrice.getDatetime())

                ;
        final Query<FoundPrice> query = getQuery().filter("_id ", new ObjectId(id));
        datastore.update(query, updateOperations);
        return query.get();
    }

    public Long count() {
        return getQuery().countAll();
    }

    private Query<FoundPrice> getQuery() {
        return datastore.createQuery(FoundPrice.class);
    }
}
