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
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 ");
			System.out.println("----------------------------------");
			System.out.print("선택 >> ");

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
				System.out.println("종료되었습니다.");
			} else {
				System.out.println("잘못된 값을 입력하였습니다.");
			}
		}
	}

	private static void createAccount() {
		System.out.println("------");
		System.out.println("계좌 생성");
		System.out.println("------");

		String ano = readStr("계좌번호 : ");
		String owner = readStr("계좌주 : ");
		int balance = readInt("초기입금액 : ");

		Account act = new Account(ano, owner, balance);
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = act;
				break;
			}
		}
		System.out.println("계좌가 생성되었습니다.");
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
		System.out.println("예금");
		System.out.println("------");
		
		String search = readStr("계좌번호 : ");
		int de = readInt("예금액 : ");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null && accountArray[i].getAno().equals(search)) {
				accountArray[i].setBalance(accountArray[i].getBalance() + de);
			}
		}
		System.out.println("예금이 성공되었습니다.");
	}

	private static void withdraw() {
		System.out.println("------");
		System.out.println("출금");
		System.out.println("------");
		
		String search = readStr("계좌번호 : ");
		int de = readInt("출금액 : ");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null && accountArray[i].getAno().equals(search)) {
				if (accountArray[i].getBalance() >= de) {
					accountArray[i].setBalance(accountArray[i].getBalance() - de);
					System.out.println("출금이 성공되었습니다.");
				} else if (accountArray[i].getBalance() < de) {
					System.out.println("출금 가능액을 초과하였습니다.");
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
				System.out.println("숫자를 기입해주세요");
			}
		}
		return result;
	}
}
