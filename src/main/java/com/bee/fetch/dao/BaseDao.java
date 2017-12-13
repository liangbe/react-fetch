package com.bee.fetch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by liangbe on 2017/12/13.
 */
@NoRepositoryBean
public interface BaseDao<T, ID extends Serializable> extends JpaRepository<T, ID>,
        JpaSpecificationExecutor<T> {
}
