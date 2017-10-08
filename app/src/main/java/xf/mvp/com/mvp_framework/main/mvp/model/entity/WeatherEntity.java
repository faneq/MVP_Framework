package xf.mvp.com.mvp_framework.main.mvp.model.entity;

import java.util.List;

/**
 * Created by feq on 2017/10/8.
 */

public class WeatherEntity extends  BaseEntity {


    /**
     * date : 20171008
     * message : Success !
     * status : 200
     * city : 北京
     * count : 1
     * data : {"shidu":"87%","pm25":147,"pm10":153,"quality":"中度污染","wendu":"14","ganmao":"儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼，一般人群适量减少户外运动","yesterday":{"date":"07日星期六","sunrise":"06:15","high":"高温 19.0℃","low":"低温 13.0℃","sunset":"17:49","aqi":182,"fx":"东北风","fl":"<3级","type":"小雨","notice":"外出时请注意关好门窗，防止雨水飘入"},"forecast":[{"date":"08日星期日","sunrise":"06:16","high":"高温 18.0℃","low":"低温 13.0℃","sunset":"17:47","aqi":171,"fx":"东北风","fl":"<3级","type":"小雨","notice":"下雨了不要紧，撑伞挡挡就行"},{"date":"09日星期一","sunrise":"06:17","high":"高温 14.0℃","low":"低温 9.0℃","sunset":"17:46","aqi":49,"fx":"无持续风向","fl":"<3级","type":"中雨","notice":"将出现中雨，请携带雨具，避免湿身"},{"date":"10日星期二","sunrise":"06:18","high":"高温 12.0℃","low":"低温 9.0℃","sunset":"17:44","aqi":18,"fx":"南风","fl":"<3级","type":"阴","notice":"阴天没有晴天的明朗，却依然明亮"},{"date":"11日星期三","sunrise":"06:19","high":"高温 16.0℃","low":"低温 8.0℃","sunset":"17:42","aqi":54,"fx":"北风","fl":"<3级","type":"多云","notice":"今日多云，骑上单车去看看世界吧"},{"date":"12日星期四","sunrise":"06:20","high":"高温 15.0℃","low":"低温 6.0℃","sunset":"17:41","aqi":79,"fx":"西南风","fl":"<3级","type":"多云","notice":"悠悠的云里有淡淡的诗"}]}
     */

    private String date;
    private String message;
    private int status;
    private String city;
    private int count;
    /**
     * shidu : 87%
     * pm25 : 147.0
     * pm10 : 153.0
     * quality : 中度污染
     * wendu : 14
     * ganmao : 儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼，一般人群适量减少户外运动
     * yesterday : {"date":"07日星期六","sunrise":"06:15","high":"高温 19.0℃","low":"低温 13.0℃","sunset":"17:49","aqi":182,"fx":"东北风","fl":"<3级","type":"小雨","notice":"外出时请注意关好门窗，防止雨水飘入"}
     * forecast : [{"date":"08日星期日","sunrise":"06:16","high":"高温 18.0℃","low":"低温 13.0℃","sunset":"17:47","aqi":171,"fx":"东北风","fl":"<3级","type":"小雨","notice":"下雨了不要紧，撑伞挡挡就行"},{"date":"09日星期一","sunrise":"06:17","high":"高温 14.0℃","low":"低温 9.0℃","sunset":"17:46","aqi":49,"fx":"无持续风向","fl":"<3级","type":"中雨","notice":"将出现中雨，请携带雨具，避免湿身"},{"date":"10日星期二","sunrise":"06:18","high":"高温 12.0℃","low":"低温 9.0℃","sunset":"17:44","aqi":18,"fx":"南风","fl":"<3级","type":"阴","notice":"阴天没有晴天的明朗，却依然明亮"},{"date":"11日星期三","sunrise":"06:19","high":"高温 16.0℃","low":"低温 8.0℃","sunset":"17:42","aqi":54,"fx":"北风","fl":"<3级","type":"多云","notice":"今日多云，骑上单车去看看世界吧"},{"date":"12日星期四","sunrise":"06:20","high":"高温 15.0℃","low":"低温 6.0℃","sunset":"17:41","aqi":79,"fx":"西南风","fl":"<3级","type":"多云","notice":"悠悠的云里有淡淡的诗"}]
     */

    private DataBean data;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String shidu;
        private double pm25;
        private double pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        /**
         * date : 07日星期六
         * sunrise : 06:15
         * high : 高温 19.0℃
         * low : 低温 13.0℃
         * sunset : 17:49
         * aqi : 182.0
         * fx : 东北风
         * fl : <3级
         * type : 小雨
         * notice : 外出时请注意关好门窗，防止雨水飘入
         */

        private YesterdayBean yesterday;
        /**
         * date : 08日星期日
         * sunrise : 06:16
         * high : 高温 18.0℃
         * low : 低温 13.0℃
         * sunset : 17:47
         * aqi : 171.0
         * fx : 东北风
         * fl : <3级
         * type : 小雨
         * notice : 下雨了不要紧，撑伞挡挡就行
         */

        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public double getPm25() {
            return pm25;
        }

        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }

        public double getPm10() {
            return pm10;
        }

        public void setPm10(double pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
