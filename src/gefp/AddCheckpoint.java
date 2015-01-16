package gefp;

import gefp.models.Checkpoint;
import gefp.models.CheckpointManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/gefp/addCheckpoint")
public class AddCheckpoint extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/gefp/addCheckpoint.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        CheckpointManager checkpoints = new CheckpointManager(request.getSession().getAttribute("checkpoints"));
        ArrayList<String> errors = new ArrayList<String>();

        String runway = request.getParameter("runway");
        String stage = request.getParameter("stage");
        String name = request.getParameter("checkpoint");

        if (Gefp.isEmpty(runway)) errors.add("Invalid runway!");
        if (Gefp.isEmpty(stage)) errors.add("Invalid stage!");
        if (Gefp.isEmpty(name)) errors.add("Invalid checkpoint!");

        if (errors.isEmpty()) {
            checkpoints.getList().add(new Checkpoint(runway, stage, name));

            request.getSession().setAttribute("checkpoints", checkpoints.getList());

            response.sendRedirect("/gefp");
        } else {
            request.setAttribute("errors", errors);
            doGet(request, response);
        }
    }

}
