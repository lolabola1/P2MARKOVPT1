import java.util.Arrays;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 *
 * @author Damilola Adewal
 *
 */
public class WordGram {

	private String[] myWords;
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for(int k = 0; k < size; k +=1){
			myWords[k] = source[start];
			start += 1;
		}
		myToString = null;
		myHash = 0;

		// TODO: initialize all instance variables
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){

		return myWords.length;
	}


	/**
	 * Complete appropriate comment here
	 * @param other
	 * @return
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof WordGram) || other == null) {
			return false;
		}
		WordGram wg = (WordGram) other;
		if (this.myWords.length == wg.myWords.length && Arrays.equals(this.myWords, (wg.myWords))) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode(){
		if (myHash == 0){
			myHash = this.toString().hashCode();}
		return myHash;
	}


	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		String[] newwords = new String[myWords.length];
		for (int k = 1; k < myWords.length; k +=1 ){
			int x = k-1;
			newwords[x] = myWords[k];}
		newwords[myWords.length-1] = last;
		WordGram ng = new WordGram(newwords,0,myWords.length);



		return ng;
	}

	@Override
	public String toString(){
		if (myToString == null){
			myToString = String.join(" ", myWords);}
		return myToString;
	}
}
