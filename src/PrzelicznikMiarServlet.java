import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/PrzelicznikMiar")
public class PrzelicznikMiarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HashMap<String, String> data = new HashMap<>();
        if (request.getParameter("milimetry") != null && request.getParameter("milimetry").toString().length() > 0)
            data.put("milimetry", request.getParameter("milimetry"));
        if (request.getParameter("metry") != null && request.getParameter("metry").toString().length() > 0)
            data.put("metry", request.getParameter("metry"));
        if (request.getParameter("centymetry") != null && request.getParameter("centymetry").toString().length() > 0)
            data.put("centymetry", request.getParameter("centymetry"));
        if (request.getParameter("kilogramy") != null && request.getParameter("kilogramy").toString().length() > 0)
            data.put("kilogramy", request.getParameter("kilogramy"));
        if (request.getParameter("gramy") != null && request.getParameter("gramy").toString().length() > 0)
            data.put("gramy", request.getParameter("gramy"));
        if (request.getParameter("miligramy") != null && request.getParameter("miligramy").toString().length() > 0)
            data.put("miligramy", request.getParameter("miligramy"));

        PrzelicznikMiar przelicznikMiar = new PrzelicznikMiar(data);
        System.out.println(przelicznikMiar.convert());
        request.setAttribute("data", przelicznikMiar.convert());
        request.setAttribute("nazwa", "Konwerter miar - Wynik");
        request.setAttribute("numer", "17.1");
        request.getRequestDispatcher("wynik.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
