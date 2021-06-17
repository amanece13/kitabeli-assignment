package com.kitabeli.application.service;

import com.kitabeli.application.entity.Deal;
import com.kitabeli.application.model.DealModel;

import java.util.List;

public interface DealsService {

    public List<DealModel> fetchDeals(String status);

    public void refreshDeals();
}
