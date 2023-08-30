 
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

public class SkodaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CarsDAO carsDAO;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        carsDAO = new CarsDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
            System.out.println("New ");
                showNewForm(request, response);
                break;
            case "/insert":
                insertCar(request, response);
                break;
            case "/delete":
                deleteBook(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateBook(request, response);
                break;
            default:
                listCars(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listCars(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Cars> listCars = carsDAO.listAllCars();
        request.setAttribute("listCars", listCars);
        RequestDispatcher dispatcher = request.getRequestDispatcher("carList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("carForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cars existingCar = carsDAO.getCar(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("carForm.jsp");
        request.setAttribute("car", existingCar);
        dispatcher.forward(request, response);
 
    }
 
    private void insertCar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name  = request.getParameter("name");
        String type = request.getParameter("type");
        String fuel = request.getParameter("fuel");
        String price = request.getParameter("price");

        int seater = Integer.parseInt(request.getParameter("seater"));
 
        Cars newBook = new Cars(name,type,fuel,price,seater);
        carsDAO.insertCar(newBook);
        response.sendRedirect("listCars");
    }
 
    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
    String name  = request.getParameter("name");
        String type = request.getParameter("type");
        String fuel = request.getParameter("fuel");
        String price = request.getParameter("price");
        int seater = Integer.parseInt(request.getParameter("seater"));
 
        Cars car = new Cars(id,name,type,fuel,price,seater);
        carsDAO.updateCar(car);
        response.sendRedirect("listCars");
    }
 
    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Cars book = new Cars(id);
        carsDAO.deleteCar(book);
        response.sendRedirect("listCars");
 
    }
}