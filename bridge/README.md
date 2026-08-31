# Bridge

## Intención

Separar una abstracción de su implementación para que las dos dimensiones puedan variar
independientemente y sin crear una subclase por cada combinación.

## Ejemplo

Los boletines pueden ser rutinarios o de emergencia, mientras que su entrega puede hacerse
por radio de montaña o por un panel del sendero. Cualquier boletín funciona con cualquier
canal.

## Participantes

- **Abstraction:** `SafetyBulletin`
- **Refined abstractions:** `RoutineBulletin`, `EmergencyBulletin`
- **Implementor:** `DeliveryChannel`
- **Concrete implementors:** `MountainRadio`, `TrailDisplay`

```bash
mvn -pl bridge -am test
```
