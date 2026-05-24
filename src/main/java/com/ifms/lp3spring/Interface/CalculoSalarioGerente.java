package com.ifms.lp3spring.Interface;

import com.ifms.lp3spring.model.HoleriteModel;

public class CalculoSalarioGerente implements CalculoSalario {
    @Override
    public double calcular(HoleriteModel holerite) {
        // Exemplo: gerente recebe bônus fixo
        return holerite.getSalarioBase() - holerite.getDescontos() + holerite.getBeneficios() + 1000.0;
    }
}
   

