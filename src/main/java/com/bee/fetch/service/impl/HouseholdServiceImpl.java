package com.bee.fetch.service.impl;

import com.bee.fetch.dao.HouseholdDao;
import com.bee.fetch.entity.Household;
import com.bee.fetch.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liangbe on 2017/12/13.
 */
@Service
public class HouseholdServiceImpl extends CRUDServiceImpl<Household,Long> implements HouseholdService {

    @Autowired
    HouseholdDao householdDao;

    @Override
    public HouseholdDao getDao() {
        return householdDao;
    }



}
