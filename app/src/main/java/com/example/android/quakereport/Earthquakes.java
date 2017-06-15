package com.example.android.quakereport;


class Earthquakes {

    private double  mMagnitudeNumber;
    private String  mLocationName;
//    private String mDate;
    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    /** Website URL of the earthquake */
    private String mUrl;


    Earthquakes(double magnitudeNumber , String locationName, long timeInMilliseconds, String url) {
        mMagnitudeNumber = magnitudeNumber;
        mLocationName = locationName;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
//        mDate = date;
    }

    double getMagnitudeNumber() {return mMagnitudeNumber;}
    String getLocationName() { return mLocationName;}
    long getTimeInMilliseconds() { return mTimeInMilliseconds;}
    String getUrl(){return mUrl;}

//    String getDate(){ return mDate; }

}
