package com.demo.jvm;

import lombok.Data;


@Data
public class ResearchMethod {
    public Long id;
    public String nameDB;
    public String name;
    public String nameZh;
    public String description;
    public String descriptionZh;
    public Boolean blocked;
}
