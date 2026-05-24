package com.ifms.lp3spring.Interface;

import com.ifms.lp3spring.model.HoleriteModel;

public class CalculoSalarioCoordenador implements CalculoSalario {

    @Override
    public double calcular(HoleriteModel holerite) {
        // Lógica específica para coordenadores
        double salarioBase = holerite.getSalarioBase();
        double beneficios = holerite.getBeneficios() != null ? holerite.getBeneficios() : 0;
        double descontos = holerite.getDescontos() != null ? holerite.getDescontos() : 0;

        // Exemplo de cálculo: salário base + benefícios - descontos + bônus específico para coordenadores
        double bonusCoordenador = 500.00; // Valor fixo de bônus para coordenadores
        return salarioBase + beneficios - descontos + bonusCoordenador;
    }
    
}
