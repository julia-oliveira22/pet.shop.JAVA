package com.petshop;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/buscar")
public class BuscarPetServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String dono = request.getParameter("busca_dono").toLowerCase();
        String petNome = request.getParameter("busca_pet").toLowerCase();
        String servico = request.getParameter("busca_servico");

        List<Pet> resultados = new ArrayList<>();

        for (Pet p : BancoDados.pets) {
            boolean ok = true;

            if (!dono.isEmpty() && !p.getNomeDono().toLowerCase().contains(dono)) ok = false;
            if (!petNome.isEmpty() && !p.getNomePet().toLowerCase().contains(petNome)) ok = false;
            if (!servico.isEmpty() && !p.getServicos().contains(servico)) ok = false;

            if (ok) resultados.add(p);
        }

        response.setContentType("text/html;charset=UTF-8");
        for (Pet p : resultados) {
            response.getWriter().println("<p>Pet: " + p.getNomePet() +
                    " | Dono: " + p.getNomeDono() +
                    " | Telefone: " + p.getTelefone() +
                    " | Email: " + p.getEmail() +
                    " | Serviços: " + p.getServicos() +
                    " | Preço: R$ " + p.getPreco() + "</p><hr>");
        }
    }
}
