# Template Method

## Intención

Definir el esqueleto de un algoritmo en una clase base y permitir que las subclases
personalicen pasos concretos sin alterar su orden.

## Ejemplo

Todo tueste inspecciona el grano, precalienta, desarrolla, enfría y reposa. Los flujos de
tueste claro y oscuro modifican temperatura, desarrollo y reposo conservando esa secuencia.

## Participantes

- **Abstract class:** `CoffeeRoastingWorkflow`
- **Concrete classes:** `LightRoastWorkflow`, `DarkRoastWorkflow`
- **Input/output:** `GreenCoffeeBatch`, `RoastReport`

```bash
mvn -pl template-method -am test
```
