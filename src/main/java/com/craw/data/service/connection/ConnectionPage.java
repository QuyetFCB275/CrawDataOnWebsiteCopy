package com.craw.data.service.connection;

import org.jsoup.nodes.Document;

import java.io.IOException;

public interface ConnectionPage {

    Document getConnection(String url) throws IOException;

    Document getConnection(String url, int page) throws IOException;
}
