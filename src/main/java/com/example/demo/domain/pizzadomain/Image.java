package com.example.demo.domain.pizzadomain;

import java.util.UUID;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class Image {

    public String asset_id;
    
    public String public_id;
    
    public String url;
}
