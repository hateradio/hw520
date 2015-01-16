package gefp.servlet;

import gefp.models.Checkpoint;
import gefp.models.CheckpointManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/gefp/editCheckpoint")
public class EditCheckpoint extends HttpServlet
{
    private ArrayList<String> errors = new ArrayList<String>();

    private CheckpointManager checkpoints;

    private int id;

    private String runway;

    private Checkpoint chk = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        checkpoints = new CheckpointManager(request.getSession().getAttribute("checkpoints"));
        parseFid(request);

        try {
            chk = checkpoints.get(runway, id);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            errors.clear();
            errors.add("Invalid checkpoint ID!");
        }

        request.setAttribute("errors", errors);
        request.setAttribute("checkpoint", chk);
        request.getRequestDispatcher("/WEB-INF/gefp/editCheckpoint.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        checkpoints = new CheckpointManager(request.getSession().getAttribute("checkpoints"));
        parseFid(request);
        String action = request.getParameter("action");

        try {
            chk = checkpoints.get(runway, id);
        } catch (IndexOutOfBoundsException e) {
            doGet(request, response);
            return;
        }

        if(null != request.getParameter("Delete"))
            delete();
        else if(null != request.getParameter("Save"))
            update(request);

        request.getSession().setAttribute("checkpoints", checkpoints.getList());

        if (errors.isEmpty())
            response.sendRedirect(Gefp.getHomePath() + "gefp");
        else
            doGet(request, response);
    }

    private void delete()
    {
        checkpoints.delete(runway, id);
    }

    private void update(HttpServletRequest request)
    {
        String name = request.getParameter("checkpoint");

        if (Gefp.isEmpty(name)) errors.add("Invalid name!");
        else {
            chk.setName(name);
            checkpoints.set(runway, id, chk);
        }
    }

    private void parseFid(HttpServletRequest request)
    {
        try {
            String[] parts = request.getParameter("fid").trim().split("-");
            runway = parts[0];
            id = Integer.parseInt(parts[1]) - 1;
        } catch (NullPointerException e) {
        }
    }

}
