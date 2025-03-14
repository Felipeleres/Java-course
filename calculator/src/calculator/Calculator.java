package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		

		try(Scanner sc = new Scanner(System.in)) {

			System.out.print("Digite o primeiro numero: ");
			double num1 = sc.nextDouble();
			
			System.out.print("Digite o segundo numero: ");
			double num2 = sc.nextDouble();
			
			System.out.print("Digite um operador para o calculo: (+,-,/,*)");
			char operator = sc.next().charAt(0);

			double result = calcular(num1, num2, operator);
			System.out.println(num1 + " " + operator + " " + num2 + " : " + result);

		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida: certifique-se de inserir um valor válido");
		} catch (ArithmeticException e) {
			System.out.println("Erro: " + e.getMessage());

		}catch(IllegalArgumentException e) {
			System.out.println("Erro: "+ e.getMessage());
		}

	}

	public static double calcular(double num1, double num2, char operator) {

		switch (operator) {
		case '+':
			return num1 + num2;

		case '-':
			return num1 - num2;

		case '/':
			if (num2 == 0) {
				throw new ArithmeticException("Não existe divisão por zero!");
			}
			return num1 / num2;

		case '*':
			return num1 * num2;

		default:
			throw new IllegalArgumentException("Operação inválida: " + operator+"utilize apenas(+,-,/,*)");
		}

	}

}
