package com.kitabeli.application.util;

import com.kitabeli.application.service.DealsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Configuration
@EnableScheduling
@PropertySource("classpath:application.properties")
public class DealsScheduler {

    @Autowired
    private DealsService activeDealsService;

    @Scheduled(initialDelayString = "${initialDelay.in.milliseconds}" , fixedRateString = "${fixedRate.in.milliseconds}")
    public void refreshDeals() {

        log.info("Refreshing deals..................");
        activeDealsService.refreshDeals();
        log.info("Successfully refreshed deals");
    }

}
