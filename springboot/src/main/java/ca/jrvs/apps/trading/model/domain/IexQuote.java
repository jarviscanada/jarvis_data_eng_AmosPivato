
package ca.jrvs.apps.trading.model.domain;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "avgTotalVolume",
        "calculationPrice",
        "change",
        "changePercent",
        "close",
        "closeSource",
        "closeTime",
        "companyName",
        "currency",
        "delayedPrice",
        "delayedPriceTime",
        "extendedChange",
        "extendedChangePercent",
        "extendedPrice",
        "extendedPriceTime",
        "high",
        "highSource",
        "highTime",
        "iexAskPrice",
        "iexAskSize",
        "iexBidPrice",
        "iexBidSize",
        "iexClose",
        "iexCloseTime",
        "iexLastUpdated",
        "iexMarketPercent",
        "iexOpen",
        "iexOpenTime",
        "iexRealtimePrice",
        "iexRealtimeSize",
        "iexVolume",
        "lastTradeTime",
        "latestPrice",
        "latestSource",
        "latestTime",
        "latestUpdate",
        "latestVolume",
        "low",
        "lowSource",
        "lowTime",
        "marketCap",
        "oddLotDelayedPrice",
        "oddLotDelayedPriceTime",
        "open",
        "openTime",
        "openSource",
        "peRatio",
        "previousClose",
        "previousVolume",
        "primaryExchange",
        "symbol",
        "volume",
        "week52High",
        "week52Low",
        "ytdChange",
        "isUSMarketOpen"
})
@Generated("jsonschema2pojo")
public class IexQuote {

    @JsonProperty("avgTotalVolume")
    private long avgTotalVolume;
    @JsonProperty("calculationPrice")
    private String calculationPrice;
    @JsonProperty("change")
    private long change;
    @JsonProperty("changePercent")
    private double changePercent;
    @JsonProperty("close")
    private Object close;
    @JsonProperty("closeSource")
    private String closeSource;
    @JsonProperty("closeTime")
    private Object closeTime;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("delayedPrice")
    private Object delayedPrice;
    @JsonProperty("delayedPriceTime")
    private Object delayedPriceTime;
    @JsonProperty("extendedChange")
    private Object extendedChange;
    @JsonProperty("extendedChangePercent")
    private Object extendedChangePercent;
    @JsonProperty("extendedPrice")
    private Object extendedPrice;
    @JsonProperty("extendedPriceTime")
    private Object extendedPriceTime;
    @JsonProperty("high")
    private Object high;
    @JsonProperty("highSource")
    private Object highSource;
    @JsonProperty("highTime")
    private Object highTime;
    @JsonProperty("iexAskPrice")
    private double iexAskPrice;
    @JsonProperty("iexAskSize")
    private long iexAskSize;
    @JsonProperty("iexBidPrice")
    private double iexBidPrice;
    @JsonProperty("iexBidSize")
    private long iexBidSize;
    @JsonProperty("iexClose")
    private double iexClose;
    @JsonProperty("iexCloseTime")
    private long iexCloseTime;
    @JsonProperty("iexLastUpdated")
    private long iexLastUpdated;
    @JsonProperty("iexMarketPercent")
    private double iexMarketPercent;
    @JsonProperty("iexOpen")
    private double iexOpen;
    @JsonProperty("iexOpenTime")
    private long iexOpenTime;
    @JsonProperty("iexRealtimePrice")
    private double iexRealtimePrice;
    @JsonProperty("iexRealtimeSize")
    private long iexRealtimeSize;
    @JsonProperty("iexVolume")
    private long iexVolume;
    @JsonProperty("lastTradeTime")
    private long lastTradeTime;
    @JsonProperty("latestPrice")
    private double latestPrice;
    @JsonProperty("latestSource")
    private String latestSource;
    @JsonProperty("latestTime")
    private String latestTime;
    @JsonProperty("latestUpdate")
    private long latestUpdate;
    @JsonProperty("latestVolume")
    private Object latestVolume;
    @JsonProperty("low")
    private Object low;
    @JsonProperty("lowSource")
    private Object lowSource;
    @JsonProperty("lowTime")
    private Object lowTime;
    @JsonProperty("marketCap")
    private long marketCap;
    @JsonProperty("oddLotDelayedPrice")
    private Object oddLotDelayedPrice;
    @JsonProperty("oddLotDelayedPriceTime")
    private Object oddLotDelayedPriceTime;
    @JsonProperty("open")
    private Object open;
    @JsonProperty("openTime")
    private Object openTime;
    @JsonProperty("openSource")
    private String openSource;
    @JsonProperty("peRatio")
    private double peRatio;
    @JsonProperty("previousClose")
    private double previousClose;
    @JsonProperty("previousVolume")
    private long previousVolume;
    @JsonProperty("primaryExchange")
    private String primaryExchange;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("volume")
    private Object volume;
    @JsonProperty("week52High")
    private double week52High;
    @JsonProperty("week52Low")
    private double week52Low;
    @JsonProperty("ytdChange")
    private double ytdChange;
    @JsonProperty("isUSMarketOpen")
    private boolean isUSMarketOpen;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public IexQuote() {
    }

