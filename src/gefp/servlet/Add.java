package gefp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add")
public class Add extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

    private static final long serialVersionUID = 1L;

    public Add()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response ) throws ServletException, IOException
    {
        String a = request.getParameter( "a" );
        String b = request.getParameter( "b" );

        a = "10";
        b = "4";

//        if( a == null || b == null )
//        {
//            //response.sendRedirect( "AddForm.html" );
//            return;
//        }

        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Add</title></head><body>" );

        out.println( "<p>the sum of " + a + " and " + b + " is "
                + (Integer.parseInt( a ) + Integer.parseInt( b )) + ".</p>" );

        out.println( "</body></html>" );
    }

    protected void doPost( HttpServletRequest request,
                           HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}
