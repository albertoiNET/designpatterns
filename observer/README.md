# Observer

## Intención

Definir una relación de suscripción para notificar automáticamente a varios objetos cuando
cambia el estado de un sujeto.

## Ejemplo

Una estación de bicicletas publica una instantánea después de cada alquiler o devolución.
Una alerta para ciclistas filtra la disponibilidad que le interesa y un panel de
mantenimiento registra todas las actualizaciones.

## Participantes

- **Subject:** `BicycleStation`
- **Observer:** `StationObserver`
- **Concrete observers:** `RiderAvailabilityAlert`, `MaintenanceDashboard`
- **Notification value:** `StationSnapshot`

```bash
mvn -pl observer -am test
```
