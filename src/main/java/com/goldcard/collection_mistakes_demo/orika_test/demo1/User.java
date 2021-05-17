package com.goldcard.collection_mistakes_demo.orika_test.demo1;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private String id;
    private String name;
    private int sex;
}
