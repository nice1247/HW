package Bank;

import java.util.Scanner;

public class BankApllication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	static int num = 0;

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------");
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.���� ");
			System.out.println("----------------------------------");
			System.out.print("���� >> ");

			int selectNo = scanner.nextInt();
			scanner.nextLine();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
				System.out.println("����Ǿ����ϴ�.");
			} else {
				System.out.println("�߸��� ���� �Է��Ͽ����ϴ�.");
			}
		}
	}

	private static void createAccount() {
		System.out.println("------");
		System.out.println("���� ����");
		System.out.println("------");

		String ano = readStr("���¹�ȣ : ");
		String owner = readStr("������ : ");
		int balance = readInt("�ʱ��Աݾ� : ");

		Account act = new Account(ano, owner, balance);
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = act;
				break;
			}
		}
		System.out.println("���°� �����Ǿ����ϴ�.");
	}

	private static void accountList() {
		for (Account act : accountArray) {
			if (act != null) {
				act.showAccount();
			}
		}
	}

	private static void deposit() {
		System.out.println("------");
		System.out.println("����");
		System.out.println("------");
		
		String search = readStr("���¹�ȣ : ");
		int de = readInt("���ݾ� : ");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null && accountArray[i].getAno().equals(search)) {
				accountArray[i].setBalance(accountArray[i].getBalance() + de);
			}
		}
		System.out.println("������ �����Ǿ����ϴ�.");
	}

	private static void withdraw() {
		System.out.println("------");
		System.out.println("���");
		System.out.println("------");
		
		String search = readStr("���¹�ȣ : ");
		int de = readInt("��ݾ� : ");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null && accountArray[i].getAno().equals(search)) {
				if (accountArray[i].getBalance() >= de) {
					accountArray[i].setBalance(accountArray[i].getBalance() - de);
					System.out.println("����� �����Ǿ����ϴ�.");
				} else if (accountArray[i].getBalance() < de) {
					System.out.println("��� ���ɾ��� �ʰ��Ͽ����ϴ�.");
				}
			}
		}
	}

	private static Account findAccount(String ano) {
		return null;
	}

	public static String readStr(String msg) {
		System.out.print(msg);
		return scanner.nextLine();
	}

	public static int readInt(String msg) {
		System.out.print(msg);
		int result = 0;
		while (true) {
			String a = scanner.nextLine();
			try {
				result = Integer.parseInt(a);
				break;
			} catch (Exception e) {
				System.out.println("���ڸ� �������ּ���");
			}
		}
		return result;
	}
}
