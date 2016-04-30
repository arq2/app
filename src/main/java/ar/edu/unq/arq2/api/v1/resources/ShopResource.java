package ar.edu.unq.arq2.api.v1.resources;

import javax.validation.constraints.NotNull;

public class ShopResource {

    private String id;

    @NotNull(message = "name cannot be null")
    private String name;

    private String address;

    @NotNull(message = "location cannot be null")
    private String location;

    private Double latitude;

    private Double longitude;

    public ShopResource() {
    }

    private ShopResource(BuilderShop builder) {
       setId(builder.id);
        setAddress(builder.address);
        setLocation(builder.location);
        setLatitude(builder.latitude);
        setLongitude(builder.longitude);
    }

    public static BuilderShop newShopResource() {
        return new BuilderShop();
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


    /////////////////////////////////////////////////////////////////////

    public static final class BuilderShop {

        private String id;
        private Double latitude;
        private Double longitude;
        private String name;
        private String address;
        private String location;

        private BuilderShop() {
        }

        public BuilderShop id(String id) {
            this.id = id;
            return this;
        }

        public BuilderShop name(String name) {
            this.name = name;
            return this;
        }

        public BuilderShop address(String address) {
            this.address = address;
            return this;
        }
        public BuilderShop location(String location) {
            this.location = location;
            return this;
        }
        public BuilderShop latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public BuilderShop longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }



        public ShopResource build() {
            return new ShopResource(this);
        }
    }
}
