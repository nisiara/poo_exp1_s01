
package com.bankboston.entidades;

import java.util.Scanner;

public class Banco {
  
  Scanner inputUsuario = new Scanner(System.in);
  
  Cuenta cuentaCliente = new Cuenta();
  
  // ATRIBUTOS
  private String nombre = "bank boston";
  private Cliente cliente = new Cliente() ;
  
  // CONSTRUCTOR
  public Banco(){};
  
    // GETTERS & SETTERS
  public Cliente getCliente() {
    return this.cliente;
  }

  public String getNombre() {
    return this.nombre;
  }
  
  // METODOS
  public void registrarCliente(){       
    String rutRegistro;
    String nombreRegistro;
    String apellidoPaternoRegistro;
    String apellidoMaternoRegistro;
    String domicilioRegistro;
    String comunaRegistro;
    String telefonoRegistro;
    String numeroCuentaRegistro;

    System.out.println("Ingresa el RUT del cliente. (Con puntos y guión)");
    rutRegistro = inputUsuario.next();
    cliente.setRut(rutRegistro);
    inputUsuario.nextLine();

    System.out.println("Ingresa el nombre del cliente");
    nombreRegistro = inputUsuario.next();
    cliente.setNombre(nombreRegistro);
    inputUsuario.nextLine();

    System.out.println("Ingresa el apellido paterno del cliente");
    apellidoPaternoRegistro = inputUsuario.next();
    cliente.setApellidoPaterno(apellidoPaternoRegistro);
    inputUsuario.nextLine();

    System.out.println("Ingresa el apellido materno del cliente");
    apellidoMaternoRegistro = inputUsuario.next();
    cliente.setApellidoMaterno(apellidoMaternoRegistro);
    inputUsuario.nextLine();

    System.out.println("Ingresa el domicilio del cliente");
    domicilioRegistro = inputUsuario.next();
    cliente.setDomicilio(domicilioRegistro);
    inputUsuario.nextLine();

    System.out.println("Ingresa la comuna a la que pertenece la dirección");
    comunaRegistro = inputUsuario.next();
    cliente.setComuna(comunaRegistro);
    inputUsuario.nextLine();

    System.out.println("Ingresa el teléfono del cliente");
    telefonoRegistro = inputUsuario.next();
    cliente.setTelefono(telefonoRegistro);
    inputUsuario.nextLine();

    System.out.println("Asígnale un número de cuenta al cliente (Número de 9 dígitos)");
    numeroCuentaRegistro = inputUsuario.next();
    cuentaCliente.setNumeroCuenta(numeroCuentaRegistro);
    inputUsuario.nextLine();

    cliente.setCuenta(cuentaCliente);


    System.out.println("\n**** ¡Cliente creado exitosamente! ****");
    
    
  };
  
  
  

  
  
  
}
