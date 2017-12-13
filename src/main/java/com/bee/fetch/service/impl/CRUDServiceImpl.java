package com.bee.fetch.service.impl;

import com.bee.fetch.dao.BaseDao;
import com.bee.fetch.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


/**
 * Created by liangbe on 2017/12/13.
 */

@Transactional
public abstract class CRUDServiceImpl <T,ID extends Serializable> implements CRUDService<T,ID> {


    @Autowired
    public abstract BaseDao<T,ID> getDao();

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }



    @Override
    public <S extends T> S save(S entity) {
        S result=(S)getDao().saveAndFlush(entity);
        return result;
    }


    @Override
    public T findOne(ID id) {
        return (T)getDao().findOne(id);
    }

    @Override
    public void delete(ID id) {
        getDao().delete(id);
        getDao().flush();
    }

    @Override
    public void delete(T entity) {
        getDao().delete(entity);
        getDao().flush();
    }


    @Override
    public void deleteAll() {
        getDao().deleteAll();
        getDao().flush();
    }

}
