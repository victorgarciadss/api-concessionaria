package com.api.dealership.projections;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface SoldCarProjection {
    String getClientName();
    String getCarName();
    String getCarBrand();
    BigDecimal getSaleValue();
    LocalDateTime getSaleDate();
}
