package Logica;

public class Calculadora {

    //Metodos
    public String sumar(String op1, String op2) {
        int n1 = Integer.parseInt(op1, 2);
        int n2 = Integer.parseInt(op2, 2);
        int r = n1 + n2;
        return Integer.toBinaryString(r);
    }

    public String restar(String op1, String op2) {
        int n1 = Integer.parseInt(op1, 2);
        int n2 = Integer.parseInt(op2, 2);
        int r = n1 - n2;
        return Integer.toBinaryString(r);
    }
    public String multiplicar(String op1, String op2) {
        int n1 = Integer.parseInt(op1, 2);
        int n2 = Integer.parseInt(op2, 2);
        int r = n1 * n2;
        return Integer.toBinaryString(r);
    }

}
