package org.example;

import java.util.List;

public interface DAO<T>{
    Cliente insertarCliente(T t);

    Cliente getCliente(Long id);

    List<Cliente> listarMejoresClientes(Long cantidad);

    String estadisticas();
}
