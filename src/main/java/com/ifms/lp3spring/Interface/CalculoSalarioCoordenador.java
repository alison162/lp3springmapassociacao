package com.ifms.lp3spring.Interface;

import com.ifms.lp3spring.model.HoleriteModel;

public class CalculoSalarioCoordenador implements CalculoSalario {

    @Override
    public double calcular(HoleriteModel holerite) {

        double salarioBase = holerite.getSalarioBase();
        double beneficios = holerite.getBeneficios() != null ? holerite.getBeneficios() : 0;
        double descontos = holerite.getDescontos() != null ? holerite.getDescontos() : 0;

        double bonusCoordenador = 500.00;
        return salarioBase + beneficios - descontos + bonusCoordenador;
    }

}
