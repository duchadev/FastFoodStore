package guest.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import admin.controller.ListProductServlet;
import dal.CustomerDAO;
import dal.DishDAO;
import dal.StaffDAO;
import dal.StoreDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.Dish;
import model.Staff;
import model.Store;

/**
 *
 * @author HAU
 */
public class ListProductGuest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListProductGuest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListProductGuest at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
           DishDAO dishDao = new DishDAO();
            StaffDAO staffDAO = new StaffDAO();
            StoreDAO storeDAO = new StoreDAO();
            CustomerDAO customerDAO = new CustomerDAO();
            ArrayList<Dish> list = dishDao.getAll();
            int products = list.size();
            ArrayList<Staff> workerList = staffDAO.getAll();
            int workers = workerList.size();
            ArrayList<Store> storeList = storeDAO.getAll();
            int stores = storeList.size();
            ArrayList<Customer> customerList = customerDAO.getAllCustomer();
            int customers = customerList.size();
             request.setAttribute("products", products);
             request.setAttribute("workers", workers);
             request.setAttribute("stores", stores);
             request.setAttribute("customers", customers);
            request.setAttribute("listss", list); // request scope
//            ArrayList<Dish> breakfast = dishDao.getAll();
            List<Dish> listTypeF = dishDao.getDishByType("f");
            request.setAttribute("listTypeF", listTypeF);
//            request.setAttribute("break", breakfast);
            List<Dish> listTypeC = dishDao.getDishByType("c");
            request.setAttribute("listTypeC", listTypeC);
            List<Dish> listPriceI = dishDao.getDishByType("i");
            request.setAttribute("listPriceI", listPriceI);
            List<Dish> listPriceD = dishDao.getDishByType("d");
            request.setAttribute("listPriceD", listPriceD);
            request.getRequestDispatcher("guest.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
