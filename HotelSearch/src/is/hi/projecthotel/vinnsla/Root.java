package is.hi.projecthotel.vinnsla;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="results" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="originalTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="shortDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="live" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="premier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="aspectRatio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="series">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="episode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="series" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "results"
})
@XmlRootElement(name = "root")
public class Root {

    protected List<Root.Results> results;

    /**
     * Gets the value of the results property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the results property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Root.Results }
     * 
     * 
     */
    public List<Root.Results> getResults() {
        if (results == null) {
            results = new ArrayList<Root.Results>();
        }
        return this.results;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="originalTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}time"/>
     *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="shortDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="live" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="premier" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="aspectRatio" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="series">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="episode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="series" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
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
        protected String title;
        @XmlElement(required = true)
        protected String originalTitle;
        @XmlElement(required = true)
        @XmlSchemaType(name = "time")
        protected XMLGregorianCalendar duration;
        @XmlElement(required = true)
        protected String description;
        @XmlElement(required = true)
        protected String shortDescription;
        @XmlElement(required = true)
        protected String live;
        @XmlElement(required = true)
        protected String premier;
        @XmlElement(required = true)
        protected String startTime;
        @XmlElement(required = true)
        protected String aspectRatio;
        
        private int hotelId;
        private String hotelName;
        private String address;
        private String region;
        private int pricePerNight;
        private int Stars;
        private int rating;
        private Review review;
        

        /**
         * Gets the value of the series property.
         * 
         * @return
         *     possible object is
         *     {@link Root.Results.Series }
         *     
         */
        public Root.Results.Review getReview() {
            return review;
        }

        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="episode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="series" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
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
        public static class roomsAvailable {
            private Date date;
            private int rooms;
            
            public int getRooms() {
                return rooms;
            }
            
            public void setRooms(int val) {
                this.rooms = val;
            }
        }
    }
}
