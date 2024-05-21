
package com.bankboston.entidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cuenta {
  
  Scanner inputUsuario = new Scanner(System.in);

  // ATRIBUTOS
  private String numeroCuenta;
  private int saldo;
  
  // CONSTRUCTOR
  public Cuenta(){};

  // GETTERS & SETTERS
  public void setNumeroCuenta(String identificador){
    this.numeroCuenta = cuentaValida(identificador);
  }
  public String getNumeroCuenta(){  
    return this.numeroCuenta;
  }
  public int getSaldo(){
    return this.saldo;
  }

  // METODOS
  public void girarDinero() {
    int montoGiro = 0;
    do{
      try{
        if(this.saldo == 0){
          System.out.println("Tu saldo actual es de $0. No puedes realizar ningún giro");  
        } 
        else{
          System.out.println("¿Qué monto deseas girar desde tu cuenta?");
          montoGiro = inputUsuario.nextInt();
          if(montoGiro > this.saldo){
            System.out.println("El monto a girar debe ser menor o igual que tu saldo");
            System.out.println("Tu saldo actual es de: $" + this.saldo);
          } 
          
          else {
            this.saldo -= montoGiro;
            montoGiro = 0;
            System.out.println("**** ¡Giro realizado de manera exitosa! ****");
            System.out.println("       Tu nuevo saldo es de $" + this.saldo + "\n");
          }
        }
      }  
      
      catch (InputMismatchException error){
        System.out.println("+++ ERROR: Debes ingresar un monto válido." );
        inputUsuario.next();
        montoGiro = 0;
      }
    } while(montoGiro > 0 && montoGiro > this.saldo);
  }
  
  public void depositarDinero(){
    int montoDeposito;
    do{
      try{
        System.out.println("¿Qué monto deseas depositar en tu cuenta?");
        montoDeposito = inputUsuario.nextInt();
        if(montoDeposito <= 0){
          System.out.println("El monto a depositar debe ser mayor a cero");
        }
        else{
           this.saldo += montoDeposito;
           System.out.println("**** ¡Depósito realizado de manera exitosa!  ****");
           System.out.println("       Tu nuevo saldo es de $" + this.saldo + "\n");
        }
      } 
      catch (InputMismatchException error){
        System.out.println("+++ ERROR: Debes ingresar un monto válido." );
        inputUsuario.next();
        montoDeposito = 0;
      }
    } while(montoDeposito <= 0);
  }
  
  public void verDatos(){
    System.out.println("Número cuenta: " + this.numeroCuenta);
    System.out.println("Saldo: $" + this.saldo);
  }
  
  //METODOS ADICIONALES 
  private String cuentaValida(String cadena) {
    String regex = "^[0-9]{9}$";
    while(!cadena.matches(regex)){
      System.out.println("+**** ERROR **** El número de cuenta debe contener 9 dígitos");
      cadena = inputUsuario.next();
    }
    return cadena;
  }
  
}
