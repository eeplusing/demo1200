package com.eplusing.prospring5.ch4.highshchool;

import com.eplusing.prospring5.ch4.Food;
import com.eplusing.prospring5.ch4.FoodProviderService;

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
        lunchSet.add(new Food("Coke"));
        lunchSet.add(new Food("Hambueger"));
        lunchSet.add(new Food("French Fries"));
        return lunchSet;
    }
}
