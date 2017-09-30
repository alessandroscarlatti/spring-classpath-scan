package com.scarlatti

import com.scarlatti.animals.Animal
import groovy.util.logging.Slf4j

/**
 * Created by pc on 9/8/2017.
 */
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.context.annotation.Configuration
import org.springframework.core.type.filter.AssignableTypeFilter

@SpringBootApplication
@Configuration
@Slf4j
class App implements CommandLineRunner {

    static void main(String[] args) {
        SpringApplication.run(App.class, args)
    }

    @Override
    void run(String... args) throws Exception {
        ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false)
        provider.addIncludeFilter(new AssignableTypeFilter(Animal.class))

        Set<BeanDefinition> defs = provider.findCandidateComponents(Animal.class.package.name)
        println(defs)
    }
}