/*
package com.liuchao.esdemo.controller;

import com.liuchao.esdemo.entity.User;
import com.liuchao.esdemo.repository.UserRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/adduser")
    public String adduser(){
        User user=new User();
        user.setId(1);
        user.setOpenId("fdsafds");
        user.setUser_name("张三");
        user.setCreate_time(new Date());
        user.setSalt("fdsafdsa");
        userRepository.save(user);
        return "success";
    }

    @RequestMapping("/findById")
    public Optional findById(@RequestParam("id")String id){
        Integer integerId = Integer.valueOf(id);
        return userRepository.findById(integerId);

    }


    //全文搜索
    @RequestMapping("/allfind")
    public List<User> allfind(@RequestParam("key")String key){
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(key);
      //  Pageable Pageable=new PageRequest(1,1,null);
        Iterable<User> searchResult = userRepository.search(builder);
        Iterator<User> iterator = searchResult.iterator();
        List<User> list = new ArrayList<User>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    @RequestMapping("/findlike")
    public void findlike(@RequestParam("name")String name){
        Iterable<User> search = userRepository.search(new MatchQueryBuilder("user_name", name));
        search.forEach(resource -> {
            System.out.println(resource);
           // System.out.println();
        });
    }
}
*/
