package org.example;

import lombok.Getter;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObjectDBUtil {

    // La instancia estática de EntityManagerFactory para la aplicación.
    @Getter
    private final static EntityManagerFactory entityManagerFactory;

    static {
        // Se inicializa la EntityManagerFactory al cargar la clase.
        entityManagerFactory = Persistence.createEntityManagerFactory("data.odb");
    }
}
