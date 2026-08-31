package net.albertoi.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProxyTest {

    private RemoteResearchArchive remoteArchive;
    private ResearchArchiveProxy proxy;

    @BeforeEach
    void setUp() {
        remoteArchive = new RemoteResearchArchive();
        proxy = new ResearchArchiveProxy(remoteArchive);
    }

    @Test
    void cachesRemoteDocumentsBehindTheSameInterface() {
        String first = proxy.open("public-catalog", AccessLevel.PUBLIC);
        String second = proxy.open("public-catalog", AccessLevel.RESEARCHER);

        assertEquals(first, second);
        assertEquals(1, remoteArchive.loadCount());
        assertEquals(1, proxy.cachedDocumentCount());
    }

    @Test
    void rejectsRestrictedDocumentsBeforeContactingTheRemoteArchive() {
        assertThrows(
            SecurityException.class,
            () -> proxy.open("restricted-location", AccessLevel.RESEARCHER)
        );
        assertEquals(0, remoteArchive.loadCount());
    }

    @Test
    void permitsCuratorsToOpenRestrictedDocuments() {
        assertEquals(
            "Encrypted coordinates of the backup vault",
            proxy.open("restricted-location", AccessLevel.CURATOR)
        );
        assertEquals(1, remoteArchive.loadCount());
    }
}
