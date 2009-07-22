/**
 * Copyright 2009 Joe LaPenna
 */

package com.joelapenna.foursquare.parsers;

import com.joelapenna.foursquare.Foursquare;
import com.joelapenna.foursquare.error.FoursquareError;
import com.joelapenna.foursquare.error.FoursquareParseException;
import com.joelapenna.foursquare.types.Venue;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;

import java.io.IOException;

/**
 * Auto-generated: 2009-06-09 22:40:22.172418
 *
 * @author Joe LaPenna (joe@joelapenna.com)
 * @param <T>
 */
public class VenueParser extends AbstractParser<Venue> {
    private static final String TAG = "VenueParser";
    private static final boolean DEBUG = Foursquare.DEBUG;

    @Override
    public Venue parseInner(XmlPullParser parser) throws XmlPullParserException, IOException,
            FoursquareError, FoursquareParseException {
        parser.require(XmlPullParser.START_TAG, null, "venue");

        Venue venue = new Venue();

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            if (DEBUG) Log.d(TAG, "Tag Name: " + String.valueOf(parser.getName()));

            String name = parser.getName();
            if ("address".equals(name)) {
                venue.setAddress(parser.nextText());

            } else if ("city".equals(name)) {
                venue.setCity(parser.nextText());

            } else if ("crossstreet".equals(name)) {
                venue.setCrossstreet(parser.nextText());

            } else if ("geolat".equals(name)) {
                venue.setGeolat(parser.nextText());

            } else if ("geolong".equals(name)) {
                venue.setGeolong(parser.nextText());

            } else if ("id".equals(name)) {
                venue.setId(parser.nextText());

            } else if ("name".equals(name)) {
                venue.setName(parser.nextText());

            } else if ("phone".equals(name)) {
                venue.setPhone(parser.nextText());

            } else if ("state".equals(name)) {
                venue.setState(parser.nextText());

            } else if ("stats".equals(name)) {
                venue.setStats(parser.nextText());

            } else if ("tips".equals(name)) {
                venue.setTips(new GroupParser(new TipParser()).parse(parser));

            } else if ("zip".equals(name)) {
                venue.setZip(parser.nextText());

            } else {
                // Consume something we don't understand.
                if (DEBUG) Log.d(TAG, "Found tag that we don't recognize: " + name);
                skipSubTree(parser);
            }
        }
        return venue;
    }
}
