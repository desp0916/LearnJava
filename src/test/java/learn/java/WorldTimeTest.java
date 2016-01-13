/**
 * Joda DateTime to Timestamp conversion
 * http://stackoverflow.com/questions/15994450/joda-datetime-to-timestamp-conversion
 */
package learn.java;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;

public class WorldTimeTest {
    private static final int MILLIS_IN_HOUR = 1000 * 60 * 60;
    private static final String ISO_FORMAT_NO_TZ = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final String ISO_FORMAT_WITH_TZ = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

    private TimeZone londonTimeZone;
    private TimeZone newYorkTimeZone;
    private TimeZone sydneyTimeZone;
    private long nowInMillis;
    private Date now;

    public static SimpleDateFormat createDateFormat(String pattern, TimeZone timeZone) throws Exception {
        SimpleDateFormat result = new SimpleDateFormat(pattern);
        // Must explicitly set the time zone with "setCalendar()".
        result.setCalendar(Calendar.getInstance(timeZone));
        return result;
    }

    public static SimpleDateFormat createDateFormat(String pattern) throws Exception {
        return createDateFormat(pattern, TimeZone.getDefault());
    }

    public static SimpleDateFormat createDateFormat() throws Exception {
        return createDateFormat(ISO_FORMAT_WITH_TZ, TimeZone.getDefault());
    }

    public void printSystemInfo() throws Exception {
        final String[] propertyNames = {
                "java.runtime.name", "java.runtime.version", "java.vm.name", "java.vm.version",
                "os.name", "os.version", "os.arch",
                "user.language", "user.country", "user.script", "user.variant",
                "user.language.format", "user.country.format", "user.script.format",
                "user.timezone" };

        System.out.println();
        System.out.println("System Information:");
        for (String name : propertyNames) {
            if (name == null || name.length() == 0) {
                continue;
            }
            String value = System.getProperty(name);
            if (value != null && value.length() > 0) {
                System.out.println("  " + name + " = " + value);
            }
        }

        final TimeZone defaultTZ = TimeZone.getDefault();
        final int defaultOffset = defaultTZ.getOffset(nowInMillis) / MILLIS_IN_HOUR;
        final int userOffset = TimeZone.getTimeZone(System
                .getProperty("user.timezone")).getOffset(nowInMillis) / MILLIS_IN_HOUR;
        final Locale defaultLocale = Locale.getDefault();

        System.out.println("  default.timezone-offset (hours) = " + userOffset);
        System.out.println("  default.timezone = " + defaultTZ.getDisplayName());
        System.out.println("  default.timezone.id = " + defaultTZ.getID());
        System.out.println("  default.timezone-offset (hours) = " + defaultOffset);
        System.out.println("  default.locale = "
                + defaultLocale.getLanguage() + "_" + defaultLocale.getCountry()
                + " (" + defaultLocale.getDisplayLanguage()
                + "," + defaultLocale.getDisplayCountry() + ")");
        System.out.println("  now = " + nowInMillis + " [ms] or "
                + createDateFormat().format(now));
        System.out.println();
    }

    @Before
    public void setUp() throws Exception {
        // Remember this moment.
        now = new Date();
        nowInMillis = now.getTime(); // == System.currentTimeMillis();

        // Print out some system information.
        printSystemInfo();

        // "Europe/London" time zone is DST aware, we'll use fixed offset.
        londonTimeZone = TimeZone.getTimeZone("GMT");
        // The same applies to "America/New York" time zone ...
        newYorkTimeZone = TimeZone.getTimeZone("GMT-5");
        // ... and for the "Australia/Sydney" time zone.
        sydneyTimeZone = TimeZone.getTimeZone("GMT+10");
    }

