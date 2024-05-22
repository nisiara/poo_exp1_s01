
package com.bankboston.entidades;

import java.util.Scanner;

public class Cliente {
  
  Scanner inputUsuario = new Scanner(System.in);
  
  // ATRIBUTOS
  private String rut;
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String domicilio;
  private String comuna;
  private String telefono;
  private Cuenta cuenta = new Cuenta();
  
  // CONSTRUCTOR
  public Cliente(){};
   
  // SETTERS & GETTERS
  public Cuenta getCuenta() {
    return this.cuenta;
  }
  public void setRut(String rut) {
    while(rut.length() != 11 && rut.length() != 12 ){
      System.out.println("**** ENTRADA INVÁLIDA **** El RUT debe contener entre 11 y 12 digitos, incluyendo guión y puntos." );
      rut = inputUsuario.next();
    }
    this.rut = rut; 
  }
  public void setNombre(String nombre) {
    this.nombre = validacionString(nombre);
  }
  public void setApellidoPaterno(String apellido){
    this.apellidoPaterno = validacionString(apellido);
  }
  public void setApellidoMaterno(String apellido){
    this.apellidoMaterno = validacionString(apellido);
  }
  public void setDomicilio(String direccion){
    this.domicilio = direccion;
  }
  public void setComuna(String comuna){
    this.comuna = validacionString(comuna);
  }
  public void setTelefono(String telefono){
    this.telefono = validacionNumero(telefono);
  }
  
  // METODOS DE LA CLASE
  public void verDatos(){
    System.out.println("Rut: " + this.rut);
    System.out.println("Nombre: " + this.nombre);
    System.out.println("Apellido Paterno: " + this.apellidoPaterno);
    System.out.println("Apellido Materno: " + this.apellidoMaterno);
    System.out.println("Domicilio: " + this.domicilio);
    System.out.println("Comuna: " + this.comuna);
    System.out.println("Teléfono: " + this.telefono);
    System.out.println("Número de Cuenta: " + this.cuenta.getNumeroCuenta());
    System.out.println("Saldo: " + this.cuenta.getSaldo());
   }
  
  //METODOS ADICIONALES
  private boolean sonCaracteres(String validarString) {
    return validarString.matches("^[a-zA-Z]+$");
  }
  private boolean sonNumeros(String validarNumero) {
    return validarNumero.matches("^[0-9]{9}$");
  }
  
  private String validacionString(String entrada){
    while(!sonCaracteres(entrada) ){
      System.out.println("**** ENTRADA INVÁLIDA ****. Este campo solo debe contener caracteres.");
      entrada = inputUsuario.next();
    }
    return entrada;
  }
  private String validacionNumero(String entrada){
    while(!sonNumeros(entrada) ){
      System.out.println("**** ENTRADA INVÁLIDA ****. Este campo solo debe contener 9 digitos.");
      entrada = inputUsuario.next();
    }
    return entrada;
  }
 
} // FIN DE LA CLASE
