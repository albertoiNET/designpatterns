# Chain of Responsibility

## Intención

Evitar que el emisor de una petición conozca quién la resolverá, pasando la solicitud por
una cadena de manejadores hasta encontrar uno apropiado.

## Ejemplo

Las peticiones de un huerto comunitario pasan por la persona responsable de voluntariado,
la coordinación y, finalmente, la junta. Cada nivel aprueba únicamente solicitudes dentro
de sus límites de horas y presupuesto.

## Participantes

- **Handler:** `RequestHandler`
- **Base handler:** `ApprovalHandler`
- **Concrete handlers:** `VolunteerLead`, `GardenCoordinator`, `CommunityBoard`
- **Request/result:** `GardenRequest`, `Approval`

```bash
mvn -pl chain-of-responsibility -am test
```
