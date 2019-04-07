package leit.hotel;

import javafx.collections.ObservableList;
import java.util.ArrayList;

public class searchActivity {

    /*
    * This function connects to the database and returns an ArrayList of Hotels corresponding to search conditions
    * that are taken in as arguments
    */
    public static ArrayList<Hotel> hotelSearch(String area, int guests, int maxprice) {
        HotelsDAO database = new HotelsDAO();
        ArrayList<Hotel> hotelResults = database.HotelSearch(maxprice, area, guests);
        // A string version of the hotel object is shown

        return hotelResults;
    }

    /*
    * This function sorts a list of hotels from a particular search based on the minimum room price
    * of each hotel
    */
    public static ArrayList<Object> priceSort(ObservableList<Object> hotelResults) {
        ArrayList<Object> hotelsPriceSorted = new ArrayList<Object>();
        int[] hotelPriceSort = new int[hotelResults.size()];
        // All price values are inserted into a normal int array, hotelPriceSort
        int index = 0;
        for (Object hotel : hotelResults) {
            Hotel nHotel = (Hotel) hotel;
            hotelPriceSort[index] = nHotel.getPrice();
            index++;
        }
        // Now, hotelPriceSort is sorted
        int tmp;
        for (int count = 1; count < hotelPriceSort.length; count++) {
            for (int i = 0; i < hotelPriceSort.length - 1; i++) {
                if (hotelPriceSort[i] > hotelPriceSort[i + 1]) {
                    tmp = hotelPriceSort[i];
                    hotelPriceSort[i] = hotelPriceSort[i + 1];
                    hotelPriceSort[i + 1] = tmp;
                }
            }
        }
        // Hotels with corresponding price values in the hotelResult list are found and added to hotelsPriceSorted sequentially
        for (int j = 0; j < hotelPriceSort.length; j++) {
            for (Object hotel : hotelResults) {
                Hotel aHotel = (Hotel) hotel;
                if (aHotel.getPrice() == hotelPriceSort[j]) {
                    hotelsPriceSorted.add(aHotel);
                }
            }
        }

        return hotelsPriceSorted;
    }

    /*
     * This function sorts a list of hotels from a particular search based on the number of reviews for each hotel
     */
    public static ArrayList<Object> reviewSort(ObservableList<Object> hotelResults) {
        ArrayList<Object> hotelsReviewsSorted = new ArrayList<Object>();
        int[] hotelReviewsSort = new int[hotelResults.size()];
        // All review number values are inserted into a normal int array, hotelReviewsSort
        int index = 0;
        for (Object hotel : hotelResults) {
            Hotel nHotel = (Hotel) hotel;
            int reviews = nHotel.getReviewNr();
            hotelReviewsSort[index] = reviews;
            index++;
        }

        // hotelReviewsSort is sorted
        int tmp;
        for (int count = 1; count < hotelReviewsSort.length; count++) {
            for (int i = 0; i < hotelReviewsSort.length - 1; i++) {
                if (hotelReviewsSort[i] > hotelReviewsSort[i + 1]) {
                    tmp = hotelReviewsSort[i];
                    hotelReviewsSort[i] = hotelReviewsSort[i + 1];
                    hotelReviewsSort[i + 1] = tmp;
                }
            }
        }

        // Hotels with corresponding number of reviews are found in the results and added sequentially into hotelsReviewsSorted
        for (int j = 0; j < hotelReviewsSort.length; j++) {
            for (Object hotel : hotelResults) {
                Hotel aHotel = (Hotel) hotel;
                if (aHotel.getReviewNr() == hotelReviewsSort[j] && !hotelsReviewsSorted.contains(hotel)) {
                    hotelsReviewsSorted.add(aHotel);
                }
            }
        }
        return hotelsReviewsSorted;
    }

    /*
     * This function sorts a list of hotels from a particular search based on the number of stars for each hotel
     */
    public static ArrayList<Object> starSort(ObservableList<Object> hotelResults) {
        ArrayList<Object> hotelsStarSorted = new ArrayList<Object>();
        int[] hotelStarSort = new int[hotelResults.size()];
        // All star number values are inserted into a normal int array, hotelStarsSort
        int index = 0;
        for (Object hotel : hotelResults) {
            Hotel nHotel = (Hotel) hotel;
            int stars = nHotel.getStars();
            hotelStarSort[index] = stars;
            index++;
        }

        // hotelStarsSort is sorted
        int tmp;
        for (int count = 1; count < hotelStarSort.length; count++) {
            for (int i = 0; i < hotelStarSort.length - 1; i++) {
                if (hotelStarSort[i] > hotelStarSort[i + 1]) {
                    tmp = hotelStarSort[i];
                    hotelStarSort[i] = hotelStarSort[i + 1];
                    hotelStarSort[i + 1] = tmp;
                }
            }
        }

        // Hotels with corresponding number of stars are found in the results and added sequentially into hotelsStarsSorted
        for (int j = 0; j < hotelStarSort.length; j++) {
            for (Object hotel : hotelResults) {
                Hotel aHotel = (Hotel) hotel;
                if (aHotel.getStars() == hotelStarSort[j] && !hotelsStarSorted.contains(hotel)) {
                    hotelsStarSorted.add(aHotel);
                }
            }
        }
        return hotelsStarSorted;
    }
}
