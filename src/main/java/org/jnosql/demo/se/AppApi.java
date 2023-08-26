package org.jnosql.demo.se;

import com.github.javafaker.Faker;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.Template;
import org.eclipse.jnosql.mapping.DatabaseQualifier;

public class AppApi {

    public static void main(String[] args) {

        Faker faker=new Faker();
        try(SeContainer container= SeContainerInitializer.newInstance().initialize()){

            Template template=container.select(Template.class, DatabaseQualifier.ofDocument()).get();

            for(int i=0;i<10;i++){
                var dev = Developer.build(faker);
                template.insert(dev);
            }

            System.out.println(template.select(Developer.class).result());

        }

    }
}
