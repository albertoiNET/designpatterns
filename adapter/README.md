# Adapter

## Intención

Convertir la interfaz de una clase existente en la interfaz que espera el cliente, de modo
que ambas puedan colaborar sin modificar el código heredado.

## Ejemplo

La aplicación consulta libros mediante `LibraryInventory`, pero `LegacyBookRegistry`
devuelve registros de texto delimitados. `LegacyBookRegistryAdapter` traduce esos datos a
objetos `Book` y conserva el contrato moderno basado en `Optional`.

## Participantes

- **Target:** `LibraryInventory`
- **Adaptee:** `LegacyBookRegistry`
- **Adapter:** `LegacyBookRegistryAdapter`
- **Client model:** `Book`

```bash
mvn -pl adapter -am test
```
