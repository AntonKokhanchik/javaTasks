package sef.module8.activity;


/**
 * This class represents a simple representation of an account encapsulating
 * a name 
 * 
 * @author Anton Kokhanchik
 *
 */
public class Account {

	private String name;

	/**
	 * Creates an Account object with the specified name.  If the accout name
	 * given violates the minimum requirements, then an AccountException is thrown
	 * 
	 * @param accountName
	 * @throws AccountException
	 */
	public  Account(String accountName) throws AccountException{
			
			if(accountName.length() < 4)
				throw new AccountException(AccountException.NAME_TOO_SHORT, accountName);
			if(!(accountName.matches(".*\\w.*") && accountName.matches(".*\\d.*")))
				// not (contains word and contains digit)
				throw new AccountException(AccountException.NAME_TOO_SIMPLE, accountName);
			name  = accountName;
	}
	
	
	/**
	 * Returns the account name
	 * 
	 * @return the account name
	 */
	public String getName(){
		return name;
	}
}
