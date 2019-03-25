package is.hi.projecthotel.vinnsla;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.Calendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "results"
})
@XmlRootElement(name = "root")
public class Root {

    protected List<Root.Results> results;

    public List<Root.Results> getResults() {
        if (results == null) {
            results = new ArrayList<Root.Results>();
        }
        return this.results;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "results", propOrder = {
        "hotelId",
        "hotelName",
        "address",
        "region",
        "pricePerNight",
        "distanceDowntown",
        "stars",
        "rating",
        "review",
        "roomsAvailable"
    })
    public static class Results {

        @XmlElement(required = true)
        private int hotelId;
        @XmlElement(required = true)
        private String hotelName;
        @XmlElement(required = true)
        private String address;
        @XmlElement(required = true)
        private String region;
        @XmlElement(required = true)
        private int pricePerNight;
        @XmlElement(required = true)
        private int stars;
        @XmlElement(required = true)
        private int rating;
        @XmlElement(required = true)
        private Review review;
        @XmlElement(required = true)
        private roomsAvailable roomsAvailable;

        public int getHotelId() {
            return hotelId;
        }
        
        public String getHotelName() {
            return hotelName;
        }
        
        public String getAddress() {
            return address;
        }
        
        
        public String getRegion() {
            return region;
        }
        
        public int getPricePerNight() {
            return pricePerNight;
        }
        
        public void setPricePernight(int val) {
            this.pricePerNight = val;
        }
        
        public int getStars() {
            return stars;
        }
        
        public void setStars(int val) {
            this.stars = val;
        }
        
        public int getRating() {
            return rating;
        }
        
        public void setRating(int val) {
            this.rating = val;
        }
        
        /**
         * Gets the value of the series property.
         * @return
         *     possible object is
         *     {@link Root.Results.Series }
         *     
         */
        public Root.Results.Review getReview() {
            return review;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "review",
            "rating",
            "customerId",
            "hotelId"
        })
        public static class Review {

            private static String review;
            private static int rating;
            private static int customerId;
            private static int hotelId;
            
            public String getReview() {
                return review;
            }
            
            public void setReview(String str) {
                this.review = str;
            }
            
            public int getRating() {
                return rating;
            }
            
            public void setRating(int val) {
                this.rating = val;
            }
            
            public int getCustomerId() {
                return customerId;
            }
            
            public void setCustomerId(int val) {
                this.customerId = val;
            }
            
            public int getHotelId() {
                return hotelId;
            }
            
            public void setHotelId(int val) {
                this.hotelId = val;
            }
        }
        
        
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "date",
            "rooms"
        })
        public static class roomsAvailable {
            //private Date date;
            private int rooms;
            private int yearLength = 366;
            int[] available = new int[yearLength];
            private void roomsAvailable(int rooms) {
                for(int i=0;i<yearLength;i++) {
                    available[i] = (int) Math.random()*(rooms+1);
                }
            }
            
            public boolean isAvailable(Calendar val) {
              
                
                return available[val.get(Calendar.MONTH)*12+val.get(Calendar.DATE)] != 0;
            }
            
            public void bookRoom(Calendar val) {
                available[val.get(Calendar.MONTH)*12+val.get(Calendar.DATE)]--;
            }
            
            public void unBookRoom(Calendar val) {
                available[val.get(Calendar.MONTH)*12+val.get(Calendar.DATE)]++;
            }
        }
    }
}