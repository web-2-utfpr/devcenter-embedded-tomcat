package database;

import org.javalite.activejdbc.Base;

public class Database {

    static String host;
    static String username;
    static String password;

    public static void Open() {
        if (Base.hasConnection()) {
            return;
        }
        host = System.getenv("MYSQL_HOST");
        if (host != null) {
            username = System.getenv("MYSQL_USER");
            password = System.getenv("MYSQL_PASSWORD");
        } else {
            host = "jdbc:mysql://192.168.99.100:3306/sql10233623?useSSL=false";
            username = "root";
            password = "root";
        }
        Base.open("com.mysql.cj.jdbc.Driver", host, username, password);
    }

    public static void Close() {
        Base.close();
    }

}
