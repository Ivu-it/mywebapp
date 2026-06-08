package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Service.AthletesService;

/**
 * Servlet implementation class Athletes
 */
@WebServlet("/Athletes")
public class Athletes extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private AthletesService as = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Athletes() {
        super();
//        as = new AthletesService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AthletesService as = new AthletesService();
		request.setAttribute("athletes", as.getAthletes());
		request.getRequestDispatcher("/athletes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
