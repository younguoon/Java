package chap09.Class.Calculator;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator_class {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result;
		String str, token_str;

		input_loop: while (true) {
			System.out.println("���� �Է� : ");
			str = sc.next().trim();

			StringTokenizer token = new StringTokenizer(str, "+-*/", true);

			token_str = token.nextToken();// ù��° ��ū ����
			if (input_check(token_str)) { // input_check():��ū�� �������� �˻�
				System.out.println("���� �Է� ����!!\n"); // ��ū�� ���ڰ� �ƴ�
				continue; // while(true)�� �̵�
			}
			result = Integer.parseInt(token_str); // ��ū�� ���ڷ� ����

			while (token.hasMoreTokens()) { // ��ū�� ���������� �ݺ�
				token_str = token.nextToken();// ¦����° ��ū ����(������)
				char ch = token_str.charAt(0);// ���ڿ����� ������ ����

				if (token.hasMoreTokens())
					token_str = token.nextToken(); // Ȧ����° ��ū�� ����(����)
				else {
					System.out.println("���� �Է� ����!!\n"); // �����ڷ� ������ ������ ���
					continue input_loop;
				}

				if (input_check(token_str)) { // input_check() : ��ū�� �������� �˻�
					System.out.println("���� �Է� ����!!\n");
					continue input_loop;
				}
				switch (ch) {
				case '+':
					result += Integer.parseInt(token_str);
					break;
				case '-':
					result -= Integer.parseInt(token_str);
					break;
				case '*':
					result *= Integer.parseInt(token_str);
					break;
				case '/':
					result /= Integer.parseInt(token_str);
					break;
				}
			}
			break;
		}
		System.out.println(str + "=" + result);
	}

	static boolean input_check(String str) {
		char ch;
		for (int i = 0; i < str.length(); i++) { // ��ū�� ���� �޾� ���ڿ� ���̸�ŭ �ѹ��ھ� �˻�
			ch = str.charAt(i); // ���ڿ����� �ѹ��ھ� ����
			if (ch < '0' || ch > '9')
				return true;
		}
		return false;
	}
}