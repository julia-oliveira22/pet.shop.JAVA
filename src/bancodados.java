package com.petshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BancoDados {

    public static List<Pet> pets = new ArrayList<>();

    public static HashMap<String, Double> precos = new HashMap<>();

    static {
        precos.put("Banho", 50.0);
        precos.put("Tosa", 40.0);
        precos.put("Vacinação", 80.0);
        precos.put("Consulta", 100.0);
        precos.put("Desparasitação", 30.0);
        precos.put("Corte de Unhas", 20.0);
    }
}
