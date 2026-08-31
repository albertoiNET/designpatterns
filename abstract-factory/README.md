# Abstract Factory

## Intención

Crear familias de objetos relacionados sin hacer que el cliente dependa de sus clases
concretas. La fábrica elegida garantiza que los productos de una misma familia sean
compatibles.

## Ejemplo

`EventPlanner` prepara un recinto usando dos productos: iluminación y climatización.
`IndoorEquipmentFactory` entrega el conjunto para interiores y
`OutdoorEquipmentFactory` sustituye la familia completa por la de exteriores.

## Participantes

- **Abstract factory:** `VenueEquipmentFactory`
- **Concrete factories:** `IndoorEquipmentFactory`, `OutdoorEquipmentFactory`
- **Abstract products:** `Lighting`, `ClimateControl`
- **Concrete products:** `CeilingLighting`, `PathLighting`, `AirConditioning`, `MistCooling`
- **Client:** `EventPlanner`

```bash
mvn -pl abstract-factory -am test
```