    @Test
    public void testDateFormatting() throws Exception {
        int londonOffset = londonTimeZone.getOffset(nowInMillis) / MILLIS_IN_HOUR; // in hours
        Calendar londonCalendar = Calendar.getInstance(londonTimeZone);
        londonCalendar.setTime(now);

        int newYorkOffset = newYorkTimeZone.getOffset(nowInMillis) / MILLIS_IN_HOUR;
        Calendar newYorkCalendar = Calendar.getInstance(newYorkTimeZone);
        newYorkCalendar.setTime(now);

        int sydneyOffset = sydneyTimeZone.getOffset(nowInMillis) / MILLIS_IN_HOUR;
        Calendar sydneyCalendar = Calendar.getInstance(sydneyTimeZone);
        sydneyCalendar.setTime(now);

        // Check each time zone offset.
        assertThat(londonOffset, equalTo(0));
        assertThat(newYorkOffset, equalTo(-5));
        assertThat(sydneyOffset, equalTo(10));

        // Check that calendars are not equals (due to time zone difference).
        assertThat(londonCalendar, not(equalTo(newYorkCalendar)));
        assertThat(londonCalendar, not(equalTo(sydneyCalendar)));

        // Check if they all point to the same moment in time, in milliseconds.
        assertThat(londonCalendar.getTimeInMillis(), equalTo(nowInMillis));
        assertThat(newYorkCalendar.getTimeInMillis(), equalTo(nowInMillis));
        assertThat(sydneyCalendar.getTimeInMillis(), equalTo(nowInMillis));

        // Check if they all point to the same moment in time, as Date.
        assertThat(londonCalendar.getTime(), equalTo(now));
        assertThat(newYorkCalendar.getTime(), equalTo(now));
        assertThat(sydneyCalendar.getTime(), equalTo(now));

        // Check if hours are all different (skip local time because
        // this test could be executed in those exact time zones).
        assertThat(newYorkCalendar.get(Calendar.HOUR_OF_DAY),
                not(equalTo(londonCalendar.get(Calendar.HOUR_OF_DAY))));
        assertThat(sydneyCalendar.get(Calendar.HOUR_OF_DAY),
                not(equalTo(londonCalendar.get(Calendar.HOUR_OF_DAY))));


        // Display London time in multiple forms.
        SimpleDateFormat dfLondonNoTZ = createDateFormat(ISO_FORMAT_NO_TZ, londonTimeZone);
        SimpleDateFormat dfLondonWithTZ = createDateFormat(ISO_FORMAT_WITH_TZ, londonTimeZone);
        System.out.println("London (" + londonTimeZone.getDisplayName(false, TimeZone.SHORT)
                + ", " + londonOffset + "):");
        System.out.println("  time (ISO format w/o TZ) = "
                + dfLondonNoTZ.format(londonCalendar.getTime()));
        System.out.println("  time (ISO format w/ TZ)  = "
                + dfLondonWithTZ.format(londonCalendar.getTime()));
        System.out.println("  time (default format)    = "
                + londonCalendar.getTime() + " / " + londonCalendar.toString());
        // Using system default time zone.
        System.out.println("  time (default TZ)        = "
                + createDateFormat(ISO_FORMAT_NO_TZ).format(londonCalendar.getTime())
                + " / " + createDateFormat().format(londonCalendar.getTime()));


        // Display New York time in multiple forms.
        SimpleDateFormat dfNewYorkNoTZ = createDateFormat(ISO_FORMAT_NO_TZ, newYorkTimeZone);
        SimpleDateFormat dfNewYorkWithTZ = createDateFormat(ISO_FORMAT_WITH_TZ, newYorkTimeZone);
        System.out.println("New York (" + newYorkTimeZone.getDisplayName(false, TimeZone.SHORT)
                + ", " + newYorkOffset + "):");
        System.out.println("  time (ISO format w/o TZ) = "
                + dfNewYorkNoTZ.format(newYorkCalendar.getTime()));
        System.out.println("  time (ISO format w/ TZ)  = "
                + dfNewYorkWithTZ.format(newYorkCalendar.getTime()));
        System.out.println("  time (default format)    = "
                + newYorkCalendar.getTime() + " / " + newYorkCalendar.toString());
        // Using system default time zone.
        System.out.println("  time (default TZ)        = "
                + createDateFormat(ISO_FORMAT_NO_TZ).format(newYorkCalendar.getTime())
                + " / " + createDateFormat().format(newYorkCalendar.getTime()));


        // Display Sydney time in multiple forms.
        SimpleDateFormat dfSydneyNoTZ = createDateFormat(ISO_FORMAT_NO_TZ, sydneyTimeZone);
        SimpleDateFormat dfSydneyWithTZ = createDateFormat(ISO_FORMAT_WITH_TZ, sydneyTimeZone);
        System.out.println("Sydney (" + sydneyTimeZone.getDisplayName(false, TimeZone.SHORT)
                + ", " + sydneyOffset + "):");
        System.out.println("  time (ISO format w/o TZ) = "
                + dfSydneyNoTZ.format(sydneyCalendar.getTime()));
        System.out.println("  time (ISO format w/ TZ)  = "
                + dfSydneyWithTZ.format(sydneyCalendar.getTime()));
        System.out.println("  time (default format)    = "
                + sydneyCalendar.getTime() + " / " + sydneyCalendar.toString());
        // Using system default time zone.
        System.out.println("  time (default TZ)        = "
                + createDateFormat(ISO_FORMAT_NO_TZ).format(sydneyCalendar.getTime())
                + " / " + createDateFormat().format(sydneyCalendar.getTime()));
    }

