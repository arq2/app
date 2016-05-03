package ar.edu.unq.arq2.entities;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ShopRepository {

    @Inject
    private Datastore datastore;

    public Shop save(Shop shop){
        final Key<Shop> productKey = datastore.save(shop);
        shop.setId((String) productKey.getId());
        return shop;
    }

    public Shop find(String id){
        return filterById(id).get();
    }

    public Shop delete(String id){
        return datastore.findAndDelete(filterById(id));
    }

    public List<Shop> findAll(Integer offset, Integer limit) {
        return datastore.find(Shop.class).offset(offset).limit(limit).asList();
    }

    public Shop update(String id, Shop shop){

        final UpdateOperations<Shop> updateOperations = datastore.createUpdateOperations(Shop.class)
                .set("latitude", shop.getLatitude())
                .set("longitude", shop.getLongitude())
                .set("name", shop.getName())
                .set("address", shop.getAddress())
                .set("location", shop.getLocation())
                ;
        final Query<Shop> query = filterById(id);
        datastore.update(query, updateOperations);
        return query.get();
    }

    public long count() {
        return getQuery().countAll();
    }

    private Query<Shop> getQuery() {
        return datastore.createQuery(Shop.class);
    }

    private Query<Shop> filterById(String id) {
        return getQuery().filter("_id ", new ObjectId(id));
    }
}
