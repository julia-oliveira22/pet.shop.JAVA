package com.petshop;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/cadastrar")
public class CadastrarPetServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String nomePet = request.getParameter("nome_pet");
        String nomeDono = request.getParameter("nome_dono");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String[] servicosArr = request.getParameterValues("servicos");

        if (servicosArr == null) {
            response.getWriter().println("Erro: selecione pelo menos um serviço.");
            return;
        }

        List<String> servicos = Arrays.asList(servicosArr);

        double preco = 0.0;
        for (String s : servicos) {
            preco += BancoDados.precos.get(s);
        }

        BancoDados.pets.add(new Pet(nomePet, nomeDono, telefone, email, servicos, preco));

        response.sendRedirect("index.html");
    }
}
