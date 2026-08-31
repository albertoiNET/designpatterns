# Iterator

## Intención

Recorrer los elementos de una colección sin revelar su estructura interna y permitiendo
distintas estrategias de recorrido.

## Ejemplo

`ObservationLog` almacena observaciones astronómicas. Ofrece un iterador cronológico y otro
que devuelve solo objetos más brillantes que un límite, ambos con estado de recorrido
independiente.

## Participantes

- **Aggregate:** `ObservationLog`
- **Element:** `Observation`
- **Concrete iterators:** `ChronologicalObservationIterator`, `BrightObservationIterator`

```bash
mvn -pl iterator -am test
```
