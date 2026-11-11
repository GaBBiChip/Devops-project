import java.util.List;

public class F1ProbabilityApp {

    private static final int RACES_LEFT = 3;
    private static final int POINTS_PER_RACE = 26; 
    private static final int MAX_REMAINING_POINTS = RACES_LEFT * POINTS_PER_RACE;

    public static void main(String[] args) {
        ConsoleUI.printHeader();

        // Получаем данные через наш новый отдельный класс
        List<PilotStanding> standings = DatabaseRepository.getAllStandings();
        
        if (standings.isEmpty()) {
            ConsoleUI.printError("Данные пилотов не найдены или возникла ошибка БД.");
            return;
        }

        // Сортируем список по убыванию очков
        standings.sort((p1, p2) -> Integer.compare(p2.getPoints(), p1.getPoints()));

        // Отображение таблицы
        ConsoleUI.printTable(standings);

        // Поиск Макса и Лидера
        PilotStanding leader = standings.get(0);
        PilotStanding verstappen = null;

        for (PilotStanding pilot : standings) {
            if (pilot.getName().equals("Max Verstappen")) {
                verstappen = pilot;
                break;
            }
        }

        if (verstappen == null) {
            ConsoleUI.printError("Max Verstappen отсутствует в таблице базы данных.");
            return;
        }

        // Математические расчеты
        int pointGap = leader.getPoints() - verstappen.getPoints();
        double probability = 0.0;
        
        if (pointGap <= 0) {
            probability = 100.0;
        } else if (pointGap <= MAX_REMAINING_POINTS) {
            probability = (1.0 - ((double) pointGap / MAX_REMAINING_POINTS)) * 100;
        }

        String status = pointGap <= MAX_REMAINING_POINTS ? "В погоне за титулом" : "Математически потерял шансы на титул";

        // Вывод результата 
        ConsoleUI.printAnalytics(
            RACES_LEFT, MAX_REMAINING_POINTS, 
            leader.getName(), leader.getPoints(), 
            verstappen.getPoints(), pointGap, 
            probability, status
        );
    }
}