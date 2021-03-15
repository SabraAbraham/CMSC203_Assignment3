

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		
		boolean flag = true;

		for(int i = 0; i < plainText.length(); i++)

		{

		if(!((int)plainText.charAt(i)>=LOWER_BOUND && (int)plainText.charAt(i)<=UPPER_BOUND))

			{ //false if any character is outside the bounds

				flag = false;
				
				break;

			}

		}

		return flag;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {

		String cipherText = "";
		
		for(int i = 0; i < plainText.length(); i++)
		{
			char thisChar = plainText.charAt(i);
			//int intOfChar = (int)thisChar;
			
			
			int x = (int)thisChar + key;
	
			while(x>(int)UPPER_BOUND){
				x -= (int)RANGE;
			}
			
		
			
			cipherText += (char)x;
		}
		
		return cipherText;
		
		
//		String text = "";
//		
//		int length = plainText.length();
//		
//		for(int i = 0; i < length; i++)
//		{
//			char c = plainText.charAt(i);
//			
//			if(Character.isLetter(c))
//			{
//				
//				if(Character.isLowerCase(c))
//				{
//					char ch =(char)(c + key); // char casting
//					
//					if(ch > 'z')
//					{
//						text += (char)(c - (26-key)); // char casting
//					}
//					else
//					{
//						text += ch;
//					}
//				}
//				else if (Character.isUpperCase(c))
//				{
//					char ch =(char)(c + key); // char casting
//					
//					if(ch > 'Z')
//					{
//						text += (char)(c - (26-key)); // char casting
//					}
//					else
//					{
//						text += ch;
//					}
//				}
//			}
//			else
//			{
//				text += c;
//			}
//		}
//		
//		
//		return text;
		
		}
	
	
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {

		String cipherText = "";
		if(stringInBounds(plainText)==false) {
			return cipherText;
		}
		for(int i = 0; i < plainText.length(); i++)
		{
			char thisChar = plainText.charAt(i);
			//int intOfChar = (int)thisChar;
			
			
			int x = (int)thisChar + bellasoStr.charAt(i % bellasoStr.length());
	
			while(x>(int)UPPER_BOUND){
				x -= (int)RANGE;
			}
			
		
			
			cipherText += (char)x;
		}
		
		return cipherText;

		//encryption

	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		
		String cipherText = "";
		
		for(int i = 0; i < encryptedText.length(); i++)
		{
			char thisChar = encryptedText.charAt(i);
			//int intOfChar = (int)thisChar;
			
			
			int x = (int)thisChar - key;
	
			while(x<(int)LOWER_BOUND){
				x += (int)RANGE;
			}
			
		
			
			cipherText += (char)x;
		}
		
		return cipherText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr)
	{
		String cipherText = "";
		
		for(int i = 0; i < encryptedText.length(); i++)
		{
			char thisChar = encryptedText.charAt(i);
			//int intOfChar = (int)thisChar;
			
			
			int x = (int)thisChar - (int)bellasoStr.charAt(i % bellasoStr.length());
	
			while(x<(int)LOWER_BOUND){
				x += (int)RANGE;
			}
			
		
			
			cipherText += (char)x;
		}
		
		return cipherText;
		
		
	}
}