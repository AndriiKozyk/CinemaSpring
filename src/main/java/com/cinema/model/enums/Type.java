package com.cinema.model.enums;

import java.math.BigDecimal;

public enum Type {

    STANDARD,
    LUX,
    SUPER_LUX;

    BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
