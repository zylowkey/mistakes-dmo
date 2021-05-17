package com.goldcard.collection_mistakes_demo.orika_test.demo2;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserVo {
    private String id;
    private String name;
    private int age;
}
