package org.example;
public class Main {
    public static void main(String[] args) {
        //INTRODUCIR NUEVO CLIENTE
        Cliente cliente1 = new Cliente(1L, "Carlos", 10L, "Activo");
        Cliente cliente2 = new Cliente(2L, "Raul", 20L, "Inactivo");
        Cliente cliente3 = new Cliente(3L, "Carmen", 30L, "Activo");
        Cliente cliente4 = new Cliente(4L, "Alejandro", 40L, "Inactivo");
        Cliente cliente5 = new Cliente(5L, "Leo", 50L, "Activo");

 try {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.insertarCliente(cliente1);
        clienteDAO.insertarCliente(cliente2);
        clienteDAO.insertarCliente(cliente3);
        clienteDAO.insertarCliente(cliente4);
        clienteDAO.insertarCliente(cliente5);

        //MOSTRAR POR CONSOLA LA INFORMACION DE UN UNICO CLIENTE
        System.out.println("UNICO CLIENTE " + clienteDAO.getCliente(1L));

        //MOSTRAR LOS CLIENTES ACTIVOS QUE TENGAN UN TOTAL DE VENTAS MAYOR A UNA CANTIDAD CONCRETA
        System.out.println("MEJORES CLIENTES " + clienteDAO.listarMejoresClientes(10L));

        //MOSTRAR POR CONSOLA EL RESUMEN ESTADISTICO INDICANDO
        //TOTAL VENTAS
        //PROMEDIO DE VENTAS DE LOS CLIENTES ACTIVOS
        //CANTIDAD DE CLIENTES INACTIVOS QUE TIENEN TOTAL DE VENTAS MAYOR A 0
        System.out.println(clienteDAO.estadisticas());


    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
}