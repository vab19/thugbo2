package is.hi.projecthotel.vinnsla;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

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
    @XmlType(name = "", propOrder = {
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
        
        public void setHotelId(int val) {
            this.hotelId = val;
        }
        
        public String getHotelName() {
            return hotelName;
        }
        
        public void setHotelName(String str) {
            this.hotelName = str;
        }
        
        public String getAddress() {
            return address;
        }
        
        public void setAddress(String str) {
            this.address = str;
        }
        
        public String getRegion() {
            return region;
        }
        
        public void setRegion(String str) {
            this.region = str;
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
            private Date date;
            private int rooms;
            
            public Date getDate() {
                return date;
            }
            
            public void setDate(Date val) {
                this.date = val;
            }
            
            public int getRooms() {
                return rooms;
            }
            
            public void setRooms(int val) {
                this.rooms = val;
            }
        }
    }
}
