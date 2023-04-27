package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("editarEmpresa")
public class editaEmpresaServlet {
	public class removeEmmpresaServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String[] itensSelecionados = request.getParameterValues("item");
	        if (itensSelecionados != null && itensSelecionados.length > 0) {
	            Connection conn = null;
	            PreparedStatement ps = null;
	            try {
	                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/meubanco", "usuario", "senha");
	                String sql = "DELETE FROM itens WHERE id = ?";
	                ps = conn.prepareStatement(sql);
	                for (String item : itensSelecionados) {
	                    ps.setInt(1, Integer.parseInt(item));
	                    ps.executeUpdate();
	                }
	                response.sendRedirect("listaItens.jsp");
	            } catch (SQLException e) {
	                e.printStackTrace();
	                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir item.");
	            } finally {
	                if (ps != null) {
	                    try {
	                        ps.close();
	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                    }
	                }
	                if (conn != null) {
	                    try {
	                        conn.close();
	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        } else {
	            response.sendRedirect("listaItens.jsp");
	        }
	    }
	}
}
