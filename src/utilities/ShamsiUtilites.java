package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShamsiUtilites {
	public static String gregorian_to_jalali(Date date) {
		int year = Integer.valueOf(new SimpleDateFormat("yyyy").format(date));
		int month = Integer.valueOf(new SimpleDateFormat("MM").format(date));
		int day = Integer.valueOf(new SimpleDateFormat("dd").format(date));
		return gregorian_to_jalali(year, month, day) + new SimpleDateFormat(" hh:mm").format(date);
	}

	private static String gregorian_to_jalali(int gy1, int gm1, int gd1) {
		int g_days_in_month[] = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int j_days_in_month[] = new int[] { 31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29 };
		int gy = gy1 - 1600;
		int gm = gm1 - 1;
		int gd = gd1 - 1;
		int g_day_no = 365 * gy + doubleToInt((gy + 3) / 4) - doubleToInt((gy + 99) / 100) + doubleToInt((gy + 399) / 400);
		int i;
		for (i = 0; i < gm; ++i)
			g_day_no += g_days_in_month[i];
		if (gm > 1 && ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0)))
			g_day_no++;
		g_day_no += gd;
		int j_day_no = g_day_no - 79;
		int j_np = doubleToInt(j_day_no / 12053); /* 12053 = 365*33 + 32/4 */
		j_day_no = j_day_no % 12053;
		int jy = 979 + 33 * j_np + 4 * doubleToInt(j_day_no / 1461); /*
																	 * 1461 =
																	 * 365*4 +
																	 * 4/4
																	 */
		j_day_no %= 1461;
		if (j_day_no >= 366) {
			jy += doubleToInt((j_day_no - 1) / 365);
			j_day_no = (j_day_no - 1) % 365;
		}
		for (i = 0; i < 11 && j_day_no >= j_days_in_month[i]; ++i)
			j_day_no -= j_days_in_month[i];
		int jm = i + 1;
		// int day=j_day_no+1;
		// int month=jm;
		// int year=jy;
		// this.jd =j_day_no+1;
		// this.jm =jm;
		// this.jy =jy;
		return jy + "/" + jm + "/" + (j_day_no + 1);
	}

	public static Date jalali_to_gregorian(int j_y, int j_m, int j_d) {
		int[] g_days_in_month = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] j_days_in_month = new int[] { 31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29 };

		int jy = j_y - 979;
		int jm = j_m - 1;
		int jd = j_d - 1;

		int j_day_no = 365 * jy + (jy / 33) * 8 + (jy % 33 + 3 / 4);
		for (int i = 0; i < jm; i++)
			j_day_no += j_days_in_month[i];

		j_day_no += jd;

		int g_day_no = j_day_no + 79;

		int gy = 1600 + 400 * (g_day_no / 146097); /*
													 * 146097 = 365*400 + 400/4
													 * - 400/100 + 400/400
													 */
		g_day_no = g_day_no % 146097;

		boolean leap = true;
		if (g_day_no >= 36525) /* 36525 = 365*100 + 100/4 */
		{
			g_day_no--;
			gy += 100 * (g_day_no / 36524); /* 36524 = 365*100 + 100/4 - 100/100 */
			g_day_no = g_day_no % 36524;

			if (g_day_no >= 365)
				g_day_no++;
			else
				leap = false;
		}

		gy += 4 * (g_day_no / 1461); /* 1461 = 365*4 + 4/4 */
		g_day_no %= 1461;

		if (g_day_no >= 366) {
			leap = false;

			g_day_no--;
			gy += (g_day_no / 365);
			g_day_no = g_day_no % 365;
		}

		int i = 0;
		int day_count = g_days_in_month[i];
		if (i == 1 && leap) {
			day_count += 1;
		}
		for (i = 0; g_day_no >= day_count; i++) {
			day_count = g_days_in_month[i];
			if (i == 1 && leap) {
				day_count += 1;
			}
			g_day_no -= day_count;
		}
		int gm = i + 1;
		int gd = g_day_no + 1;
		return new Date(gy, gm, gd);
	}

	private static int doubleToInt(double f) {
		Double fint = new Double(f);
		return fint.intValue();
	}
}
