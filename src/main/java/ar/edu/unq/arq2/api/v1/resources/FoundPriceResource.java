package ar.edu.unq.arq2.api.v1.resources;

import javax.validation.constraints.NotNull;

public class FoundPriceResource {

    private String id;

    @NotNull(message = "shop id cannot be null")
    private String shop_id;

    @NotNull(message = "product id cannot be null")
    private String product_id;

    @NotNull(message = "price cannot be null")
    private Double price;

    @NotNull(message = "datetime cannot be null")
    private String datetime;

    public FoundPriceResource() {
    }

    private FoundPriceResource(Builder builder) {
        setId(builder.id);
        setShop_id(builder.shop_id);
        setProduct_id(builder.product_id);
        setPrice(builder.price);
        setDatetime(builder.datetime);
    }

    public static Builder newFoundPricesResource() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////77


    public static final class Builder {
        private String id;
        private String shop_id;
        private String product_id;
        private Double price;
        private String datetime;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder shop_id(String shop_id) {
            this.shop_id = shop_id;
            return this;
        }

        public Builder product_id(String product_id) {
            this.product_id = product_id;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Builder datetime(String datetime) {
            this.datetime = datetime;
            return this;
        }

        public FoundPriceResource build() {
            return new FoundPriceResource(this);
        }
    }
}
