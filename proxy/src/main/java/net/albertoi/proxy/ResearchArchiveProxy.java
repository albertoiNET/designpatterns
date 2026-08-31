package net.albertoi.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ResearchArchiveProxy implements ResearchArchive {

    private static final Set<String> RESTRICTED_DOCUMENTS = Set.of("restricted-location");

    private final ResearchArchive remoteArchive;
    private final Map<String, String> cache = new HashMap<>();

    public ResearchArchiveProxy(ResearchArchive remoteArchive) {
        this.remoteArchive = remoteArchive;
    }

    @Override
    public String open(String documentId, AccessLevel accessLevel) {
        if (RESTRICTED_DOCUMENTS.contains(documentId) && accessLevel != AccessLevel.CURATOR) {
            throw new SecurityException("Curator access is required for " + documentId);
        }
        return cache.computeIfAbsent(
            documentId,
            id -> remoteArchive.open(id, accessLevel)
        );
    }

    public int cachedDocumentCount() {
        return cache.size();
    }
}
