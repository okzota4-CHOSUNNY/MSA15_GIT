package classpart;

public class FunctionTest_GPT {

    public static void main(String[] args) {
	        int num1 = 20;
	        int num2 = 5;

	        int sum = add(num1, num2);
	        int difference = subtract(num1, num2);
	        int product = multiply(num1, num2);
	        int quotient = divide(num1, num2);

	        System.out.println(num1 + " + " + num2 + " = " + sum);
	        System.out.println(num1 + " - " + num2 + " = " + difference);
	        System.out.println(num1 + " * " + num2 + " = " + product);
	        System.out.println(num1 + " / " + num2 + " = " + quotient);
	    }

	    // 더하기
	    public static int add(int a, int b) {
	        return a + b;
	    }

	    // 빼기
	    public static int subtract(int a, int b) {
	        return a - b;
	    }

	    // 곱하기
	    public static int multiply(int a, int b) {
	        return a * b;
	    }

	    // 나누기
	    public static int divide(int a, int b) {
	        return a / b; // 나누기 연산, b가 0이면 오류 발생 가능
	    }
	}
