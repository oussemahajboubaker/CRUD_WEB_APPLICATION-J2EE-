package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDAO;
import beans.Employee;

/**
 * Servlet implementation class SupprimerEmployee
 */
@WebServlet("/SupprimerEmployee")
public class SupprimerEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		 EmployeeDAO employeeDAO = new EmployeeDAO();
		 Employee  employee = employeeDAO.findEmployee(id);
		 if (employee != null) {
	            boolean deleted = employeeDAO.deleteLigPresence(id);
	            if (deleted == true ){
	                response.sendRedirect("Employee/AfficherEmployee.jsp");
	            }//ajout dalert 
		 }}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
