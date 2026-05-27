package com.ifms.lp3spring.Interface;

import com.ifms.lp3spring.model.HoleriteModel;

public class CalculoSalarioGerente implements CalculoSalario {
    @Override
    public double calcular(HoleriteModel holerite) {
        double salarioBase = holerite.getSalarioBase();
        double desconto = holerite.getDescontos();
        double beneficio = holerite.getBeneficios();
        double bonus = 1000.0;

        return salarioBase + beneficio + bonus - desconto;
    }
}