    /**
     *
     * @param symbol
     * @param highTime
     * @param avgTotalVolume
     * @param companyName
     * @param openSource
     * @param delayedPrice
     * @param iexMarketPercent
     * @param primaryExchange
     * @param latestUpdate
     * @param high
     * @param iexOpenTime
     * @param delayedPriceTime
     * @param extendedPrice
     * @param week52Low
     * @param highSource
     * @param latestPrice
     * @param marketCap
     * @param iexClose
     * @param volume
     * @param ytdChange
     * @param lastTradeTime
     * @param closeSource
     * @param extendedChange
     * @param iexRealtimePrice
     * @param calculationPrice
     * @param extendedChangePercent
     * @param latestSource
     * @param iexOpen
     * @param iexBidPrice
     * @param previousClose
     * @param peRatio
     * @param isUSMarketOpen
     * @param low
     * @param oddLotDelayedPrice
     * @param extendedPriceTime
     * @param changePercent
     * @param closeTime
     * @param currency
     * @param week52High
     * @param openTime
     * @param close
     * @param iexCloseTime
     * @param oddLotDelayedPriceTime
     * @param previousVolume
     * @param iexRealtimeSize
     * @param iexLastUpdated
     * @param change
     * @param iexAskPrice
     * @param latestVolume
     * @param lowSource
     * @param iexVolume
     * @param iexAskSize
     * @param latestTime
     * @param iexBidSize
     * @param lowTime
     * @param open
     */
    public IexQuote(long avgTotalVolume, String calculationPrice, long change, double changePercent, Object close, String closeSource, Object closeTime, String companyName, String currency, Object delayedPrice, Object delayedPriceTime, Object extendedChange, Object extendedChangePercent, Object extendedPrice, Object extendedPriceTime, Object high, Object highSource, Object highTime, double iexAskPrice, long iexAskSize, double iexBidPrice, long iexBidSize, double iexClose, long iexCloseTime, long iexLastUpdated, double iexMarketPercent, double iexOpen, long iexOpenTime, double iexRealtimePrice, long iexRealtimeSize, long iexVolume, long lastTradeTime, double latestPrice, String latestSource, String latestTime, long latestUpdate, Object latestVolume, Object low, Object lowSource, Object lowTime, long marketCap, Object oddLotDelayedPrice, Object oddLotDelayedPriceTime, Object open, Object openTime, String openSource, double peRatio, double previousClose, long previousVolume, String primaryExchange, String symbol, Object volume, double week52High, double week52Low, double ytdChange, boolean isUSMarketOpen) {
        super();
        this.avgTotalVolume = avgTotalVolume;
        this.calculationPrice = calculationPrice;
        this.change = change;
        this.changePercent = changePercent;
        this.close = close;
        this.closeSource = closeSource;
        this.closeTime = closeTime;
        this.companyName = companyName;
        this.currency = currency;
        this.delayedPrice = delayedPrice;
        this.delayedPriceTime = delayedPriceTime;
        this.extendedChange = extendedChange;
        this.extendedChangePercent = extendedChangePercent;
        this.extendedPrice = extendedPrice;
        this.extendedPriceTime = extendedPriceTime;
        this.high = high;
        this.highSource = highSource;
        this.highTime = highTime;
        this.iexAskPrice = iexAskPrice;
        this.iexAskSize = iexAskSize;
        this.iexBidPrice = iexBidPrice;
        this.iexBidSize = iexBidSize;
        this.iexClose = iexClose;
        this.iexCloseTime = iexCloseTime;
        this.iexLastUpdated = iexLastUpdated;
        this.iexMarketPercent = iexMarketPercent;
        this.iexOpen = iexOpen;
        this.iexOpenTime = iexOpenTime;
        this.iexRealtimePrice = iexRealtimePrice;
        this.iexRealtimeSize = iexRealtimeSize;
        this.iexVolume = iexVolume;
        this.lastTradeTime = lastTradeTime;
        this.latestPrice = latestPrice;
        this.latestSource = latestSource;
        this.latestTime = latestTime;
        this.latestUpdate = latestUpdate;
        this.latestVolume = latestVolume;
        this.low = low;
        this.lowSource = lowSource;
        this.lowTime = lowTime;
        this.marketCap = marketCap;
        this.oddLotDelayedPrice = oddLotDelayedPrice;
        this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
        this.open = open;
        this.openTime = openTime;
        this.openSource = openSource;
        this.peRatio = peRatio;
        this.previousClose = previousClose;
        this.previousVolume = previousVolume;
        this.primaryExchange = primaryExchange;
        this.symbol = symbol;
        this.volume = volume;
        this.week52High = week52High;
        this.week52Low = week52Low;
        this.ytdChange = ytdChange;
        this.isUSMarketOpen = isUSMarketOpen;
    }

    @JsonProperty("avgTotalVolume")
    public long getAvgTotalVolume() {
        return avgTotalVolume;
    }

    @JsonProperty("avgTotalVolume")
    public void setAvgTotalVolume(long avgTotalVolume) {
        this.avgTotalVolume = avgTotalVolume;
    }

    public IexQuote withAvgTotalVolume(long avgTotalVolume) {
        this.avgTotalVolume = avgTotalVolume;
        return this;
    }

    @JsonProperty("calculationPrice")
    public String getCalculationPrice() {
        return calculationPrice;
    }

    @JsonProperty("calculationPrice")
    public void setCalculationPrice(String calculationPrice) {
        this.calculationPrice = calculationPrice;
    }

    public IexQuote withCalculationPrice(String calculationPrice) {
        this.calculationPrice = calculationPrice;
        return this;
    }

    @JsonProperty("change")
    public long getChange() {
        return change;
    }

    @JsonProperty("change")
    public void setChange(long change) {
        this.change = change;
    }

    public IexQuote withChange(long change) {
        this.change = change;
        return this;
    }

    @JsonProperty("changePercent")
    public double getChangePercent() {
        return changePercent;
    }

