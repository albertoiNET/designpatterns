# Proxy

## Intención

Interponer un sustituto con la misma interfaz que el objeto real para controlar su acceso,
añadir caché o retrasar operaciones costosas.

## Ejemplo

`ResearchArchiveProxy` protege los documentos restringidos antes de consultar el archivo
remoto y almacena en caché los documentos autorizados para evitar cargas repetidas.

## Participantes

- **Subject:** `ResearchArchive`
- **Real subject:** `RemoteResearchArchive`
- **Proxy:** `ResearchArchiveProxy`

```bash
mvn -pl proxy -am test
```
