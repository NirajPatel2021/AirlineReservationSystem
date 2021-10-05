package servlets;

import dao.UserDao;
import dao.TripDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import models.TripID;
import java.io.IOException;

/**
 * This servlet handles all POST requests to the '/bookFlight' endpoint
 */
@WebServlet(urlPatterns = "/bookFlight")
public class BookFlight extends HttpServlet {

    static HttpServletRequest req;
    static HttpServletResponse resp;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        req = request;
        resp = response;
        TripDao tripDao = new TripDao();
        UserDao userDao = new UserDao();

        int flightID = Integer.parseInt(request.getParameter("flightID1"));
        int userID = Integer.parseInt(request.getParameter("userID"));

        TripID tripId = new TripID(flightID, userID);

            addTrip(tripId, tripDao);

        RequestDispatcher rd = request.getRequestDispatcher("browseFlights.jsp");
        rd.forward(request, response);

    }

    public static void addTrip(TripID tripId, TripDao tripDao) throws ServletException, IOException {
//    try {
        tripDao.addTrip(tripId);
//    } catch (ServletException e) {
//        String destination = "";
//        destination = "bookForUser.jsp";
//        String message = "Could not add flight.  Please try again.";
//
//        req.setAttribute("message", message);
//        System.out.print("incorrect");
//        RequestDispatcher rd = req.getRequestDispatcher(destination);
//        rd.forward(req, resp);
//
//    }
    }

    public static void displayError() {

    }
}
