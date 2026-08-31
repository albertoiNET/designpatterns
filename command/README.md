# Command

## Intención

Encapsular una petición como un objeto para desacoplar quién solicita la acción de quién la
ejecuta, y facilitar historial, colas o deshacer.

## Ejemplo

Una consola de observación envía comandos para orientar un telescopio y abrir su obturador.
Cada comando recuerda lo necesario para revertirse y la consola los deshace en orden
inverso.

## Participantes

- **Command:** `TelescopeCommand`
- **Concrete commands:** `SlewCommand`, `OpenShutterCommand`
- **Receiver:** `Telescope`
- **Invoker:** `ObservationConsole`

```bash
mvn -pl command -am test
```
