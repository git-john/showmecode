package com.myspring.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class BlogProperties {

    @Getter
    @Value("${mrbird.blog.name}")
    private String name;

    @Value("${mrbird.blog.title}")
    private String title;
}
