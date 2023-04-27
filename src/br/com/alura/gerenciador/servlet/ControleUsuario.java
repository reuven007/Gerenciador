package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controle")
public class ControleUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("Parabensssss Reuven, apos muita dor de cabeca, vc CONSEGUIU SEU SERVLET !!!");
		out.println(" ALELUIAAA");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");

		System.out.println("Servlet foi chamado...interessante!");
		System.out.println("aaa");

		
		
		
	}
	
}
