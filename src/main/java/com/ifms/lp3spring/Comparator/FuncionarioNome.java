package com.ifms.lp3spring.Comparator;

import java.util.Comparator;

import com.ifms.lp3spring.model.FuncionarioModel;

public class FuncionarioNome implements Comparator<FuncionarioModel> {
    @Override
    public int compare(FuncionarioModel f1, FuncionarioModel f2) {
        return f1.getNome().compareToIgnoreCase(f2.getNome());
    }
    
}
