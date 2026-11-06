package com.ivan.fintrack.lab;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ivan.fintrack.domain.Account;

public class ReferenceLab {
    
    public static void main(String[] args){
        // E1 — alias: dos flechas, un objeto
        Account a = new Account("ACC-1", "Ivan", new BigDecimal("100.00"));
        Account b = a;
        b.deposit(new BigDecimal("50"));
        System.out.println(a.getBalance() + " " + (a == b));
        // PREDICCIÓN:150 true
        // RESULTADO: 150.00 true
        // Porque:

        addBonus(a);
        System.out.println(a.getBalance());
        // PREDICCIÓN:160
        // RESULTADO: 160.00
        // Porque:

        replace(a);
        System.out.println(a.getId() + " " + a.getBalance());
        // PREDICCIÓN:ACC-2 1000
        // RESULTADO: ACC-1 160.00
        // Porque: me equivoque porque pense que el metodo replace creaba un objeto nuevo y lo asignaba a la referencia a.

        // E5 — String inmutable
        String name = "ivan";
        name.toUpperCase();  
        System.out.println(name);
        // PREDICCIÓN: IVAN
        // RESULTADO: ivan
        // Porque: los objetos String son inmutables, por lo que cualquier operación que modifique un String crea un nuevo objeto.
        // asi que para mostrar IVAN debi de guardar el resultado de name.toUpperCase() en una variable y luego imprimir esa variable.
        String upper = name.toUpperCase();  
        System.out.println(upper);
        // PREDICCIÓN: IVAN
        // RESULTADO: IVAN
        // Porque: porque guarde el resultado de name.toUpperCase() en la variable upper y luego imprimi upper.
        // E6 — double vs BigDecimal
        System.out.println(0.1 + 0.2);
        // PREDICCIÓN: 0.30000000000000004
        // RESULTADO: 0.30000000000000004
        // Porque:
        System.out.println(new BigDecimal(0.1));
        // PREDICCIÓN: 0.1
        // RESULTADO: 0.1000000000000000055511151231257827021181583404541015625
        // Porque: porque el constructor de BigDecimal que recibe un double no es exacto,
        // ya que el double no puede representar exactamente 0.1, por lo que se produce una pequeña imprecisión.
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));
        // PREDICCIÓN: 0.3
        // RESULTADO: 0.3
        // Porque: porque el constructor de BigDecimal que recibe un String es exacto, 
        // ya que el String puede representar exactamente 0.1 y 0.2, por lo que no se produce ninguna imprecisión.
        
        // E7 — BigDecimal inmutable
        BigDecimal total = new BigDecimal("100");
        total.add(new BigDecimal("50"));  
        System.out.println(total);
        // PREDICCIÓN: 150
        // RESULTADO: 100
        // Porque: porque BigDecimal es inmutable, por lo que cualquier operación que modifique un BigDecimal crea un nuevo objeto.
        // por lo que debi de guardar el resultado de total.add(new BigDecimal("50")) en la variable total y luego imprimir total.
        total = total.add(new BigDecimal("50"));  
        System.out.println(total);
        // PREDICCIÓN: 200
        // RESULTADO: 150
        // Porque: porque guarde el resultado de total.add(new BigDecimal("50")) en la variable total y luego imprimi total.
        
        // E8 — final fija la flecha, no el objeto
        final Account fixed = new Account("ACC-3", "Ana", new BigDecimal("10"));
        fixed.deposit(new BigDecimal("5"));         // ¿compila? Respuesta: no porque es final
        // fixed = new Account("ACC-4", "Luis", BigDecimal.ONE); // ¿compila? pruébalo y vuelve a comentarlo
        final List<String> tags = new ArrayList<>();
        tags.add("viaje");  
        System.out.println(tags);
        // PREDICCIÓN: {viaje}
        // RESULTADO: {viaje}
        // Porque: porque el método add() modifica el objeto List al que apunta la variable tags, pero no reasigna la variable tags.
    }

    // E2 — el método cambia el OBJETO
    static void addBonus(Account acc) {
        acc.deposit(new BigDecimal("10"));
    }

    // E3 — el método mueve SU flecha
    static void replace(Account acc) {
        acc = new Account("ACC-2", "Otro", new BigDecimal("999"));
        acc.deposit(new BigDecimal("1"));
    }

    // E4 — primitivo
    static void increment(int n) {
        n = n + 1; 
        }




}
