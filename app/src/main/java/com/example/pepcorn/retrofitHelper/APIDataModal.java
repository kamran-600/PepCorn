package com.example.pepcorn.retrofitHelper;


/* private ArrayList<DataModal> data;
 private MetaData meta;
 private Map<String, String> links;

 public ArrayList<DataModal> getData() {
     return data;
 }

 public void setData(ArrayList<DataModal> data) {
     this.data = data;
 }

 public static class DataModal {

     private String record_date, security_type_desc, security_desc, avg_interest_rate_amt, src_line_nbr, record_fiscal_year, record_fiscal_quarter, record_calendar_year, record_calendar_quarter, record_calendar_month, record_calendar_day;

     public String getRecord_date() {
         return record_date;
     }

     public void setRecord_date(String record_date) {
         this.record_date = record_date;
     }

     public String getSecurity_type_desc() {
         return security_type_desc;
     }

     public void setSecurity_type_desc(String security_type_desc) {
         this.security_type_desc = security_type_desc;
     }

     public String getSecurity_desc() {
         return security_desc;
     }

     public void setSecurity_desc(String security_desc) {
         this.security_desc = security_desc;
     }

     public String getAvg_interest_rate_amt() {
         return avg_interest_rate_amt;
     }

     public void setAvg_interest_rate_amt(String avg_interest_rate_amt) {
         this.avg_interest_rate_amt = avg_interest_rate_amt;
     }

     public String getSrc_line_nbr() {
         return src_line_nbr;
     }

     public void setSrc_line_nbr(String src_line_nbr) {
         this.src_line_nbr = src_line_nbr;
     }

     public String getRecord_fiscal_year() {
         return record_fiscal_year;
     }

     public void setRecord_fiscal_year(String record_fiscal_year) {
         this.record_fiscal_year = record_fiscal_year;
     }

     public String getRecord_fiscal_quarter() {
         return record_fiscal_quarter;
     }

     public void setRecord_fiscal_quarter(String record_fiscal_quarter) {
         this.record_fiscal_quarter = record_fiscal_quarter;
     }

     public String getRecord_calendar_year() {
         return record_calendar_year;
     }

     public void setRecord_calendar_year(String record_calendar_year) {
         this.record_calendar_year = record_calendar_year;
     }

     public String getRecord_calendar_quarter() {
         return record_calendar_quarter;
     }

     public void setRecord_calendar_quarter(String record_calendar_quarter) {
         this.record_calendar_quarter = record_calendar_quarter;
     }

     public String getRecord_calendar_month() {
         return record_calendar_month;
     }

     public void setRecord_calendar_month(String record_calendar_month) {
         this.record_calendar_month = record_calendar_month;
     }

     public String getRecord_calendar_day() {
         return record_calendar_day;
     }

     public void setRecord_calendar_day(String record_calendar_day) {
         this.record_calendar_day = record_calendar_day;
     }

    @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof DataModal)) return false;
         DataModal dataModal = (DataModal) o;
         return getRecord_date().equals(dataModal.getRecord_date()) && getSecurity_type_desc().equals(dataModal.getSecurity_type_desc()) && getSecurity_desc().equals(dataModal.getSecurity_desc()) && getAvg_interest_rate_amt().equals(dataModal.getAvg_interest_rate_amt()) && getSrc_line_nbr().equals(dataModal.getSrc_line_nbr()) && getRecord_fiscal_year().equals(dataModal.getRecord_fiscal_year()) && getRecord_fiscal_quarter().equals(dataModal.getRecord_fiscal_quarter()) && getRecord_calendar_year().equals(dataModal.getRecord_calendar_year()) && getRecord_calendar_quarter().equals(dataModal.getRecord_calendar_quarter()) && getRecord_calendar_month().equals(dataModal.getRecord_calendar_month()) && getRecord_calendar_day().equals(dataModal.getRecord_calendar_day());
     }

     @Override
     public int hashCode() {
         return Objects.hash(getRecord_date(), getSecurity_type_desc(), getSecurity_desc(), getAvg_interest_rate_amt(), getSrc_line_nbr(), getRecord_fiscal_year(), getRecord_fiscal_quarter(), getRecord_calendar_year(), getRecord_calendar_quarter(), getRecord_calendar_month(), getRecord_calendar_day());
     }
 }

 public MetaData getMeta() {
     return meta;
 }

 public void setMeta(MetaData meta) {
     this.meta = meta;
 }

 public static class MetaData {
     private int count;
     private Map<String, String> labels;
     private Map<String, String> dataTypes;
     private Map<String, String> dataFormats;
     private int totalCount;
     private int totalPages;

     public int getCount() {
         return count;
     }

     public void setCount(int count) {
         this.count = count;
     }

     public Map<String, String> getLabels() {
         return labels;
     }

     public void setLabels(Map<String, String> labels) {
         this.labels = labels;
     }

     public Map<String, String> getDataTypes() {
         return dataTypes;
     }

     public void setDataTypes(Map<String, String> dataTypes) {
         this.dataTypes = dataTypes;
     }

     public Map<String, String> getDataFormats() {
         return dataFormats;
     }

     public void setDataFormats(Map<String, String> dataFormats) {
         this.dataFormats = dataFormats;
     }

     public int getTotalCount() {
         return totalCount;
     }

     public void setTotalCount(int totalCount) {
         this.totalCount = totalCount;
     }

     public int getTotalPages() {
         return totalPages;
     }

     public void setTotalPages(int totalPages) {
         this.totalPages = totalPages;
     }
 }


 public Map<String, String> getLinks() {
     return links;
 }

 public void setLinks(Map<String, String> links) {
     this.links = links;
 }*/

  /*  private final String  schemeName;
    private final int schemeCode;

    public APIDataModal(String schemeName, int schemeCode) {
        this.schemeName = schemeName;
        this.schemeCode = schemeCode;
    }

    public String getSchemeName() {
        return schemeName;
    }
    public int getSchemeCode() {
        return schemeCode;
    }
*/
/*
    public int userId,that;
    public String title, body;

   *//* public APIDataModal() {
    }

    public APIDataModal(int userId, int that, String title, String body) {
        this.userId = userId;
        this.that = that;
        this.title = title;
        this.body = body;
    }*//*


    public int getUserId() {
        return userId;
    }

    public int getThat() {
        return that;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }*/



