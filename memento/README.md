# Memento

## Intención

Capturar y restaurar el estado interno de un objeto sin exponer sus detalles ni romper su
encapsulación.

## Ejemplo

Una campaña de juego guarda capítulo, ubicación, salud y fecha en puntos de guardado
inmutables. `CampaignArchive` conserva varios puntos y el originador puede restaurarlos más
tarde.

## Participantes

- **Originator:** `BoardGameCampaign`
- **Memento:** `CampaignSavePoint`
- **Caretaker:** `CampaignArchive`

```bash
mvn -pl memento -am test
```
