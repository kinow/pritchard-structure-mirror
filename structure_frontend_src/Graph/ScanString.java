package Graph;

import java.util.Hashtable;

/**
 * This class is similar to the ScanWord class, except it scans a string for
 * keywords rather than an input stream.
 * 
 * @version $Revision: 1.5 $, $Date: 1996/07/12 00:35:49 $
 * @author Leigh Brookshaw
 */

public class ScanString {
	/*
	 * ********************
	 * * Constants******************
	 */
	/**
	 * flag an unknown token
	 */
	public final static int UNKNOWN = -256;
	/**
	 * Flag an error
	 */
	public final static int ERROR = -257;
	/**
	 * Flag a Number
	 */
	public final static int NUMBER = -258;
	/**
	 * flag the End of String
	 */
	public final static int EOS = -259;

	/*
	 * *********************
	 * * Private Variables******************
	 */

	private String string;

	@SuppressWarnings("unused")
	private char buffer[];

	private int count;
	private int position;
	private int kwlength;

	public String sval;
	public double nval;

	/*
	 * * The hash table containing the keyword/value pairs.
	 */
	@SuppressWarnings("rawtypes")
	private Hashtable kwords = new Hashtable();

	/*
	 * *****************
	 * *
	 * * Constructors****************
	 */
	/**
	 * Instantiate the Class
	 */
	public ScanString() {
		string = null;
		count = 0;
		position = 0;
		kwlength = 0;
		buffer = new char[32];
		sval = null;
		nval = 0.0;
	}

	/**
	 * Instantaite the Class
	 * 
	 * @param s
	 *            String to scan for tokens
	 */
	public ScanString(String s) {
		setString(s);
	}

	/*
	 * *******************
	 * *
	 * * Public Methods******************
	 */

	/**
	 * Set the string to be scanned
	 * 
	 * @param s
	 *            String
	 */
	public void setString(String s) {
		if (s == null) {
			return;
		}
		string = new String(s);
		// System.out.println("ScanSring: string="+string);
	}

	/**
	 * Add a keyword/token pair to the table of keywords to scan for.
	 * 
	 * @param s
	 *            keyword string to scan for
	 * @param i
	 *            token to return when the keyword is found
	 */
	public void addKeyWord(String s, int i) {

		if (s == null) {
			return;
		}

		if (kwlength < s.length()) {
			kwlength = s.length();
		}
		kwords.put(s.toLowerCase(), new Integer(i));

		// System.out.println("addKeyWord: key="+s.toLowerCase()+" value="+i);

	}

	/**
	 * @param s
	 *            keyword string
	 * @return the token corresponding to the keyword
	 */
	public int getKeyValue(String s) {

		if (s == null) {
			return UNKNOWN;
		}

		if (!kwords.containsKey(s.toLowerCase())) {
			return UNKNOWN;
		}

		Integer i = (Integer) kwords.get(s.toLowerCase());

		if (i == null) {
			return UNKNOWN;
		} else {
			return i.intValue();
		}
	}

	/**
	 * Clear the table containing the keyword/token pairs
	 */
	public void resetKeyWords() {
		kwords.clear();
		kwlength = 0;
	}

	/**
	 * Process the string and return the next token found.
	 * 
	 * @return token found
	 */
	public int nextWord() {
		int i;
		char c;
		int word;
		int count = 0;
		char buffer[] = new char[string.length()];
		boolean exponent = false;
		boolean point = false;

		if (position >= string.length()) {
			return EOS;
		}

		c = string.charAt(position);
		/*
		 * * Remove white space
		 */
		while (c == 32 || c == 9 || c == 10 || c == 11 || c == 13) {
			position++;
			if (position >= string.length()) {
				return EOS;
			}
			c = string.charAt(position);
		}
		/*
		 * * Is this the start of a number ?
		 */

		if ((c >= '0' && c <= '9') || c == '.') {

			// System.out.println("ScanString: Scan for number!");

			for (i = position; i < string.length(); i++) {
				c = string.charAt(i);

				if (exponent && (c < '0' || c > '9')) {
					break;
				}

				if (c == 'E' || c == 'e' || c == 'D' || c == 'd') {
					exponent = true;
					buffer[count++] = 'e';

					c = string.charAt(i + 1);
					if (c == '-' || c == '+') {
						buffer[count++] = c;
						i++;
					}
				} else if (point && c == '.') {
					break;
				} else if (c == '.') {
					point = true;
					buffer[count++] = c;
				} else if (c < '0' || c > '9') {
					break;
				} else {
					buffer[count++] = c;
				}
			}

			try {
				sval = new String(buffer, 0, count);
				nval = Double.valueOf(sval).doubleValue();
				position += count;
				return NUMBER;
			} catch (Exception e) {
				return ERROR;
			}

		} else {
			/*
			 * * Scan for a keyword
			 */
			// System.out.println("ScanString: Scan for Word!");
			// System.out.println("ScanString: Maximum Keyword length "+kwlength);

			int last = UNKNOWN;
			int nchar = 0;
			int pos = position;

			while (pos < string.length()) {

				buffer[count++] = string.charAt(pos++);

				word = getKeyValue(new String(buffer, 0, count));

				if (word != UNKNOWN) {
					last = word;
					nchar = count;
					// System.out.println("ScanString: Found KeyWord - "+
					// new String(buffer,0,count));
				} else if (nchar == 0 && count >= kwlength) {
					return ERROR;
				} else if (count >= kwlength) {
					sval = new String(buffer, 0, nchar);
					position += nchar;
					// System.out.println("ScanString: Returning KeyWord - "+
					// sval);
					return last;
				}
			}

			if (nchar != 0) {
				sval = new String(buffer, 0, nchar);
				position += nchar;
				// System.out.println("ScanString: Returning KeyWord - "+
				// sval);
				return last;
			}

		}
		return ERROR;

	}

}
