package net.albertoi.proxy;

import java.util.Map;

public class RemoteResearchArchive implements ResearchArchive {

    private final Map<String, String> documents = Map.of(
        "public-catalog", "Public seed catalog: 1,240 varieties",
        "restricted-location", "Encrypted coordinates of the backup vault"
    );
    private int loadCount;

    @Override
    public String open(String documentId, AccessLevel accessLevel) {
        loadCount++;
        String document = documents.get(documentId);
        if (document == null) {
            throw new IllegalArgumentException("Unknown archive document: " + documentId);
        }
        return document;
    }

    public int loadCount() {
        return loadCount;
    }
}
