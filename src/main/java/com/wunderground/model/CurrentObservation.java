package com.wunderground.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created with IntelliJ IDEA.
 * User: Prasanna Ramachandran
 * Date: 8/22/13
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("current_observation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentObservation {

    private Image image;

    @XStreamAlias("display_location")
    private DisplayLocation displayLocation;

    @XStreamAlias("observation_location")
    private ObservationLocation observationLocation;

    @XStreamAlias("temp_f")
    @JsonProperty("temp_f")
    private String tempF;

    @XStreamAlias("temp_c")
    @JsonProperty("temp_c")
    private String tempC;

    @XStreamAlias("estimated")
    @JsonProperty("estimated")
    private String estimated;

    @XStreamAlias("station_id")
    @JsonProperty("station_id")
    private String stationId;

    @XStreamAlias("observation_time")
    @JsonProperty("observation_time")
    private String observationTime;

    @XStreamAlias("observation_time_rfc822")
    @JsonProperty("observation_time_rfc822")
    private String observationTimeRfc;

    @XStreamAlias("observation_epoch")
    @JsonProperty("observation_epoch")
    private String observationEpoch;

    @XStreamAlias("local_time_rfc822")
    @JsonProperty("local_time_rfc822")
    private String localTimeRfc;

    @XStreamAlias("local_epoch")
    @JsonProperty("local_epoch")
    private String localTimeEpoch;

    @XStreamAlias("local_tz_short")
    @JsonProperty("local_tz_short")
    private String localTzShort;

    @XStreamAlias("local_tz_long")
    @JsonProperty("local_tz_long")
    private String localTzLong;

    @XStreamAlias("local_tz_offset")
    @JsonProperty("local_tz_offset")
    private String localTzOffset;

    @XStreamAlias("weather")
    @JsonProperty("weather")
    private String weather;

    @XStreamAlias("temperature_string")
    @JsonProperty("temperature_string")
    private String temperatureString;

    @XStreamAlias("relative_humidity")
    @JsonProperty("relative_humidity")
    private String relativeHumidity;

    @XStreamAlias("wind_string")
    @JsonProperty("wind_string")
    private String windString;

    @XStreamAlias("wind_dir")
    @JsonProperty("wind_dir")
    private String windDir;

    @XStreamAlias("wind_degrees")
    @JsonProperty("wind_degrees")
    private String windDegrees;

    @XStreamAlias("wind_mph")
    @JsonProperty("wind_mph")
    private String windMph;

    @XStreamAlias("wind_gust_mph")
    @JsonProperty("wind_gust_mph")
    private String windGuestMph;

    @XStreamAlias("wind_kph")
    @JsonProperty("wind_kph")
    private String windKph;

    @XStreamAlias("wind_gust_kph")
    @JsonProperty("wind_gust_kph")
    private String windGuestKph;

    @XStreamAlias("pressure_mb")
    @JsonProperty("pressure_mb")
    private String pressureMb;

    @XStreamAlias("pressure_in")
    @JsonProperty("pressure_in")
    private String pressureIn;

    @XStreamAlias("pressure_trend")
    @JsonProperty("pressure_trend")
    private String pressureTrend;

    @XStreamAlias("dewpoint_string")
    @JsonProperty("dewpoint_string")
    private String dewpointString;

    @XStreamAlias("dewpoint_f")
    @JsonProperty("dewpoint_f")
    private String dewpointF;

    @XStreamAlias("dewpoint_c")
    @JsonProperty("dewpoint_c")
    private String dewpointC;

    @XStreamAlias("heat_index_string")
    @JsonProperty("heat_index_string")
    private String heatIndexString;

    @XStreamAlias("heat_index_f")
    @JsonProperty("heat_index_f")
    private String heatIndexF;

    @XStreamAlias("heat_index_c")
    @JsonProperty("heat_index_c")
    private String heatIndexC;

    @XStreamAlias("windchill_string")
    @JsonProperty("windchill_string")
    private String windchillString;

    @XStreamAlias("windchill_f")
    @JsonProperty("windchill_f")
    private String windchillF;

    @XStreamAlias("windchill_c")
    @JsonProperty("windchill_c")
    private String windchillC;

    @XStreamAlias("feelslike_string")
    @JsonProperty("feelslike_string")
    private String feelsLikeString;

    @XStreamAlias("feelslike_f")
    @JsonProperty("feelslike_f")
    private String feelsLikeF;

    @XStreamAlias("feelslike_c")
    @JsonProperty("feelslike_c")
    private String feelsLikeC;

    @XStreamAlias("visibility_mi")
    @JsonProperty("visibility_mi")
    private String visibilityMi;

    @XStreamAlias("visibility_km")
    @JsonProperty("visibility_km")
    private String visibilityKm;

    @XStreamAlias("solarradiation")
    @JsonProperty("solarradiation")
    private String solarRadiation;

    @XStreamAlias("UV")
    @JsonProperty("UV")
    private String uv;

    @XStreamAlias("precip_1hr_string")
    @JsonProperty("precip_1hr_string")
    private String precipOneHourString;

    @XStreamAlias("precip_1hr_in")
    @JsonProperty("precip_1hr_in")
    private String precipOneHourIn;

    @XStreamAlias("precip_1hr_metric")
    @JsonProperty("precip_1hr_metric")
    private String precipOneHourMetric;

    @XStreamAlias("precip_today_string")
    @JsonProperty("precip_today_string")
    private String precipTodayString;

    @XStreamAlias("precip_today_in")
    @JsonProperty("precip_today_in")
    private String precipTodayIn;

    @XStreamAlias("precip_today_metric")
    @JsonProperty("precip_today_metric")
    private String precipTodayMetric;

    @XStreamAlias("icon")
    @JsonProperty("icon")
    private String icon;

    @XStreamAlias("icon_url")
    @JsonProperty("icon_url")
    private String iconUrl;

    @XStreamAlias("forecast_url")
    @JsonProperty("forecast_url")
    private String forecastUrl;

    @XStreamAlias("history_url")
    @JsonProperty("history_url")
    private String historyUrl;

    @XStreamAlias("ob_url")
    @JsonProperty("ob_url")
    private String obUrl;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public DisplayLocation getDisplayLocation() {
        return displayLocation;
    }

    @JsonProperty("display_location")
    public void setDisplayLocation(DisplayLocation displayLocation) {
        this.displayLocation = displayLocation;
    }

    public ObservationLocation getObservationLocation() {
        return observationLocation;
    }

    @JsonProperty("observation_location")
    public void setObservationLocation(ObservationLocation observationLocation) {
        this.observationLocation = observationLocation;
    }

    public String getTempF() {
        return tempF;
    }

    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    public String getTempC() {
        return tempC;
    }

    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    public String getEstimated() {
        return estimated;
    }

    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public String getObservationTimeRfc() {
        return observationTimeRfc;
    }

    public void setObservationTimeRfc(String observationTimeRfc) {
        this.observationTimeRfc = observationTimeRfc;
    }

    public String getObservationEpoch() {
        return observationEpoch;
    }

    public void setObservationEpoch(String observationEpoch) {
        this.observationEpoch = observationEpoch;
    }

    public String getLocalTimeRfc() {
        return localTimeRfc;
    }

    public void setLocalTimeRfc(String localTimeRfc) {
        this.localTimeRfc = localTimeRfc;
    }

    public String getLocalTimeEpoch() {
        return localTimeEpoch;
    }

    public void setLocalTimeEpoch(String localTimeEpoch) {
        this.localTimeEpoch = localTimeEpoch;
    }

    public String getLocalTzShort() {
        return localTzShort;
    }

    public void setLocalTzShort(String localTzShort) {
        this.localTzShort = localTzShort;
    }

    public String getLocalTzLong() {
        return localTzLong;
    }

    public void setLocalTzLong(String localTzLong) {
        this.localTzLong = localTzLong;
    }

    public String getLocalTzOffset() {
        return localTzOffset;
    }

    public void setLocalTzOffset(String localTzOffset) {
        this.localTzOffset = localTzOffset;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperatureString() {
        return temperatureString;
    }

    public void setTemperatureString(String temperatureString) {
        this.temperatureString = temperatureString;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(String relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getWindString() {
        return windString;
    }

    public void setWindString(String windString) {
        this.windString = windString;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindDegrees() {
        return windDegrees;
    }

    public void setWindDegrees(String windDegrees) {
        this.windDegrees = windDegrees;
    }

    public String getWindMph() {
        return windMph;
    }

    public void setWindMph(String windMph) {
        this.windMph = windMph;
    }

    public String getWindGuestMph() {
        return windGuestMph;
    }

    public void setWindGuestMph(String windGuestMph) {
        this.windGuestMph = windGuestMph;
    }

    public String getWindKph() {
        return windKph;
    }

    public void setWindKph(String windKph) {
        this.windKph = windKph;
    }

    public String getWindGuestKph() {
        return windGuestKph;
    }

    public void setWindGuestKph(String windGuestKph) {
        this.windGuestKph = windGuestKph;
    }

    public String getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(String pressureMb) {
        this.pressureMb = pressureMb;
    }

    public String getPressureIn() {
        return pressureIn;
    }

    public void setPressureIn(String pressureIn) {
        this.pressureIn = pressureIn;
    }

    public String getPressureTrend() {
        return pressureTrend;
    }

    public void setPressureTrend(String pressureTrend) {
        this.pressureTrend = pressureTrend;
    }

    public String getDewpointString() {
        return dewpointString;
    }

    public void setDewpointString(String dewpointString) {
        this.dewpointString = dewpointString;
    }

    public String getDewpointF() {
        return dewpointF;
    }

    public void setDewpointF(String dewpointF) {
        this.dewpointF = dewpointF;
    }

    public String getDewpointC() {
        return dewpointC;
    }

    public void setDewpointC(String dewpointC) {
        this.dewpointC = dewpointC;
    }

    public String getHeatIndexString() {
        return heatIndexString;
    }

    public void setHeatIndexString(String heatIndexString) {
        this.heatIndexString = heatIndexString;
    }

    public String getHeatIndexF() {
        return heatIndexF;
    }

    public void setHeatIndexF(String heatIndexF) {
        this.heatIndexF = heatIndexF;
    }

    public String getHeatIndexC() {
        return heatIndexC;
    }

    public void setHeatIndexC(String heatIndexC) {
        this.heatIndexC = heatIndexC;
    }

    public String getWindchillString() {
        return windchillString;
    }

    public void setWindchillString(String windchillString) {
        this.windchillString = windchillString;
    }

    public String getWindchillF() {
        return windchillF;
    }

    public void setWindchillF(String windchillF) {
        this.windchillF = windchillF;
    }

    public String getWindchillC() {
        return windchillC;
    }

    public void setWindchillC(String windchillC) {
        this.windchillC = windchillC;
    }

    public String getFeelsLikeString() {
        return feelsLikeString;
    }

    public void setFeelsLikeString(String feelsLikeString) {
        this.feelsLikeString = feelsLikeString;
    }

    public String getFeelsLikeF() {
        return feelsLikeF;
    }

    public void setFeelsLikeF(String feelsLikeF) {
        this.feelsLikeF = feelsLikeF;
    }

    public String getFeelsLikeC() {
        return feelsLikeC;
    }

    public void setFeelsLikeC(String feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }

    public String getVisibilityMi() {
        return visibilityMi;
    }

    public void setVisibilityMi(String visibilityMi) {
        this.visibilityMi = visibilityMi;
    }

    public String getVisibilityKm() {
        return visibilityKm;
    }

    public void setVisibilityKm(String visibilityKm) {
        this.visibilityKm = visibilityKm;
    }

    public String getSolarRadiation() {
        return solarRadiation;
    }

    public void setSolarRadiation(String solarRadiation) {
        this.solarRadiation = solarRadiation;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public String getPrecipOneHourString() {
        return precipOneHourString;
    }

    public void setPrecipOneHourString(String precipOneHourString) {
        this.precipOneHourString = precipOneHourString;
    }

    public String getPrecipOneHourIn() {
        return precipOneHourIn;
    }

    public void setPrecipOneHourIn(String precipOneHourIn) {
        this.precipOneHourIn = precipOneHourIn;
    }

    public String getPrecipOneHourMetric() {
        return precipOneHourMetric;
    }

    public void setPrecipOneHourMetric(String precipOneHourMetric) {
        this.precipOneHourMetric = precipOneHourMetric;
    }

    public String getPrecipTodayString() {
        return precipTodayString;
    }

    public void setPrecipTodayString(String precipTodayString) {
        this.precipTodayString = precipTodayString;
    }

    public String getPrecipTodayIn() {
        return precipTodayIn;
    }

    public void setPrecipTodayIn(String precipTodayIn) {
        this.precipTodayIn = precipTodayIn;
    }

    public String getPrecipTodayMetric() {
        return precipTodayMetric;
    }

    public void setPrecipTodayMetric(String precipTodayMetric) {
        this.precipTodayMetric = precipTodayMetric;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getForecastUrl() {
        return forecastUrl;
    }

    public void setForecastUrl(String forecastUrl) {
        this.forecastUrl = forecastUrl;
    }

    public String getHistoryUrl() {
        return historyUrl;
    }

    public void setHistoryUrl(String historyUrl) {
        this.historyUrl = historyUrl;
    }

    public String getObUrl() {
        return obUrl;
    }

    public void setObUrl(String obUrl) {
        this.obUrl = obUrl;
    }

    @Override
    public String toString() {
        return "CurrentObservation [observationLocation=" + observationLocation
                + ", tempF=" + tempF + "]";
    }
}
