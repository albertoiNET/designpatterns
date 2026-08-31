# Composite

## Intención

Componer objetos en estructuras de árbol y permitir que el cliente trate de la misma forma
un elemento individual y un grupo completo.

## Ejemplo

Un plan de mantenimiento contiene tareas individuales y zonas que, a su vez, pueden incluir
otras zonas. El tiempo y los nombres de las tareas se calculan recursivamente con el mismo
contrato.

## Participantes

- **Component:** `MaintenanceItem`
- **Leaf:** `MaintenanceTask`
- **Composite:** `MaintenanceZone`

```bash
mvn -pl composite -am test
```
