package gefp.models;

public class Checkpoint
{
    private String fid;

    private String runway;

    private String stage;

    private String name;

    public Checkpoint() {}

    public Checkpoint(String runway, String stage, String name)
    {
        setRunway(runway);
        setStage(stage);
        setName(name);
    }

    public boolean isIn(String runway, String stage)
    {
        return this.runway.equals(runway) && this.stage.equals(stage);
    }

    public String getFid()
    {
        return fid;
    }

    public void setFid(String fid)
    {
        this.fid = fid;
    }

    public String getRunway() {
        return runway;
    }

    public void setRunway(String runway) {
        this.runway = runway.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    @Override
    public String toString()
    {
        return runway + " " + stage + " " + name;
    }
}
