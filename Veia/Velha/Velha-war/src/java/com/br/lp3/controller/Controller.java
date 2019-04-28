package com.br.lp3.controller;

import com.br.lp3.rmi.IA;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucas_Banana
 */
public class Controller extends HttpServlet {

    @EJB
    private IA gameManager;

    private HttpSession session;
    private String command;
    private List<Character> ocupado;
    private int pos;
    private int move;
    private String player;
    private int lastPCMove;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RemoteException, NotBoundException {
        
        ArrayList<Object> al;
        session = request.getSession();
        command = request.getParameter("command");
        player = (String) session.getAttribute("player");
        ocupado = (List<Character>) session.getAttribute("ocupado");
        
        if (ocupado == null || ocupado.size() < 1) {
            ocupado = gameManager.createArray();
        }
        if (command != null) {
            switch (command) {
                case "click":
                    pos = Integer.parseInt(request.getParameter("pos"));
                    ocupado.set(pos, player.charAt(0));
                    al = gameManager.checkWin(ocupado);
                    if ((boolean) al.get(0)) {
                        session.setAttribute("winner", al.get(1));
                        session.setAttribute("winnerPattern", al.get(2));
                        session.setAttribute("number", al.get(3));
                        session.removeAttribute("lastPcMove");
                        break;
                    }
                    move = gameManager.doMove(ocupado, player.charAt(0), pos);
                    if (move != -1) {
                        lastPCMove = move;
                        ocupado.set(lastPCMove, ("x".equals(player) ? 'o' : 'x'));
                        session.setAttribute("lastPcMove", lastPCMove);
                        session.setAttribute("lastPlayerMove", pos);
                        al = gameManager.checkWin(ocupado);
                        if ((boolean) al.get(0)) {
                            session.setAttribute("winner", al.get(1));
                            session.setAttribute("winnerPattern", al.get(2));
                            session.setAttribute("number", al.get(3));
                        }
                    }
                    session.setAttribute("continuar", true);
                    session.setAttribute("ocupado", ocupado);
                    break;

                case "start":
                    session.setAttribute("player", request.getParameter("player"));
                    player = (String) session.getAttribute("player");
                    if ("o".equals(player)) {
                        lastPCMove = gameManager.doMove(ocupado, player.charAt(0), pos);
                        ocupado.set(lastPCMove, ("x".equals(player) ? 'o' : 'x'));
                        session.setAttribute("ocupado", ocupado);
                        session.setAttribute("lastPcMove", lastPCMove);
                        session.setAttribute("lastPlayerMove", pos);
                    }
                    session.setAttribute("continuar", true);
                    break;
                case "again":
                    session.invalidate();
                    break;
            }
        }
        response.sendRedirect("index.jsp");

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
            throws ServletException, IOException, RemoteException {
        try {
            processRequest(request, response);
        } catch (NotBoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException, RemoteException {
        try {
            processRequest(request, response);
        } catch (NotBoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