    @JsonProperty("changePercent")
    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }

    public IexQuote withChangePercent(double changePercent) {
        this.changePercent = changePercent;
        return this;
    }

    @JsonProperty("close")
    public Object getClose() {
        return close;
    }

    @JsonProperty("close")
    public void setClose(Object close) {
        this.close = close;
    }

    public IexQuote withClose(Object close) {
        this.close = close;
        return this;
    }

    @JsonProperty("closeSource")
    public String getCloseSource() {
        return closeSource;
    }

    @JsonProperty("closeSource")
    public void setCloseSource(String closeSource) {
        this.closeSource = closeSource;
    }

    public IexQuote withCloseSource(String closeSource) {
        this.closeSource = closeSource;
        return this;
    }

    @JsonProperty("closeTime")
    public Object getCloseTime() {
        return closeTime;
    }

    @JsonProperty("closeTime")
    public void setCloseTime(Object closeTime) {
        this.closeTime = closeTime;
    }

    public IexQuote withCloseTime(Object closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    @JsonProperty("companyName")
    public String getCompanyName() {
        return companyName;
    }

    @JsonProperty("companyName")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public IexQuote withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public IexQuote withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @JsonProperty("delayedPrice")
    public Object getDelayedPrice() {
        return delayedPrice;
    }

    @JsonProperty("delayedPrice")
    public void setDelayedPrice(Object delayedPrice) {
        this.delayedPrice = delayedPrice;
    }

    public IexQuote withDelayedPrice(Object delayedPrice) {
        this.delayedPrice = delayedPrice;
        return this;
    }

    @JsonProperty("delayedPriceTime")
    public Object getDelayedPriceTime() {
        return delayedPriceTime;
    }

    @JsonProperty("delayedPriceTime")
    public void setDelayedPriceTime(Object delayedPriceTime) {
        this.delayedPriceTime = delayedPriceTime;
    }

    public IexQuote withDelayedPriceTime(Object delayedPriceTime) {
        this.delayedPriceTime = delayedPriceTime;
        return this;
    }

    @JsonProperty("extendedChange")
    public Object getExtendedChange() {
        return extendedChange;
    }

    @JsonProperty("extendedChange")
    public void setExtendedChange(Object extendedChange) {
        this.extendedChange = extendedChange;
    }

    public IexQuote withExtendedChange(Object extendedChange) {
        this.extendedChange = extendedChange;
        return this;
    }

    @JsonProperty("extendedChangePercent")
    public Object getExtendedChangePercent() {
        return extendedChangePercent;
    }

    @JsonProperty("extendedChangePercent")
    public void setExtendedChangePercent(Object extendedChangePercent) {
        this.extendedChangePercent = extendedChangePercent;
    }

    public IexQuote withExtendedChangePercent(Object extendedChangePercent) {
        this.extendedChangePercent = extendedChangePercent;
        return this;
    }

    @JsonProperty("extendedPrice")
    public Object getExtendedPrice() {
        return extendedPrice;
    }

    @JsonProperty("extendedPrice")
    public void setExtendedPrice(Object extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    public IexQuote withExtendedPrice(Object extendedPrice) {
        this.extendedPrice = extendedPrice;
        return this;
    }

    @JsonProperty("extendedPriceTime")
    public Object getExtendedPriceTime() {
        return extendedPriceTime;
    }

    @JsonProperty("extendedPriceTime")
    public void setExtendedPriceTime(Object extendedPriceTime) {
        this.extendedPriceTime = extendedPriceTime;
    }

    public IexQuote withExtendedPriceTime(Object extendedPriceTime) {
        this.extendedPriceTime = extendedPriceTime;
        return this;
    }

    @JsonProperty("high")
    public Object getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(Object high) {
        this.high = high;
    }

    public IexQuote withHigh(Object high) {
        this.high = high;
        return this;
    }

    @JsonProperty("highSource")
    public Object getHighSource() {
        return highSource;
    }

    @JsonProperty("highSource")
    public void setHighSource(Object highSource) {
        this.highSource = highSource;
    }

    public IexQuote withHighSource(Object highSource) {
        this.highSource = highSource;
        return this;
    }

    @JsonProperty("highTime")
    public Object getHighTime() {
        return highTime;
    }

    @JsonProperty("highTime")
    public void setHighTime(Object highTime) {
        this.highTime = highTime;
    }

    public IexQuote withHighTime(Object highTime) {
        this.highTime = highTime;
        return this;
    }

    @JsonProperty("iexAskPrice")
    public double getIexAskPrice() {
        return iexAskPrice;
    }

    @JsonProperty("iexAskPrice")
    public void setIexAskPrice(double iexAskPrice) {
        this.iexAskPrice = iexAskPrice;
    }

    public IexQuote withIexAskPrice(double iexAskPrice) {
        this.iexAskPrice = iexAskPrice;
        return this;
    }

    @JsonProperty("iexAskSize")
    public long getIexAskSize() {
        return iexAskSize;
    }

    @JsonProperty("iexAskSize")
    public void setIexAskSize(long iexAskSize) {
        this.iexAskSize = iexAskSize;
    }

    public IexQuote withIexAskSize(long iexAskSize) {
        this.iexAskSize = iexAskSize;
        return this;
    }

    @JsonProperty("iexBidPrice")
    public double getIexBidPrice() {
        return iexBidPrice;
    }

    @JsonProperty("iexBidPrice")
    public void setIexBidPrice(double iexBidPrice) {
        this.iexBidPrice = iexBidPrice;
    }

    public IexQuote withIexBidPrice(double iexBidPrice) {
        this.iexBidPrice = iexBidPrice;
        return this;
    }

    @JsonProperty("iexBidSize")
    public long getIexBidSize() {
        return iexBidSize;
    }

    @JsonProperty("iexBidSize")
    public void setIexBidSize(long iexBidSize) {
        this.iexBidSize = iexBidSize;
    }

    public IexQuote withIexBidSize(long iexBidSize) {
        this.iexBidSize = iexBidSize;
        return this;
    }

    @JsonProperty("iexClose")
    public double getIexClose() {
        return iexClose;
    }

    @JsonProperty("iexClose")
    public void setIexClose(double iexClose) {
        this.iexClose = iexClose;
    }

    public IexQuote withIexClose(double iexClose) {
        this.iexClose = iexClose;
        return this;
    }

    @JsonProperty("iexCloseTime")
    public long getIexCloseTime() {
        return iexCloseTime;
    }

    @JsonProperty("iexCloseTime")
    public void setIexCloseTime(long iexCloseTime) {
        this.iexCloseTime = iexCloseTime;
    }

    public IexQuote withIexCloseTime(long iexCloseTime) {
        this.iexCloseTime = iexCloseTime;
        return this;
    }

    @JsonProperty("iexLastUpdated")
    public long getIexLastUpdated() {
        return iexLastUpdated;
    }

    @JsonProperty("iexLastUpdated")
    public void setIexLastUpdated(long iexLastUpdated) {
        this.iexLastUpdated = iexLastUpdated;
    }

    public IexQuote withIexLastUpdated(long iexLastUpdated) {
        this.iexLastUpdated = iexLastUpdated;
        return this;
    }

    @JsonProperty("iexMarketPercent")
    public double getIexMarketPercent() {
        return iexMarketPercent;
    }

    @JsonProperty("iexMarketPercent")
    public void setIexMarketPercent(double iexMarketPercent) {
        this.iexMarketPercent = iexMarketPercent;
    }

    public IexQuote withIexMarketPercent(double iexMarketPercent) {
        this.iexMarketPercent = iexMarketPercent;
        return this;
    }

    @JsonProperty("iexOpen")
    public double getIexOpen() {
        return iexOpen;
    }

    @JsonProperty("iexOpen")
    public void setIexOpen(double iexOpen) {
        this.iexOpen = iexOpen;
    }

    public IexQuote withIexOpen(double iexOpen) {
        this.iexOpen = iexOpen;
        return this;
    }

    @JsonProperty("iexOpenTime")
    public long getIexOpenTime() {
        return iexOpenTime;
    }

    @JsonProperty("iexOpenTime")
    public void setIexOpenTime(long iexOpenTime) {
        this.iexOpenTime = iexOpenTime;
    }

    public IexQuote withIexOpenTime(long iexOpenTime) {
        this.iexOpenTime = iexOpenTime;
        return this;
    }

    @JsonProperty("iexRealtimePrice")
    public double getIexRealtimePrice() {
        return iexRealtimePrice;
    }

    @JsonProperty("iexRealtimePrice")
    public void setIexRealtimePrice(double iexRealtimePrice) {
        this.iexRealtimePrice = iexRealtimePrice;
    }

    public IexQuote withIexRealtimePrice(double iexRealtimePrice) {
        this.iexRealtimePrice = iexRealtimePrice;
        return this;
    }

    @JsonProperty("iexRealtimeSize")
    public long getIexRealtimeSize() {
        return iexRealtimeSize;
    }

    @JsonProperty("iexRealtimeSize")
    public void setIexRealtimeSize(long iexRealtimeSize) {
        this.iexRealtimeSize = iexRealtimeSize;
    }

    public IexQuote withIexRealtimeSize(long iexRealtimeSize) {
        this.iexRealtimeSize = iexRealtimeSize;
        return this;
    }

    @JsonProperty("iexVolume")
    public long getIexVolume() {
        return iexVolume;
    }

    @JsonProperty("iexVolume")
    public void setIexVolume(long iexVolume) {
        this.iexVolume = iexVolume;
    }

    public IexQuote withIexVolume(long iexVolume) {
        this.iexVolume = iexVolume;
        return this;
    }

    @JsonProperty("lastTradeTime")
    public long getLastTradeTime() {
        return lastTradeTime;
    }

    @JsonProperty("lastTradeTime")
    public void setLastTradeTime(long lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    public IexQuote withLastTradeTime(long lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
        return this;
    }

    @JsonProperty("latestPrice")
    public double getLatestPrice() {
        return latestPrice;
    }

    @JsonProperty("latestPrice")
    public void setLatestPrice(double latestPrice) {
        this.latestPrice = latestPrice;
    }

    public IexQuote withLatestPrice(double latestPrice) {
        this.latestPrice = latestPrice;
        return this;
    }

    @JsonProperty("latestSource")
    public String getLatestSource() {
        return latestSource;
    }

    @JsonProperty("latestSource")
    public void setLatestSource(String latestSource) {
        this.latestSource = latestSource;
    }

    public IexQuote withLatestSource(String latestSource) {
        this.latestSource = latestSource;
        return this;
    }

    @JsonProperty("latestTime")
    public String getLatestTime() {
        return latestTime;
    }

    @JsonProperty("latestTime")
    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    public IexQuote withLatestTime(String latestTime) {
        this.latestTime = latestTime;
        return this;
    }

    @JsonProperty("latestUpdate")
    public long getLatestUpdate() {
        return latestUpdate;
    }

    @JsonProperty("latestUpdate")
    public void setLatestUpdate(long latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public IexQuote withLatestUpdate(long latestUpdate) {
        this.latestUpdate = latestUpdate;
        return this;
    }

    @JsonProperty("latestVolume")
    public Object getLatestVolume() {
        return latestVolume;
    }

    @JsonProperty("latestVolume")
    public void setLatestVolume(Object latestVolume) {
        this.latestVolume = latestVolume;
    }

    public IexQuote withLatestVolume(Object latestVolume) {
        this.latestVolume = latestVolume;
        return this;
    }

    @JsonProperty("low")
    public Object getLow() {
        return low;
    }

    @JsonProperty("low")
    public void setLow(Object low) {
        this.low = low;
    }

    public IexQuote withLow(Object low) {
        this.low = low;
        return this;
    }

    @JsonProperty("lowSource")
    public Object getLowSource() {
        return lowSource;
    }

    @JsonProperty("lowSource")
    public void setLowSource(Object lowSource) {
        this.lowSource = lowSource;
    }

    public IexQuote withLowSource(Object lowSource) {
        this.lowSource = lowSource;
        return this;
    }

    @JsonProperty("lowTime")
    public Object getLowTime() {
        return lowTime;
    }

    @JsonProperty("lowTime")
    public void setLowTime(Object lowTime) {
        this.lowTime = lowTime;
    }

    public IexQuote withLowTime(Object lowTime) {
        this.lowTime = lowTime;
        return this;
    }

    @JsonProperty("marketCap")
    public long getMarketCap() {
        return marketCap;
    }

    @JsonProperty("marketCap")
    public void setMarketCap(long marketCap) {
        this.marketCap = marketCap;
    }

    public IexQuote withMarketCap(long marketCap) {
        this.marketCap = marketCap;
        return this;
    }

    @JsonProperty("oddLotDelayedPrice")
    public Object getOddLotDelayedPrice() {
        return oddLotDelayedPrice;
    }

    @JsonProperty("oddLotDelayedPrice")
    public void setOddLotDelayedPrice(Object oddLotDelayedPrice) {
        this.oddLotDelayedPrice = oddLotDelayedPrice;
    }

    public IexQuote withOddLotDelayedPrice(Object oddLotDelayedPrice) {
        this.oddLotDelayedPrice = oddLotDelayedPrice;
        return this;
    }

    @JsonProperty("oddLotDelayedPriceTime")
    public Object getOddLotDelayedPriceTime() {
        return oddLotDelayedPriceTime;
    }

    @JsonProperty("oddLotDelayedPriceTime")
    public void setOddLotDelayedPriceTime(Object oddLotDelayedPriceTime) {
        this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
    }

    public IexQuote withOddLotDelayedPriceTime(Object oddLotDelayedPriceTime) {
        this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
        return this;
    }

    @JsonProperty("open")
    public Object getOpen() {
        return open;
    }

    @JsonProperty("open")
    public void setOpen(Object open) {
        this.open = open;
    }

    public IexQuote withOpen(Object open) {
        this.open = open;
        return this;
    }

    @JsonProperty("openTime")
    public Object getOpenTime() {
        return openTime;
    }

    @JsonProperty("openTime")
    public void setOpenTime(Object openTime) {
        this.openTime = openTime;
    }

    public IexQuote withOpenTime(Object openTime) {
        this.openTime = openTime;
        return this;
    }

    @JsonProperty("openSource")
    public String getOpenSource() {
        return openSource;
    }

    @JsonProperty("openSource")
    public void setOpenSource(String openSource) {
        this.openSource = openSource;
    }

    public IexQuote withOpenSource(String openSource) {
        this.openSource = openSource;
        return this;
    }

    @JsonProperty("peRatio")
    public double getPeRatio() {
        return peRatio;
    }

    @JsonProperty("peRatio")
    public void setPeRatio(double peRatio) {
        this.peRatio = peRatio;
    }

    public IexQuote withPeRatio(double peRatio) {
        this.peRatio = peRatio;
        return this;
    }

    @JsonProperty("previousClose")
    public double getPreviousClose() {
        return previousClose;
    }

    @JsonProperty("previousClose")
    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public IexQuote withPreviousClose(double previousClose) {
        this.previousClose = previousClose;
        return this;
    }

    @JsonProperty("previousVolume")
    public long getPreviousVolume() {
        return previousVolume;
    }

    @JsonProperty("previousVolume")
    public void setPreviousVolume(long previousVolume) {
        this.previousVolume = previousVolume;
    }

    public IexQuote withPreviousVolume(long previousVolume) {
        this.previousVolume = previousVolume;
        return this;
    }

    @JsonProperty("primaryExchange")
    public String getPrimaryExchange() {
        return primaryExchange;
    }

    @JsonProperty("primaryExchange")
    public void setPrimaryExchange(String primaryExchange) {
        this.primaryExchange = primaryExchange;
    }

    public IexQuote withPrimaryExchange(String primaryExchange) {
        this.primaryExchange = primaryExchange;
        return this;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public IexQuote withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    @JsonProperty("volume")
    public Object getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(Object volume) {
        this.volume = volume;
    }

    public IexQuote withVolume(Object volume) {
        this.volume = volume;
        return this;
    }

    @JsonProperty("week52High")
    public double getWeek52High() {
        return week52High;
    }

    @JsonProperty("week52High")
    public void setWeek52High(double week52High) {
        this.week52High = week52High;
    }

    public IexQuote withWeek52High(double week52High) {
        this.week52High = week52High;
        return this;
    }

    @JsonProperty("week52Low")
    public double getWeek52Low() {
        return week52Low;
    }

    @JsonProperty("week52Low")
    public void setWeek52Low(double week52Low) {
        this.week52Low = week52Low;
    }

    public IexQuote withWeek52Low(double week52Low) {
        this.week52Low = week52Low;
        return this;
    }

    @JsonProperty("ytdChange")
    public double getYtdChange() {
        return ytdChange;
    }

    @JsonProperty("ytdChange")
    public void setYtdChange(double ytdChange) {
        this.ytdChange = ytdChange;
    }

    public IexQuote withYtdChange(double ytdChange) {
        this.ytdChange = ytdChange;
        return this;
    }

    @JsonProperty("isUSMarketOpen")
    public boolean isIsUSMarketOpen() {
        return isUSMarketOpen;
    }

    @JsonProperty("isUSMarketOpen")
    public void setIsUSMarketOpen(boolean isUSMarketOpen) {
        this.isUSMarketOpen = isUSMarketOpen;
    }

    public IexQuote withIsUSMarketOpen(boolean isUSMarketOpen) {
        this.isUSMarketOpen = isUSMarketOpen;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public IexQuote withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IexQuote.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("avgTotalVolume");
        sb.append('=');
        sb.append(this.avgTotalVolume);
        sb.append(',');
        sb.append("calculationPrice");
        sb.append('=');
        sb.append(((this.calculationPrice == null)?"<null>":this.calculationPrice));
        sb.append(',');
        sb.append("change");
        sb.append('=');
        sb.append(this.change);
        sb.append(',');
        sb.append("changePercent");
        sb.append('=');
        sb.append(this.changePercent);
        sb.append(',');
        sb.append("close");
        sb.append('=');
        sb.append(((this.close == null)?"<null>":this.close));
        sb.append(',');
        sb.append("closeSource");
        sb.append('=');
        sb.append(((this.closeSource == null)?"<null>":this.closeSource));
        sb.append(',');
        sb.append("closeTime");
        sb.append('=');
        sb.append(((this.closeTime == null)?"<null>":this.closeTime));
        sb.append(',');
        sb.append("companyName");
        sb.append('=');
        sb.append(((this.companyName == null)?"<null>":this.companyName));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
        sb.append(',');
        sb.append("delayedPrice");
        sb.append('=');
        sb.append(((this.delayedPrice == null)?"<null>":this.delayedPrice));
        sb.append(',');
        sb.append("delayedPriceTime");
        sb.append('=');
        sb.append(((this.delayedPriceTime == null)?"<null>":this.delayedPriceTime));
        sb.append(',');
        sb.append("extendedChange");
        sb.append('=');
        sb.append(((this.extendedChange == null)?"<null>":this.extendedChange));
        sb.append(',');
        sb.append("extendedChangePercent");
        sb.append('=');
        sb.append(((this.extendedChangePercent == null)?"<null>":this.extendedChangePercent));
        sb.append(',');
        sb.append("extendedPrice");
        sb.append('=');
        sb.append(((this.extendedPrice == null)?"<null>":this.extendedPrice));
        sb.append(',');
        sb.append("extendedPriceTime");
        sb.append('=');
        sb.append(((this.extendedPriceTime == null)?"<null>":this.extendedPriceTime));
        sb.append(',');
        sb.append("high");
        sb.append('=');
        sb.append(((this.high == null)?"<null>":this.high));
        sb.append(',');
        sb.append("highSource");
        sb.append('=');
        sb.append(((this.highSource == null)?"<null>":this.highSource));
        sb.append(',');
        sb.append("highTime");
        sb.append('=');
        sb.append(((this.highTime == null)?"<null>":this.highTime));
        sb.append(',');
        sb.append("iexAskPrice");
        sb.append('=');
        sb.append(this.iexAskPrice);
        sb.append(',');
        sb.append("iexAskSize");
        sb.append('=');
        sb.append(this.iexAskSize);
        sb.append(',');
        sb.append("iexBidPrice");
        sb.append('=');
        sb.append(this.iexBidPrice);
        sb.append(',');
        sb.append("iexBidSize");
        sb.append('=');
        sb.append(this.iexBidSize);
        sb.append(',');
        sb.append("iexClose");
        sb.append('=');
        sb.append(this.iexClose);
        sb.append(',');
        sb.append("iexCloseTime");
        sb.append('=');
        sb.append(this.iexCloseTime);
        sb.append(',');
        sb.append("iexLastUpdated");
        sb.append('=');
        sb.append(this.iexLastUpdated);
        sb.append(',');
        sb.append("iexMarketPercent");
        sb.append('=');
        sb.append(this.iexMarketPercent);
        sb.append(',');
        sb.append("iexOpen");
        sb.append('=');
        sb.append(this.iexOpen);
        sb.append(',');
        sb.append("iexOpenTime");
        sb.append('=');
        sb.append(this.iexOpenTime);
        sb.append(',');
        sb.append("iexRealtimePrice");
        sb.append('=');
        sb.append(this.iexRealtimePrice);
        sb.append(',');
        sb.append("iexRealtimeSize");
        sb.append('=');
        sb.append(this.iexRealtimeSize);
        sb.append(',');
        sb.append("iexVolume");
        sb.append('=');
        sb.append(this.iexVolume);
        sb.append(',');
        sb.append("lastTradeTime");
        sb.append('=');
        sb.append(this.lastTradeTime);
        sb.append(',');
        sb.append("latestPrice");
        sb.append('=');
        sb.append(this.latestPrice);
        sb.append(',');
        sb.append("latestSource");
        sb.append('=');
        sb.append(((this.latestSource == null)?"<null>":this.latestSource));
        sb.append(',');
        sb.append("latestTime");
        sb.append('=');
        sb.append(((this.latestTime == null)?"<null>":this.latestTime));
        sb.append(',');
        sb.append("latestUpdate");
        sb.append('=');
        sb.append(this.latestUpdate);
        sb.append(',');
        sb.append("latestVolume");
        sb.append('=');
        sb.append(((this.latestVolume == null)?"<null>":this.latestVolume));
        sb.append(',');
        sb.append("low");
        sb.append('=');
        sb.append(((this.low == null)?"<null>":this.low));
        sb.append(',');
        sb.append("lowSource");
        sb.append('=');
        sb.append(((this.lowSource == null)?"<null>":this.lowSource));
        sb.append(',');
        sb.append("lowTime");
        sb.append('=');
        sb.append(((this.lowTime == null)?"<null>":this.lowTime));
        sb.append(',');
        sb.append("marketCap");
        sb.append('=');
        sb.append(this.marketCap);
        sb.append(',');
        sb.append("oddLotDelayedPrice");
        sb.append('=');
        sb.append(((this.oddLotDelayedPrice == null)?"<null>":this.oddLotDelayedPrice));
        sb.append(',');
        sb.append("oddLotDelayedPriceTime");
        sb.append('=');
        sb.append(((this.oddLotDelayedPriceTime == null)?"<null>":this.oddLotDelayedPriceTime));
        sb.append(',');
        sb.append("open");
        sb.append('=');
        sb.append(((this.open == null)?"<null>":this.open));
        sb.append(',');
        sb.append("openTime");
        sb.append('=');
        sb.append(((this.openTime == null)?"<null>":this.openTime));
        sb.append(',');
        sb.append("openSource");
        sb.append('=');
        sb.append(((this.openSource == null)?"<null>":this.openSource));
        sb.append(',');
        sb.append("peRatio");
        sb.append('=');
        sb.append(this.peRatio);
        sb.append(',');
        sb.append("previousClose");
        sb.append('=');
        sb.append(this.previousClose);
        sb.append(',');
        sb.append("previousVolume");
        sb.append('=');
        sb.append(this.previousVolume);
        sb.append(',');
        sb.append("primaryExchange");
        sb.append('=');
        sb.append(((this.primaryExchange == null)?"<null>":this.primaryExchange));
        sb.append(',');
        sb.append("symbol");
        sb.append('=');
        sb.append(((this.symbol == null)?"<null>":this.symbol));
        sb.append(',');
        sb.append("volume");
        sb.append('=');
        sb.append(((this.volume == null)?"<null>":this.volume));
        sb.append(',');
        sb.append("week52High");
        sb.append('=');
        sb.append(this.week52High);
        sb.append(',');
        sb.append("week52Low");
        sb.append('=');
        sb.append(this.week52Low);
        sb.append(',');
        sb.append("ytdChange");
        sb.append('=');
        sb.append(this.ytdChange);
        sb.append(',');
        sb.append("isUSMarketOpen");
        sb.append('=');
        sb.append(this.isUSMarketOpen);
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.symbol == null)? 0 :this.symbol.hashCode()));
        result = ((result* 31)+((this.highTime == null)? 0 :this.highTime.hashCode()));
        result = ((result* 31)+((int)(this.avgTotalVolume^(this.avgTotalVolume >>> 32))));
        result = ((result* 31)+((this.companyName == null)? 0 :this.companyName.hashCode()));
        result = ((result* 31)+((this.openSource == null)? 0 :this.openSource.hashCode()));
        result = ((result* 31)+((this.delayedPrice == null)? 0 :this.delayedPrice.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.iexMarketPercent)^(Double.doubleToLongBits(this.iexMarketPercent)>>> 32))));
        result = ((result* 31)+((this.primaryExchange == null)? 0 :this.primaryExchange.hashCode()));
        result = ((result* 31)+((int)(this.latestUpdate^(this.latestUpdate >>> 32))));
        result = ((result* 31)+((this.high == null)? 0 :this.high.hashCode()));
        result = ((result* 31)+((int)(this.iexOpenTime^(this.iexOpenTime >>> 32))));
        result = ((result* 31)+((this.delayedPriceTime == null)? 0 :this.delayedPriceTime.hashCode()));
        result = ((result* 31)+((this.extendedPrice == null)? 0 :this.extendedPrice.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.week52Low)^(Double.doubleToLongBits(this.week52Low)>>> 32))));
        result = ((result* 31)+((this.highSource == null)? 0 :this.highSource.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.latestPrice)^(Double.doubleToLongBits(this.latestPrice)>>> 32))));
        result = ((result* 31)+((int)(this.marketCap^(this.marketCap >>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.iexClose)^(Double.doubleToLongBits(this.iexClose)>>> 32))));
        result = ((result* 31)+((this.volume == null)? 0 :this.volume.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.ytdChange)^(Double.doubleToLongBits(this.ytdChange)>>> 32))));
        result = ((result* 31)+((int)(this.lastTradeTime^(this.lastTradeTime >>> 32))));
        result = ((result* 31)+((this.closeSource == null)? 0 :this.closeSource.hashCode()));
        result = ((result* 31)+((this.extendedChange == null)? 0 :this.extendedChange.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.iexRealtimePrice)^(Double.doubleToLongBits(this.iexRealtimePrice)>>> 32))));
        result = ((result* 31)+((this.calculationPrice == null)? 0 :this.calculationPrice.hashCode()));
        result = ((result* 31)+((this.extendedChangePercent == null)? 0 :this.extendedChangePercent.hashCode()));
        result = ((result* 31)+((this.latestSource == null)? 0 :this.latestSource.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.iexOpen)^(Double.doubleToLongBits(this.iexOpen)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.iexBidPrice)^(Double.doubleToLongBits(this.iexBidPrice)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.previousClose)^(Double.doubleToLongBits(this.previousClose)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.peRatio)^(Double.doubleToLongBits(this.peRatio)>>> 32))));
        result = ((result* 31)+(this.isUSMarketOpen? 1 : 0));
        result = ((result* 31)+((this.low == null)? 0 :this.low.hashCode()));
        result = ((result* 31)+((this.oddLotDelayedPrice == null)? 0 :this.oddLotDelayedPrice.hashCode()));
        result = ((result* 31)+((this.extendedPriceTime == null)? 0 :this.extendedPriceTime.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.changePercent)^(Double.doubleToLongBits(this.changePercent)>>> 32))));
        result = ((result* 31)+((this.closeTime == null)? 0 :this.closeTime.hashCode()));
        result = ((result* 31)+((this.currency == null)? 0 :this.currency.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.week52High)^(Double.doubleToLongBits(this.week52High)>>> 32))));
        result = ((result* 31)+((this.openTime == null)? 0 :this.openTime.hashCode()));
        result = ((result* 31)+((this.close == null)? 0 :this.close.hashCode()));
        result = ((result* 31)+((int)(this.iexCloseTime^(this.iexCloseTime >>> 32))));
        result = ((result* 31)+((this.oddLotDelayedPriceTime == null)? 0 :this.oddLotDelayedPriceTime.hashCode()));
        result = ((result* 31)+((int)(this.previousVolume^(this.previousVolume >>> 32))));
        result = ((result* 31)+((int)(this.iexRealtimeSize^(this.iexRealtimeSize >>> 32))));
        result = ((result* 31)+((int)(this.iexLastUpdated^(this.iexLastUpdated >>> 32))));
        result = ((result* 31)+((int)(this.change^(this.change >>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.iexAskPrice)^(Double.doubleToLongBits(this.iexAskPrice)>>> 32))));
        result = ((result* 31)+((this.latestVolume == null)? 0 :this.latestVolume.hashCode()));
        result = ((result* 31)+((this.lowSource == null)? 0 :this.lowSource.hashCode()));
        result = ((result* 31)+((int)(this.iexVolume^(this.iexVolume >>> 32))));
        result = ((result* 31)+((int)(this.iexAskSize^(this.iexAskSize >>> 32))));
        result = ((result* 31)+((this.latestTime == null)? 0 :this.latestTime.hashCode()));
        result = ((result* 31)+((int)(this.iexBidSize^(this.iexBidSize >>> 32))));
        result = ((result* 31)+((this.lowTime == null)? 0 :this.lowTime.hashCode()));
        result = ((result* 31)+((this.open == null)? 0 :this.open.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IexQuote) == false) {
            return false;
        }
        IexQuote rhs = ((IexQuote) other);
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.symbol == rhs.symbol)||((this.symbol!= null)&&this.symbol.equals(rhs.symbol)))&&((this.highTime == rhs.highTime)||((this.highTime!= null)&&this.highTime.equals(rhs.highTime))))&&(this.avgTotalVolume == rhs.avgTotalVolume))&&((this.companyName == rhs.companyName)||((this.companyName!= null)&&this.companyName.equals(rhs.companyName))))&&((this.openSource == rhs.openSource)||((this.openSource!= null)&&this.openSource.equals(rhs.openSource))))&&((this.delayedPrice == rhs.delayedPrice)||((this.delayedPrice!= null)&&this.delayedPrice.equals(rhs.delayedPrice))))&&(Double.doubleToLongBits(this.iexMarketPercent) == Double.doubleToLongBits(rhs.iexMarketPercent)))&&((this.primaryExchange == rhs.primaryExchange)||((this.primaryExchange!= null)&&this.primaryExchange.equals(rhs.primaryExchange))))&&(this.latestUpdate == rhs.latestUpdate))&&((this.high == rhs.high)||((this.high!= null)&&this.high.equals(rhs.high))))&&(this.iexOpenTime == rhs.iexOpenTime))&&((this.delayedPriceTime == rhs.delayedPriceTime)||((this.delayedPriceTime!= null)&&this.delayedPriceTime.equals(rhs.delayedPriceTime))))&&((this.extendedPrice == rhs.extendedPrice)||((this.extendedPrice!= null)&&this.extendedPrice.equals(rhs.extendedPrice))))&&(Double.doubleToLongBits(this.week52Low) == Double.doubleToLongBits(rhs.week52Low)))&&((this.highSource == rhs.highSource)||((this.highSource!= null)&&this.highSource.equals(rhs.highSource))))&&(Double.doubleToLongBits(this.latestPrice) == Double.doubleToLongBits(rhs.latestPrice)))&&(this.marketCap == rhs.marketCap))&&(Double.doubleToLongBits(this.iexClose) == Double.doubleToLongBits(rhs.iexClose)))&&((this.volume == rhs.volume)||((this.volume!= null)&&this.volume.equals(rhs.volume))))&&(Double.doubleToLongBits(this.ytdChange) == Double.doubleToLongBits(rhs.ytdChange)))&&(this.lastTradeTime == rhs.lastTradeTime))&&((this.closeSource == rhs.closeSource)||((this.closeSource!= null)&&this.closeSource.equals(rhs.closeSource))))&&((this.extendedChange == rhs.extendedChange)||((this.extendedChange!= null)&&this.extendedChange.equals(rhs.extendedChange))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(Double.doubleToLongBits(this.iexRealtimePrice) == Double.doubleToLongBits(rhs.iexRealtimePrice)))&&((this.calculationPrice == rhs.calculationPrice)||((this.calculationPrice!= null)&&this.calculationPrice.equals(rhs.calculationPrice))))&&((this.extendedChangePercent == rhs.extendedChangePercent)||((this.extendedChangePercent!= null)&&this.extendedChangePercent.equals(rhs.extendedChangePercent))))&&((this.latestSource == rhs.latestSource)||((this.latestSource!= null)&&this.latestSource.equals(rhs.latestSource))))&&(Double.doubleToLongBits(this.iexOpen) == Double.doubleToLongBits(rhs.iexOpen)))&&(Double.doubleToLongBits(this.iexBidPrice) == Double.doubleToLongBits(rhs.iexBidPrice)))&&(Double.doubleToLongBits(this.previousClose) == Double.doubleToLongBits(rhs.previousClose)))&&(Double.doubleToLongBits(this.peRatio) == Double.doubleToLongBits(rhs.peRatio)))&&(this.isUSMarketOpen == rhs.isUSMarketOpen))&&((this.low == rhs.low)||((this.low!= null)&&this.low.equals(rhs.low))))&&((this.oddLotDelayedPrice == rhs.oddLotDelayedPrice)||((this.oddLotDelayedPrice!= null)&&this.oddLotDelayedPrice.equals(rhs.oddLotDelayedPrice))))&&((this.extendedPriceTime == rhs.extendedPriceTime)||((this.extendedPriceTime!= null)&&this.extendedPriceTime.equals(rhs.extendedPriceTime))))&&(Double.doubleToLongBits(this.changePercent) == Double.doubleToLongBits(rhs.changePercent)))&&((this.closeTime == rhs.closeTime)||((this.closeTime!= null)&&this.closeTime.equals(rhs.closeTime))))&&((this.currency == rhs.currency)||((this.currency!= null)&&this.currency.equals(rhs.currency))))&&(Double.doubleToLongBits(this.week52High) == Double.doubleToLongBits(rhs.week52High)))&&((this.openTime == rhs.openTime)||((this.openTime!= null)&&this.openTime.equals(rhs.openTime))))&&((this.close == rhs.close)||((this.close!= null)&&this.close.equals(rhs.close))))&&(this.iexCloseTime == rhs.iexCloseTime))&&((this.oddLotDelayedPriceTime == rhs.oddLotDelayedPriceTime)||((this.oddLotDelayedPriceTime!= null)&&this.oddLotDelayedPriceTime.equals(rhs.oddLotDelayedPriceTime))))&&(this.previousVolume == rhs.previousVolume))&&(this.iexRealtimeSize == rhs.iexRealtimeSize))&&(this.iexLastUpdated == rhs.iexLastUpdated))&&(this.change == rhs.change))&&(Double.doubleToLongBits(this.iexAskPrice) == Double.doubleToLongBits(rhs.iexAskPrice)))&&((this.latestVolume == rhs.latestVolume)||((this.latestVolume!= null)&&this.latestVolume.equals(rhs.latestVolume))))&&((this.lowSource == rhs.lowSource)||((this.lowSource!= null)&&this.lowSource.equals(rhs.lowSource))))&&(this.iexVolume == rhs.iexVolume))&&(this.iexAskSize == rhs.iexAskSize))&&((this.latestTime == rhs.latestTime)||((this.latestTime!= null)&&this.latestTime.equals(rhs.latestTime))))&&(this.iexBidSize == rhs.iexBidSize))&&((this.lowTime == rhs.lowTime)||((this.lowTime!= null)&&this.lowTime.equals(rhs.lowTime))))&&((this.open == rhs.open)||((this.open!= null)&&this.open.equals(rhs.open))));
    }

}
