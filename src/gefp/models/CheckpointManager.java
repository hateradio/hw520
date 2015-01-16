package gefp.models;

import gefp.servlet.Gefp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckpointManager
{
    private HashMap<String, ArrayList<Checkpoint>> list;

    public CheckpointManager(Object sessionList)
    {
        list = (HashMap<String, ArrayList<Checkpoint>>) sessionList;

        if (list == null) {
            list = new HashMap<String, ArrayList<Checkpoint>>();
        }
    }

    public HashMap<String, ArrayList<Checkpoint>> getList()
    {
        return list;
    }

    public void add(String runway, Checkpoint checkpoint)
    {
        if (!list.containsKey(runway.trim()))
            list.put(runway.trim(), new ArrayList<Checkpoint>());

        if (!list.get(runway).contains(checkpoint))
            list.get(runway).add(checkpoint);
    }

    public Checkpoint get(String runway, int id)
    {
        return list.get(runway).get(id);
    }

    public void set(String runway, int id, Checkpoint checkpoint)
    {
        list.get(runway).set(id, checkpoint);
    }

    public void delete(String runway, int id)
    {
        list.get(runway).remove(id);
    }

    public ArrayList<Checkpoint> filter(String runway, String stage)
    {
        ArrayList<Checkpoint> filter = new ArrayList<Checkpoint>();

        if (!Gefp.isEmpty(runway) && !Gefp.isEmpty(stage)) {
            runway = runway.trim();

            if (list.containsKey(runway)) {
                stage = stage.trim();

                int fid = 1;
                for (Checkpoint c : list.get(runway)) {
                    if (c.isIn(runway, stage)) {
                        c.setFid(String.format("%s-%d", runway, fid));
                        filter.add(c);
                    }
                    fid++;
                }
            }
        }

        return filter;
    }

//    protected void setList(ArrayList<Checkpoint> list)
//    {
//        this.list = list;
//    }
}
