package com.matheussilas97.planetsapp_jetpackcompose

import com.matheussilas97.planetsapp_jetpackcompose.models.Planets

class PlanetsSource {

    fun solarSystemList(): List<Planets> {
        return listOf(
            Planets(name = "Mercurio", description = "Planeta mais próximo do sol", image = 0),
            Planets(name = "Venus", description = "Segundo planeta do sistema solar", image = 0),
            Planets(name = "Terra", description = "Nosso lar", image = 0),
            Planets(name = "Marte", description = "Planeta vermelho", image = 0),
            Planets(name = "Jupiter", description = "Planeta gasoso", image = 0),
            Planets(name = "Saturno", description = "Planeta dos anéis", image = 0),
            Planets(name = "Uranu", description = "Penultimo planeta do sistema solar", image = 0),
            Planets(name = "Netuno", description = "Último planeta do sistema solar", image = 0)
        )
    }

}