package tests;

import invregsystem.db.Initializer;
import invregsystem.logic.member.UserCatalog;

public class UnitTest {

	{
		//Initializer i  = new Initializer();
		//Initializer.main(null);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnitTest test = new UnitTest();
		
		test.testUserCatalog();

	}
	public void testUserCatalog(){
		System.out.println(UserCatalog.getInstance().getAllItems().size());
	}

}
