# Decisiones de diseño — FinTrack" y una sección "## Día 1
1) ¿Por qué Account no tiene setBalance? ¿Qué regla protegemos? 
    Porque usamos el metodo de doposito para modificar el valor de balance, no se que regla protegemos
    pero creo que no lo pusimos para que no haya varias formar de modificar el valor de balance y solo exista deposit y las validaciones
    que existen dentro de esta
2) ¿Por qué id y ownerName son final y balance no?
    Porque estos no deben de cambiar una vez creados, en cambio el balance se puede seguir actualizando
3) Si un repositorio entregara el MISMO objeto Account a dos partes del programa, ¿qué riesgo hay? Relaciónalo con E1.
    Que se dupliquen los datos, osea que existan dos accounts con el mismo Id y owner name
4) ¿Qué ventaja y qué desventaja tendría guardar el dinero como long en centavos?
    Que sea mas rapido, ya que tengo entendido que BigDecimal es exacto pero puede ser tardado


No entendi a que se refiere con En el chat, sin IDE. Primero el porqué y después el resultado.
Asi que mejor lo puse en este archivo:
1) ¿Qué imprime?
    List<String> a = new ArrayList<>();
    List<String> b = a;
    b.add("x");
    b = new ArrayList<>();
    b.add("y");
    System.out.println(a); // Esto ya que b y a apuntan al mismo objeto , se agrega x y despues b apunta a otro difetente asi que a imprime {"x"}
2) ¿Qué imprime?
    static void reset(Account acc) {
        acc = null;
    } → reset(c);
        System.out.println(c.getBalance());
        con c creado con saldo 20.
    Se imprime 20, ya que tengo entendido de que el metodo solo modifica el objeto localmente

3) ¿Qué bug tiene? 
    BigDecimal total = BigDecimal.ZERO;
    for (BigDecimal x : amounts) 
    total.add(x);

    Que total no esta creando un objeto nuevo con la suma, al final va a regresar 0

4) Con un ejemplo de FinTrack, explica por qué final no hace inmutable a un objeto.
    Sera porque podemos hacer que apunte a una referencia nueva, no se porque
5) ¿Por qué new BigDecimal("0.1") y no new BigDecimal(0.1)?
    Porque cuando lo creamos con un String el constructor con el que sea crea es exacto de lo contrario no lo es
6) Dibuja en texto el stack y el heap de E1 justo después de b.deposit(...).
    el stack es el orden en el que se ejecutan los metodos, el heap es donde se guardan los objetos a los que apuntan las referencias
