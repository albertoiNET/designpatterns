# State

## Intención

Permitir que un objeto cambie su comportamiento cuando cambia su estado interno, delegando
cada conjunto de reglas en un objeto de estado.

## Ejemplo

Un alquiler de patinete atraviesa los estados disponible, en marcha, pausado y completado.
Acciones como acumular minutos o reanudar son válidas solo en determinados estados.

## Participantes

- **Context:** `ScooterRental`
- **State:** `RentalState`
- **Concrete states:** `AvailableState`, `RidingState`, `PausedState`, `CompletedState`

```bash
mvn -pl state -am test
```
