import java.util.List;

public class ConsoleUI {
    // Цветовые коды терминала
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";
    private static final String BOLD = "\u001B[1m";

    public static void printHeader() {
        System.out.println(CYAN + BOLD + "======================================================");
        System.out.println("               F1 PROBABILITY CALCULATOR              ");
        System.out.println("======================================================" + RESET);
    }

    public static void printTable(List<PilotStanding> standings) {
        System.out.println(BOLD + "\n Текущее положение в чемпионате:" + RESET);
        System.out.println(" -----------------------------------------------------");
        System.out.printf(" | %-25s | %-14s | %-6s |\n", "Пилот", "Команда", "Очки");
        System.out.println(" -----------------------------------------------------");

        for (PilotStanding pilot : standings) {
            // форматирую чистый текст по ширине каждого столбца
            String formattedName = String.format("%-25s", pilot.getName());
            String formattedTeam = String.format("%-14s", pilot.getTeam());
            String formattedPoints = String.format("%-6d", pilot.getPoints());

            // подсвечиваем всю строку Макса золотым цветом
            if (pilot.getName().equals("Max Verstappen")) {
                formattedName = YELLOW + BOLD + formattedName + RESET;
                formattedTeam = YELLOW + BOLD + formattedTeam + RESET;
                formattedPoints = YELLOW + BOLD + formattedPoints + RESET;
            }

            System.out.println(" | " + formattedName + " | " + formattedTeam + " | " + formattedPoints + " |");
        }
        System.out.println(" -----------------------------------------------------");
    }

    public static void printAnalytics(int racesLeft, int maxPoints, String leader,
                                      int leaderPoints, int vPoints, int gap,
                                      double probability, String status) {
        String statusColor = gap <= maxPoints ? GREEN : RED;

        System.out.println(CYAN + BOLD + "\n================= АНАЛИТИКА ТИТУЛА =================" + RESET);
        System.out.printf(" %-30s %s\n", "Осталось гонок:", YELLOW + racesLeft + RESET);
        System.out.printf(" %-30s %s\n", "Макс. очков в розыгрыше:", YELLOW + maxPoints + RESET);
        System.out.printf(" %-30s %s (%d очк.)\n", "Текущий лидер:", PURPLE + leader + RESET, leaderPoints);
        System.out.printf(" %-30s %d очк.\n", "Очки Max Verstappen:", vPoints);
        System.out.printf(" %-30s %s\n", "Отставание от лидера:", RED + (gap > 0 ? gap : 0) + RESET);
        System.out.println("----------------------------------------------------");
        System.out.printf(" %-30s %s\n", "Статус Макса:", statusColor + BOLD + status + RESET);
        System.out.printf(" %-30s %s\n", "Вероятность чемпионства:", GREEN + BOLD + String.format("%.2f%%", probability) + RESET);
        System.out.println(CYAN + BOLD + "====================================================" + RESET);
    }

    public static void printError(String message) {
        System.out.println(RED + BOLD + "\n[!] ОШИБКА: " + message + RESET);
    }
}
