package com.kitabeli.application.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("classpath:application.properties")
public class DealsConfig {

    @Value( "${deal.minimum.discount}" )
    private int minDiscount;

    @Value("${deal.maximum.discount}")
    private int maxDiscount;

    @Value( "${deal.minimum.count}" )
    private int minDeals;

    @Value( "${deal.expire.time}" )
    private long dealExpireTime;
}
