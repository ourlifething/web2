package test;

import dao.AccountsDAO;
import model.Account;
import model.Login;

//作成したメソッドが実行可能かテストするテストコード
public class AccountsDAOTest {

	public static void main(String[] args) {
		
		testFindByLoginOK();
		testFindByLoginNG();

	}
	public static void testFindByLoginOK() {
		Login login = new Login("minato","1234");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);
		if(result != null &&
		   result.getUserId().equals("minato") &&
		   result.getPass().equals("1234") &&
		   result.getMail().equals("yusuke.minato@miyabilink.jp") &&
		   result.getName().equals("湊雄介") &&
		   result.getAge() == 23) {
		  System.out.println("testFindByLoginOK:成功しました");
		}else {
			System.out.println("testFindByLogin:失敗しました");
		}
	}
	
	public static void testFindByLoginNG() {
		Login login = new Login("minato", "12345");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);
		if(result == null) {
			System.out.println("testFindByLoginNG:成功しました");
		}else {
			System.out.println("testFindByLoginNG:失敗しました");
		}
	}

}
