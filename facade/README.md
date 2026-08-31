# Facade

## Intención

Proporcionar una interfaz unificada y sencilla para un subsistema compuesto por varias
clases y operaciones.

## Ejemplo

Publicar un pódcast requiere normalizar audio, generar una transcripción y actualizar el
feed. `PodcastPublishingFacade` coordina todo el proceso mediante una sola operación
`publish`.

## Participantes

- **Facade:** `PodcastPublishingFacade`
- **Subsystem:** `AudioNormalizer`, `TranscriptGenerator`, `PodcastFeed`
- **Input/output:** `Episode`, `PublishedEpisode`

```bash
mvn -pl facade -am test
```