    @Test
    public void testDateParsing() throws Exception {
        // Create date parsers that look for time zone information in a date-time string.
        final SimpleDateFormat londonFormatTZ = createDateFormat(ISO_FORMAT_WITH_TZ, londonTimeZone);
        final SimpleDateFormat newYorkFormatTZ = createDateFormat(ISO_FORMAT_WITH_TZ, newYorkTimeZone);
        final SimpleDateFormat sydneyFormatTZ = createDateFormat(ISO_FORMAT_WITH_TZ, sydneyTimeZone);

        // Create date parsers that ignore time zone information in a date-time string.
        final SimpleDateFormat londonFormatLocal = createDateFormat(ISO_FORMAT_NO_TZ, londonTimeZone);
        final SimpleDateFormat newYorkFormatLocal = createDateFormat(ISO_FORMAT_NO_TZ, newYorkTimeZone);
        final SimpleDateFormat sydneyFormatLocal = createDateFormat(ISO_FORMAT_NO_TZ, sydneyTimeZone);

        // We are looking for the moment this millenium started, the famous Y2K,
        // when at midnight everyone welcomed the New Year 2000, i.e. 2000-01-01 00:00:00.
        // Which of these is the right one?
        // a) "2000-01-01T00:00:00.000-00:00"
        // b) "2000-01-01T00:00:00.000-05:00"
        // c) "2000-01-01T00:00:00.000+10:00"
        // None of them? All of them?
        // For those who guessed it - yes, it is a trick question because we didn't specify
        // the "where" part, or what kind of time (local/global) we are looking for.
        // The first (a) is the local Y2K moment in London, which is at the same time global.
        // The second (b) is the local Y2K moment in New York, but London is already celebrating for 5 hours.
        // The third (c) is the local Y2K moment in Sydney, and they started celebrating 15 hours before New York did.
        // The point here is that each answer is correct because everyone thinks of that moment in terms of "celebration at midnight".
        // The key word here is "midnight"! That moment is actually a "time of day" moment illustrating our perception of time based on the movement of our Sun.

        // These are global Y2K moments, i.e. the same moment all over the world, UTC/GMT midnight.
        final String MIDNIGHT_GLOBAL = "2000-01-01T00:00:00.000-00:00";
        final Date milleniumInLondon = londonFormatTZ.parse(MIDNIGHT_GLOBAL);
        final Date milleniumInNewYork = newYorkFormatTZ.parse(MIDNIGHT_GLOBAL);
        final Date milleniumInSydney = sydneyFormatTZ.parse(MIDNIGHT_GLOBAL);

        // Check if they all point to the same moment in time.
        // And that parser ignores its own configured time zone and uses the information from the date-time string.
        assertThat(milleniumInNewYork, equalTo(milleniumInLondon));
        assertThat(milleniumInSydney, equalTo(milleniumInLondon));


        // These are all local Y2K moments, a.k.a. midnight at each location on Earth, with time zone information.
        final String MIDNIGHT_LONDON = "2000-01-01T00:00:00.000-00:00";
        final String MIDNIGHT_NEW_YORK = "2000-01-01T00:00:00.000-05:00";
        final String MIDNIGHT_SYDNEY = "2000-01-01T00:00:00.000+10:00";
        final Date midnightInLondonTZ = londonFormatLocal.parse(MIDNIGHT_LONDON);
        final Date midnightInNewYorkTZ = newYorkFormatLocal.parse(MIDNIGHT_NEW_YORK);
        final Date midnightInSydneyTZ = sydneyFormatLocal.parse(MIDNIGHT_SYDNEY);

        // Check if they all point to the same moment in time.
        assertThat(midnightInNewYorkTZ, not(equalTo(midnightInLondonTZ)));
        assertThat(midnightInSydneyTZ, not(equalTo(midnightInLondonTZ)));

        // Check if the time zone offset is correct.
        assertThat(midnightInLondonTZ.getTime() - midnightInNewYorkTZ.getTime(),
                equalTo((long) newYorkTimeZone.getOffset(milleniumInLondon.getTime())));
        assertThat(midnightInLondonTZ.getTime() - midnightInSydneyTZ.getTime(),
                equalTo((long) sydneyTimeZone.getOffset(milleniumInLondon.getTime())));


        // These are also local Y2K moments, just withouth the time zone information.
        final String MIDNIGHT_ANYWHERE = "2000-01-01T00:00:00.000";
        final Date midnightInLondon = londonFormatLocal.parse(MIDNIGHT_ANYWHERE);
        final Date midnightInNewYork = newYorkFormatLocal.parse(MIDNIGHT_ANYWHERE);
        final Date midnightInSydney = sydneyFormatLocal.parse(MIDNIGHT_ANYWHERE);

        // Check if these are the same as the local moments with time zone information.
        assertThat(midnightInLondon, equalTo(midnightInLondonTZ));
        assertThat(midnightInNewYork, equalTo(midnightInNewYorkTZ));
        assertThat(midnightInSydney, equalTo(midnightInSydneyTZ));

        // Check if they all point to the same moment in time.
        assertThat(midnightInNewYork, not(equalTo(midnightInLondon)));
        assertThat(midnightInSydney, not(equalTo(midnightInLondon)));

        // Check if the time zone offset is correct.
        assertThat(midnightInLondon.getTime() - midnightInNewYork.getTime(),
                equalTo((long) newYorkTimeZone.getOffset(milleniumInLondon.getTime())));
        assertThat(midnightInLondon.getTime() - midnightInSydney.getTime(),
                equalTo((long) sydneyTimeZone.getOffset(milleniumInLondon.getTime())));


        // Final check - if Y2K moment is in London ..
        final String Y2K_LONDON = "2000-01-01T00:00:00.000Z";
        // .. New York local time would be still 5 hours in 1999 ..
        final String Y2K_NEW_YORK = "1999-12-31T19:00:00.000-05:00";
        // .. and Sydney local time would be 10 hours in 2000.
        final String Y2K_SYDNEY = "2000-01-01T10:00:00.000+10:00";

        final String londonTime = londonFormatTZ.format(milleniumInLondon);
        final String newYorkTime = newYorkFormatTZ.format(milleniumInLondon);
        final String sydneyTime = sydneyFormatTZ.format(milleniumInLondon);

        // WHat do you think, will the test pass?
        assertThat(londonTime, equalTo(Y2K_LONDON));
        assertThat(newYorkTime, equalTo(Y2K_NEW_YORK));
        assertThat(sydneyTime, equalTo(Y2K_SYDNEY));
    }
}