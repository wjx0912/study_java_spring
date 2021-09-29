package com.baizhi.service.impl;

import com.baizhi.dao.CityDao;
import com.baizhi.entity.City;
import com.baizhi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("cityService")
public class CityServiceImpl implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<City> queryAll() {
        return this.cityDao.queryAll();
    }

    @Override
    public City insert(City city) {
        this.cityDao.insert(city); //myabtis 插入操作之后
        return city; //city id  name
    }

    @Override
    public City queryById(Integer id) {
        return cityDao.queryById(id);
    }
}
