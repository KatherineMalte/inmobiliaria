package com.inmobiliaria.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inmobiliaria.app.model.Persona;
import com.inmobiliaria.app.service.impl.PersonaServiceImpl;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ControllerServerlet
 */
@WebServlet(name = "PersonasServerlet", urlPatterns = { "/listPersonas" })
public class ControllerServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServerlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		
			String filtro = request.getParameter("listPersonas");
					List<Persona> listPersonas = new PersonaServiceImpl().findAllVisitaFiltro(filtro);
						request.setAttribute("listPersonas", listPersonas);
						request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
