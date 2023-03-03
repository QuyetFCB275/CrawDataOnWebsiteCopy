package com.craw.data.service.craw;

import java.io.IOException;

public interface CrawData {
    Integer getTotalElementPages() throws IOException;

    void crawData() throws IOException, InterruptedException;

}
