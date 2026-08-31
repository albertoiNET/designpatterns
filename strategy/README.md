# Strategy

## Intención

Definir una familia de algoritmos intercambiables y hacer que el cliente pueda elegirlos o
cambiarlos en tiempo de ejecución.

## Ejemplo

Una cooperativa solar distribuye energía escasa. Puede repartirla por igual o atender
primero a los hogares esenciales sin cambiar el contexto ni el modelo de hogar.

## Participantes

- **Strategy:** `EnergyAllocationStrategy`
- **Concrete strategies:** `EqualShareStrategy`, `PriorityFirstStrategy`
- **Context:** `SolarCooperative`
- **Model:** `Household`, `EnergyPriority`

```bash
mvn -pl strategy -am test
```
