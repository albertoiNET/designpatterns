# Flyweight

## Intención

Reducir el consumo de memoria compartiendo entre muchos objetos el estado inmutable que se
repite, mientras el estado específico permanece fuera del objeto compartido.

## Ejemplo

Cada parada conserva nombre y coordenadas propios, pero las paradas de la misma línea
comparten un único `TransitSymbolStyle`. La fábrica crea un estilo solo cuando todavía no
existe en caché.

## Participantes

- **Flyweight:** `TransitSymbolStyle`
- **Flyweight factory:** `TransitSymbolFactory`
- **Context:** `TransitStopMarker`
- **Client:** `TransitMap`

```bash
mvn -pl flyweight -am test
```
