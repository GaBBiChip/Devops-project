public class PilotStanding {
    private final String name;
    private final int points;
    private final String number;
    private final String team;

    public PilotStanding(String name, int points, String number, String team) {
        this.name = name;
        this.points = points;
        this.number = number;
        this.team = team;
    }

    public String getName() { return name; }
    public int getPoints() { return points; }
    public String getNumber() { return number; }
    public String getTeam() { return team; }
}
