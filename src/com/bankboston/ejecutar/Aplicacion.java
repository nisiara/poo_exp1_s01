
package com.bankboston.ejecutar;

import com.bankboston.entidades.Banco;
import com.bankboston.entidades.Cliente;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Aplicacion {
  public static void main(String[] args){
    
    Banco bankBoston = new Banco("bank boston", new Cliente());
    Scanner inputUsuario = new Scanner(System.in);
    List<Cliente> clientes = new ArrayList<>();
   
    //MENU BANK BOSTON
    int opcionMenu = 0;
    while(opcionMenu != 6){
      try{
        System.out.println("\n+++++++++++++++++++++++++++++++");
        System.out.println("      MENU BANK " + bankBoston.getNombre().toUpperCase() );
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("[1] Registrar Cliente");
        System.out.println("[2] Ver Datos Cliente");
        System.out.println("[3] Depositar");
        System.out.println("[4] Girar");
        System.out.println("[5] Consultar Saldo");
        System.out.println("[6] Salir");
        opcionMenu = 0;
          
        opcionMenu = inputUsuario.nextInt();
        
        if(opcionMenu < 1 || opcionMenu > 6){
          System.out.println("\n+**** ENTRADA INVÁLIDA **** Debes ingresar un número válido para poder continuar." );
        }
      }
      catch(InputMismatchException error){
        System.out.println("**** ENTRADA INVÁLIDA **** Debes ingresar un número." );
        inputUsuario.next();
        opcionMenu = 0;
      }
      
      try{
        switch (opcionMenu) {
          // REGISTRAR CLIENTE
          case 1:
            System.out.println("\n**** PROCESO DE REGISTRO CLIENTE ****");
            bankBoston.registrarCliente();
            clientes.add(bankBoston.getCliente());  
            break;

          // VER DATOS CLIENTE
          case 2:
            System.out.println("\n**** DATOS CLIENTE ****");
            clientes.get(0).verDatos();
            break;

          // DEPOSITAR  
          case 3:
            System.out.println("\n**** DEPOSITO ****");
            clientes.get(0).getCuenta().depositarDinero();
            break;

          // GIRAR  
          case 4:
            System.out.println("\n**** GIRAR DINERO ****");
            clientes.get(0).getCuenta().girarDinero();
            break;

          // CONSULTAR SALDO  
          case 5:
            System.out.println("\n**** CONSULTA DE SALDO ****");
            clientes.get(0).getCuenta().verDatos();
            break;
          
        } 
      }
      catch(IndexOutOfBoundsException error){
        System.out.println("**** NO PUEDES INGRESAR A ESTA SECCIÓN **** Primero debes registrar un cliente." );
        opcionMenu = 0;
      }
        
    }
    System.out.println("**** HAS SALIDO DE LA APLICACIÓN | " + bankBoston.getNombre().toUpperCase() + " ****");
  }
}