import java.util.List;
import java.util.Objects;

public class APIDataModal {
    private Meta meta;
    private List<DataModal> data;
    private String status;

    // Getters and Setters

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<DataModal> getData() {
        return data;
    }

    public void setData(List<DataModal> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Meta {
        private String fund_house;
        private String scheme_type;
        private String scheme_category;
        private int scheme_code;
        private String scheme_name;

        // Getters and Setters

        public String getFund_house() {
            return fund_house;
        }

        public void setFund_house(String fund_house) {
            this.fund_house = fund_house;
        }

        public String getScheme_type() {
            return scheme_type;
        }

        public void setScheme_type(String scheme_type) {
            this.scheme_type = scheme_type;
        }

        public String getScheme_category() {
            return scheme_category;
        }

        public void setScheme_category(String scheme_category) {
            this.scheme_category = scheme_category;
        }

        public int getScheme_code() {
            return scheme_code;
        }

        public void setScheme_code(int scheme_code) {
            this.scheme_code = scheme_code;
        }

        public String getScheme_name() {
            return scheme_name;
        }

        public void setScheme_name(String scheme_name) {
            this.scheme_name = scheme_name;
        }
    }

    public static class DataModal {
        private String date;
        private double nav;

        // Getters and Setters

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getNav() {
            return nav;
        }

        public void setNav(double nav) {
            this.nav = nav;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DataModal)) return false;
            DataModal dataModal = (DataModal) o;
            return Double.compare(dataModal.getNav(), getNav()) == 0 && getDate().equals(dataModal.getDate());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getDate(), getNav());
        }
    }
}