package Normal;

public class Bowler {
    private String name;
    public Double balls;
    public Double totalRuns;
    public Double economy;

    Bowler(){
        balls=0.0;
        totalRuns=0.0;
        economy=0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
