package fr.efrei2023.tp1applsi2;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    private static final String LOGIN_VALIDE = "admin";
    private static final String MOT_DE_PASSE_VALIDE = "prograv";
    private static final String MESSAGE_ERREUR_CREDENTIAL_KO = "KO";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLoginSaisi(request.getParameter("champLogin"));
        utilisateur.setPrenomSaisi(request.getParameter("champPrenom"));
        utilisateur.setMotDePasseSaisi(request.getParameter("champMotDePasse"));

        request.setAttribute("utilisateur",utilisateur);

        request.setAttribute("messageErreur",MESSAGE_ERREUR_CREDENTIAL_KO);

        if(verifierInfoConnexion(utilisateur)) {
            try {
                request.getRequestDispatcher("bienvenu.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            request.setAttribute("messageErreur",MESSAGE_ERREUR_CREDENTIAL_KO);
            try {
                request.getRequestDispatcher("index.jsp").forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean verifierInfoConnexion(Utilisateur utilisateur){
    return (utilisateur.getLoginSaisi().equals(LOGIN_VALIDE) && utilisateur.getMotDePasseSaisi().equals(MOT_DE_PASSE_VALIDE));
    }

    public void destroy() {
    }
}

