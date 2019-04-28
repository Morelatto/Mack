/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressao;

/**
 *
 * @author Pedro Morelatto
 * @author Lucas Gianfrancesco
 */
public class Expressao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        java.util.Scanner input = new java.util.Scanner(System.in);

        String infixa;

        System.out.printf("Equação: ");
        infixa = input.next();

        if (isValid(infixa)) {
            String posfixa = toPostfix(infixa);
            double resultado = calculate(posfixa);

            if (resultado != -1) {
                System.out.printf("%s => %s => %.2f\n", infixa, posfixa, resultado);
            } else {
                System.out.printf("%s => %s\n", infixa, posfixa);
            }
        }
    }

    /**
     *
     * @param infixa: expressão infixa
     * @return true se expressão infixa for válida
     */
    public static boolean isValid(String infixa) {

        int cont = 0;
        int cont2 = 0;

        if (isOperator(infixa.charAt(0))) {
            System.out.printf("Operação Inválida. Equação iniciada por operador.\n");
            return false;
        }

        if (isOperator(infixa.charAt(infixa.length() - 1))) {
            System.out.printf("Operação Inválida. Equação finalizada por operador.\n");
            return false;
        }

        for (int i = 0; i < infixa.length(); i++) {
            if (infixa.charAt(i) == ')') {
                cont--;
                if (i != infixa.length() - 1 && Character.isDigit(infixa.charAt(i + 1))) {
                    System.out.printf("Operação Inválida. Parênteses seguido de operando.\n");
                    return false;
                }
            } else if (infixa.charAt(i) == '(') {
                cont++;
                if (i != 0 && Character.isDigit(infixa.charAt(i - 1))) {
                    System.out.printf("Operação Inválida. Operando precedido de parênteses.\n");
                    return false;
                }
                if (i != infixa.length() - 1 && infixa.charAt(i + 1) == ')') {
                    System.out.printf("\"Operação Inválida. Parênteses não utilizados.\n");
                    return false;
                }
            }
            if (isOperator(infixa.charAt(i))) {
                if (isOperator(infixa.charAt(i + 1))) {
                    System.out.printf("Operação Inválida. Operador precedido por operador.\n");
                    return false;
                }
                if (infixa.charAt(i - 1) == '(') {
                    System.out.printf("Operação Inválida. Parênteses precedido por operador.\n");
                    return false;
                }
                if (infixa.charAt(i + 1) == ')') {
                    System.out.printf("Operação Invalida. Operador precedido por parênteses.\n");
                    return false;
                }
                cont2++;
            }
            if (cont == -1) {
                System.out.printf("Operação Inválida. Fechou parênteses antes de abrir.\n");
                return false;
            }
        }
        if (cont > 0) {
            System.out.printf("Operação Inválida. Não fechou parênteses.\n");
            return false;
        }
        if (cont2 == 0) {
            System.out.printf("Operação Inválida. Não inseriou operadores.\n");
            return false;
        }
        return true;
    }

    /**
     *
     * @param elemento: possível operador
     * @return true se elemento for operador
     */
    public static boolean isOperator(char elemento) {
        return elemento == '+' || elemento == '-' || elemento == '*' || elemento == '/' || elemento == '^';
    }

    /**
     *
     * @param infixa: expressão infixa
     * @return expressão pósfixa
     */
    public static String toPostfix(String infixa) {

        Pilha stack = new Pilha(infixa.length());

        String posfixa = "";

        for (int i = 0; i < infixa.length(); i++) {
            if (Character.isLetterOrDigit(infixa.charAt(i))) {
                posfixa += (Character.toString(infixa.charAt(i)));
            } else if (!stack.isEmpty() || infixa.charAt(i) == '(') {
                if (infixa.charAt(i) != '(' && infixa.charAt(i) != ')') {
                    if (priority((char) stack.getTopo(), infixa.charAt(i))) {
                        stack.push(infixa.charAt(i));
                    } else {
                        posfixa += ((stack.pop()));
                        i--;
                    }
                } else if (infixa.charAt(i) == '(') {
                    String infixa2 = "";
                    for (int j = i + 1; j < infixa.length(); j++, i++) {
                        if (infixa.charAt(j) != ')') {
                            infixa2 += infixa.charAt(j);
                        } else {
                            i++;
                            break;
                        }
                    }
                    posfixa += toPostfix(infixa2);
                }
            } else {
                stack.push(infixa.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            posfixa += ((stack.pop()));
        }
        return posfixa;
    }

    /**
     *
     * @param elemento1
     * @param elemento2
     * @return true se elemento2 possui maior prioridade
     */
    public static boolean priority(char elemento1, char elemento2) {

        if (elemento1 == '^') {
            return false;
        }

        if (elemento2 == '^') {
            return true;
        }

        if (elemento1 == '*' || elemento1 == '/' || elemento1 == '%') {
            return false;
        }

        return (elemento2 == '*' || elemento2 == '/' || elemento2 == '%');
    }

    /**
     *
     * @param posfixa: expressão pósfixa.
     * @return resultado de expressão pósfixa
     */
    public static Double calculate(String posfixa) {

        Pilha<Double> stack = new Pilha(posfixa.length());

        double numero1, numero2;

        for (int i = 0; i < posfixa.length(); i++) {
            if (Character.isDigit(posfixa.charAt(i))) {
                stack.push(Double.parseDouble("" + posfixa.charAt(i)));
            } else if (!Character.isLetter(posfixa.charAt(i))) {
                numero1 = stack.pop();
                numero2 = stack.pop();
                switch (posfixa.charAt(i)) {
                    case '+':
                        stack.push(numero1 + numero2);
                        break;
                    case '-':
                        stack.push(numero1 - numero2);
                        break;
                    case '*':
                        stack.push(numero1 * numero2);
                        break;
                    case '/':
                        stack.push(numero1 / numero2);
                        break;
                    case '%':
                        stack.push(numero1 % numero2);
                        break;
                    case '^':
                        stack.push(Math.pow(numero2, numero1));
                        break;
                }
            } else {
                return (double) -1;
            }
        }
        return stack.pop();
    }
}
