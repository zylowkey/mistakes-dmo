package com.goldcard.collection_mistakes_demo.orika_test.demo2;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
 * mapperFactory.getMapperFacade().map(操作对象)
 * mapperFactory.getMapperFacade().mapAsList(操作集合对象)
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        //集合复制--常规方法
        List<User> A = Arrays.asList(new User().setId("123").setName("2341"));
        List<UserVo> B = new ArrayList<>();
        A.forEach(x->{
            B.add(new UserVo().setId(x.getId()).setName(x.getName()));
        });
        log.info("常规方法复制结果B==>{}",B);

        //集合复制--orika
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        List<UserVo> userVo = mapperFactory.getMapperFacade().mapAsList(A,UserVo.class);
        log.info("orika复制结果userVo==>{}",userVo);


    }
}
