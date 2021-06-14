package com.eplusing.demo1200.prospring5.ch4.kindergarten;

import com.eplusing.demo1200.prospring5.ch4.Food;
import com.eplusing.demo1200.prospring5.ch4.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eplusing
 * @date 2020/3/2
 */
public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Milk"));
        lunchSet.add(new Food("Biscuits"));
        return lunchSet;
    }
}
