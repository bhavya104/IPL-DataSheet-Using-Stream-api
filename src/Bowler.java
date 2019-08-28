public class Bowler {
    private String name;
    public int balls;
    public int totalRuns;
    public int economy;

    Bowler(){
        balls=0;
        totalRuns=0;
        economy=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
