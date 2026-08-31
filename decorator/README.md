# Decorator

## Intención

Añadir responsabilidades a un objeto de forma dinámica envolviéndolo con componentes que
mantienen la misma interfaz.

## Ejemplo

`BasicShippingLabel` genera una etiqueta sencilla. `TrackingLabel` y `ColdChainLabel`
pueden aplicarse por separado o apilarse en cualquier orden para incorporar seguimiento y
requisitos de temperatura.

## Participantes

- **Component:** `ShippingLabel`
- **Concrete component:** `BasicShippingLabel`
- **Base decorator:** `ShippingLabelDecorator`
- **Concrete decorators:** `TrackingLabel`, `ColdChainLabel`

```bash
mvn -pl decorator -am test
```
