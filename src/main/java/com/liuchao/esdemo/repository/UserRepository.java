/*
package com.liuchao.esdemo.repository;

import com.liuchao.esdemo.entity.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User,Integer> {
    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"salt\" : \"?0\"}}}}")
    public List<User> findBySalt(String name);
}
*/
