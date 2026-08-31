# Mediator

## Intención

Reducir las dependencias directas entre objetos haciendo que su comunicación pase por un
mediador central.

## Ejemplo

Durante una grabación, músico, técnico y cabina no se controlan mutuamente. Comunican sus
eventos al mediador, que enciende la señal, inicia la grabación y coordina el cierre de cada
toma.

## Participantes

- **Mediator:** `StudioMediator`
- **Concrete mediator:** `RecordingSessionMediator`
- **Colleagues:** `Musician`, `SoundEngineer`, `RecordingBooth`
- **Events:** `StudioEvent`

```bash
mvn -pl mediator -am test
```
