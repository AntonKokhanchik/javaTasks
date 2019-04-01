package sef.module13.activity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

	@SuppressWarnings("unused")
	private Connection conn;

	public AccountDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public List<Account> findAccount(String firstName, String lastName)
			throws AccountDAOException {
		try {
			Statement statement = conn.createStatement();
			String query = "select * from ACCOUNT where FIRST_NAME='" + firstName +
					"' or LAST_NAME='" + lastName + "' order by ID asc";
			ResultSet resultSet = statement.executeQuery(query);

			List<Account> result = new LinkedList<>();
			while (resultSet.next()){
				result.add(new AccountImpl(
						resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4)));
			}

			return result;
		} catch (SQLException e){
			throw new AccountDAOException(AccountDAOException.ERROR_FIND_NAME, e);
		}
	}

	public Account findAccount(int id) throws AccountDAOException {
		try {
			Statement statement = conn.createStatement();
			String query = "select * from ACCOUNT where ID=" + id;

			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();

			return new AccountImpl(resultSet.getInt(1), resultSet.getString(2),
					resultSet.getString(3), resultSet.getString(4));
		} catch (SQLException e){
			throw new AccountDAOException(AccountDAOException.ERROR_FIND_ID, e);
		}
	}


	public boolean insertAccount(String firstName, String lastName, String email)
			throws AccountDAOException {
		try{
			Statement statement = conn.createStatement();
			String query = "insert into ACCOUNT values (ACCOUNT_SEQ.NEXTVAL, '" +
					firstName + "', '" + lastName + "', '" + email + "')";

			int inserted = statement.executeUpdate(query);
			conn.commit();

			return inserted > 0;
		} catch (SQLException e){
			throw new AccountDAOException(AccountDAOException.ERROR_INSERT_ACCOUNT, e);
		}
	}

}
