package ar.edu.unq.arq2.entities;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Shop {

    @Id
    private String id;
    private Double latitude;
    private Double longitude;
    private String name;
    private String address;
    private String location;

    public Shop() {}

    public static Builder newShop() {
        return new Builder();
    }

    private Shop(Builder builder) {
        setId(builder.id);
        setLatitude(builder.latitude);
        setLongitude(builder.longitude);
        setName(builder.name);
        setAddress(builder.address);
        setLocation(builder.location);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static final class Builder {
        private String id;
        private Double latitude;
        private Double longitude;
        private String name;
        private String address;
        private String location;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }
        public Builder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Shop build() {
            return new Shop(this);
        }
    }
}
