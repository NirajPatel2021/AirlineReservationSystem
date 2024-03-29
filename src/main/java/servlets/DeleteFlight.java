package servlets;

import dao.FlightDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Flight;

import java.io.IOException;
import java.util.List;

/**
 * This servlet handles all GET and POST requests to the '/deleteFlight' endpoint
 */
@WebServlet(urlPatterns = "/deleteFlight")
public class DeleteFlight extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("flightID1"));

        deleteTheFlight(id);

        FlightDao flightDao = new FlightDao();
        List<Flight> allAvailableFlights = flightDao.getAllAvailableFlights();

        RequestDispatcher rd = request.getRequestDispatcher("deleteFlight.jsp");
        request.setAttribute("flights", allAvailableFlights);
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Flight> resultFlights = getFlights();

        RequestDispatcher rd = request.getRequestDispatcher("deleteFlight.jsp");
        request.setAttribute("flights", resultFlights);
        rd.forward(request, response);
    }

    /**
     * This method deletes the flight from the database.
     *
     * @param id - the id of the flight to delete from the database
     */
    public static void deleteTheFlight(int id) {
        FlightDao dao = new FlightDao();
        dao.deleteFlight(id);
    }

    /**
     * Helper function to retrieve the list of all available flights
     *
     * @return List<Flight> - the list of all available flights
     */
    public static List<Flight> getFlights() {
        FlightDao dao = new FlightDao();
        return dao.getAllAvailableFlights();
    }

}
