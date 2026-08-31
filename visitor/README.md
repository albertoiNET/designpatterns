# Visitor

## Intención

Separar operaciones de la estructura de objetos sobre la que actúan, permitiendo añadir
nuevas operaciones sin modificar las clases de los elementos.

## Ejemplo

Hábitats, estaciones de guardabosques y abrevaderos aceptan visitantes. Una inspección de
seguridad produce hallazgos específicos y otro visitante calcula horas de mantenimiento.

## Participantes

- **Element:** `ReserveAsset`
- **Concrete elements:** `AnimalHabitat`, `RangerStation`, `WateringHole`
- **Visitor:** `ReserveAssetVisitor`
- **Concrete visitors:** `SafetyInspectionVisitor`, `MaintenanceHoursVisitor`

```bash
mvn -pl visitor -am test
```
