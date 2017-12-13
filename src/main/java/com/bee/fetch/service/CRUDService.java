package com.bee.fetch.service;

/**
 * Created by liangbe on 2017/12/13.
 */

import java.io.Serializable;
import java.util.List;

public interface CRUDService <T,ID extends Serializable>{

    List<T> findAll();

    <S extends T> S save(S entity);

    T findOne(ID id);

    void delete(ID id);

    void delete(T entity);

    void deleteAll();

}
