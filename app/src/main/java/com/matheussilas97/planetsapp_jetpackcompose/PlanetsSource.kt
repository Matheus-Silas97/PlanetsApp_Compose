package com.matheussilas97.planetsapp_jetpackcompose

import com.matheussilas97.planetsapp_jetpackcompose.models.Planets

object PlanetsSource {

    fun solarSystemList(): List<Planets> {
        return listOf(
            Planets(name = "Mercurio", description = "Planeta mais próximo do sol", image = R.drawable.mercurio),
            Planets(name = "Venus", description = "Segundo planeta do sistema solar", image = R.drawable.venus),
            Planets(name = "Terra", description = "Nosso lar", image = R.drawable.earth),
            Planets(name = "Marte", description = "Planeta vermelho", image = R.drawable.mars),
            Planets(name = "Jupiter", description = "Planeta gasoso", image = R.drawable.jupiter),
            Planets(name = "Saturno", description = "Planeta dos anéis", image = R.drawable.saturno),
            Planets(name = "Uranu", description = "Penultimo planeta do sistema solar", image = R.drawable.uranu),
            Planets(name = "Netuno", description = "Último planeta do sistema solar", image = R.drawable.netuno)
        )
    }

}