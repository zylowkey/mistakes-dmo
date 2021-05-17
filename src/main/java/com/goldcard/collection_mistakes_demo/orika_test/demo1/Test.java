package com.goldcard.collection_mistakes_demo.orika_test.demo1;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
@Slf4j
public class Test {
    public static void main(String[] args) {
        //对象复制
        //常规方法
        User A = new User().setId("123").setName("123");
        UserVo B = new UserVo().setId(A.getId()).setName(A.getName());
        log.info("常规方法复制结果B==>{}",B);

        //orika复制
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        UserVo userVo = mapperFactory.getMapperFacade().map(A,UserVo.class);
        log.info("orika复制结果userVo==>{}",userVo);
    }
}
