package org.jnosql.demo.se;

import com.github.javafaker.Faker;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.Template;
import org.eclipse.jnosql.mapping.DatabaseQualifier;

import java.util.UUID;

public class AppData {

    public static void main(String[] args) {

        Faker faker = new Faker();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            JavaDay javaDay = container.select(JavaDay.class,DatabaseQualifier.ofDocument()).get();

            for (int i = 0; i < 10; i++) {
                var dev = Developer.build(faker);
                javaDay.save(dev);
            }

            javaDay.save(new Developer(UUID.randomUUID().toString(), "Yugo Sakamoto", "São Paulo"));

            System.out.println(javaDay.findAll().toList());

            System.out.println("pessoas de Lake Benny : " + javaDay.findByCity("Lake Benny").toList());

            System.out.println("CadÊ o Yugo : " + javaDay.cadeYugo());

        }

    }
}
