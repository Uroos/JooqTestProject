package sqltest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import test.generated.tables.*;

public class JavaSqlTest {


	public static void main(String[] args) {

		String userName = "root";
		String password = "abcd";
		String url = "jdbc:mysql://127.0.0.1:3306/test";

		try (Connection con = DriverManager.getConnection(url, userName, password)){
			System.out.println("Connection established!");
			// Get an instance of DSLContext so we can write a simple SELECT query
			DSLContext create = DSL.using(con, SQLDialect.MYSQL);
			Result<Record> result = create.select().from(Student.STUDENT).fetch();

			for (Record r : result) {
				Integer id = r.getValue(Student.STUDENT.ID);
				String firstName = r.getValue(Student.STUDENT.FIRST_NAME);
				String secondName = r.getValue(Student.STUDENT.SECOND_NAME);

				System.out.println("ID: " + id + " first name: " + firstName + " last name: " + secondName);
			}

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection not established!");
		}

	}

}
