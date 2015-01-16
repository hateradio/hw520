package gefp.models;

import gefp.Gefp;

import java.util.ArrayList;

public class CheckpointManager
{
    private ArrayList<Checkpoint> list;

    public CheckpointManager(Object sessionList)
    {
        list = (ArrayList<Checkpoint>) sessionList;

        if (list == null) {
            list = new ArrayList<Checkpoint>();
        }
    }

    public ArrayList<Checkpoint> getList()
    {
        return list;
    }

    public ArrayList<Checkpoint> filter(String runway, String stage)
    {
        ArrayList<Checkpoint> filter = new ArrayList<Checkpoint>();

        if (!Gefp.isEmpty(runway) && !Gefp.isEmpty(stage)) {
            runway = runway.trim();
            stage = stage.trim();

            int fid = 1;
            for (Checkpoint c : list) {
                if (c.isIn(runway, stage)) {
                    c.setFid(fid);
                    filter.add(c);
                }
                fid++;
            }
        }

        return filter;
    }

//    protected void setList(ArrayList<Checkpoint> list)
//    {
//        this.list = list;
//    }
}
