import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/KonwerterWalut")
public class KonwerterWalutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        KonwerterWalut konwerterWalut = new KonwerterWalut();

        if (request.getParameter("inputCurrency") != null &&
                !request.getParameter("inputCurrency").isEmpty()) {

            if (request.getParameter("inputDate") != null &&
                    !request.getParameter("inputDate").isEmpty()) {

                Pattern patternDate = Pattern.compile("^[1|2][0|9][0|1|9][0-9]-[0|1][0-9]-[0|1|2|3][0-9]$");

                Matcher matcher = patternDate.matcher(request.getParameter("inputDate").strip().trim());

                if (matcher.matches()) {
                    konwerterWalut.setDate(request.getParameter("inputDate").strip().trim());
                }
            }
            konwerterWalut.getData();
            request.setAttribute("waluty", konwerterWalut.getratesKeysHTML());

            String inputCurrencyString = request.getParameter("inputCurrency").strip().trim().replace(",",".");
            String inputCurrencyChoiceString = request.getParameter("currencyChoice");
            String calculatedNewCurrency = konwerterWalut.calculate(inputCurrencyString,inputCurrencyChoiceString);

            request.setAttribute("wynik", calculatedNewCurrency);
            request.getRequestDispatcher("KonwerterWalut.jsp").forward(request, response);
        } else {
            request.setAttribute("wynik", "---");
            konwerterWalut.getData();
            request.setAttribute("waluty", konwerterWalut.getratesKeysHTML());
            request.getRequestDispatcher("KonwerterWalut.jsp").forward(request, response);
        }
    }
}