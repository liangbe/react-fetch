package com.bee.fetch.service.impl;

import com.bee.fetch.dao.PropertyDao;
import com.bee.fetch.entity.Property;
import com.bee.fetch.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liangbe on 2017/12/13.
 */
@Service
public class PropertyServiceImpl extends CRUDServiceImpl<Property,Long> implements PropertyService {

    @Autowired
    PropertyDao propertyDao;

    @Override
    public PropertyDao getDao() {
        return propertyDao;
    }



}
