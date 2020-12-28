package com.example.rostmanafinal.Pojo;

import java.util.List;

public class HistoricalDataResponse {
    public List<StockPrice> prices;
    boolean isPending;
    long firstTradeDate;
    String id;
    public class StockPrice {
        public long date;
        float open;
        public float high;
        public float low;
        public float close;
        int volume;
        float adjclose;
    }

}
