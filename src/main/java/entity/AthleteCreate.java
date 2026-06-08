package entity;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Service.AthletesService;

/**
 * Servlet implementation class AthleteCreate
 */
@WebServlet("/AthleteCreate")
public class AthleteCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/athlete_create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name1 = request.getParameter("name1");
		String name2 = request.getParameter("name2");
		int eventId = Integer.parseInt(request.getParameter("event_id"));
		String gender = request.getParameter("gender");

		AthletesService as = new AthletesService();
		as.createAthlete(name1, name2, eventId, gender);

		response.sendRedirect("Athletes");
	}

}
