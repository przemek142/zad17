import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ObslugaTekstu")
public class PrzelicznikTekstuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");

        PrzelicznikTekstu przelicznikTekstu = new PrzelicznikTekstu(text);


        request.setAttribute("data", przelicznikTekstu.makeStats());
        request.setAttribute("nazwa", "Obsługa tekstu - Wynik");
        request.setAttribute("numer", "17.2");
        request.getRequestDispatcher("wynik.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}