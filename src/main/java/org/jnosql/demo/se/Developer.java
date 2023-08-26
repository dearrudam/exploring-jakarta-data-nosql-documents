package org.jnosql.demo.se;

import com.github.javafaker.Faker;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.UUID;

@Entity
public record Developer(@Id String id, @Column String name,@Column String city) {

    public static Developer build(Faker faker){
        return new Developer(
                UUID.randomUUID().toString(),
                faker.name().fullName(),
                faker.address().cityName());
    }

}
