package gefp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(urlPatterns = "/gefp/addStage")
public class AddStage extends HttpServlet
{
    public static boolean isEmpty(String string)
    {
        return string == null || string.trim().length() == 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/gefp/addStage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String stage = request.getParameter("stage");

        if (!isEmpty(stage)) {
            updateStages(request, stage);

            response.sendRedirect(Gefp.getHomePath() + "gefp");
        } else {
            response.getOutputStream().print("Invalid Stage Name!");
        }

    }

    private HashSet<String> updateStages(HttpServletRequest request, String stage)
    {
        HashSet<String> stages = (HashSet<String>) request.getSession().getAttribute("stages");

        if (stages == null) {
            stages = new HashSet<>();
        }

        stages.add(stage);

        request.getSession().setAttribute("stages", stages);

        return stages;
    }
}
