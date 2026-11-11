import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {

    // Настройки подключения к MySQL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/f1_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    // Метод для получения всех пилотов из базы данных
    public static List<PilotStanding> getAllStandings() {
        List<PilotStanding> list = new ArrayList<>();
        String query = "SELECT name, points, number, team FROM standings";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String name = rs.getString("name");
                int points = rs.getInt("points");
                String number = rs.getString("number");
                String team = rs.getString("team");

                list.add(new PilotStanding(name, points, number, team));
            }
        } catch (SQLException e) {
            ConsoleUI.printError("Ошибка подключения к MySQL: " + e.getMessage());
        }
        
        return list;
    }
}