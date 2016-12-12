import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64; 

/**
 * <p>Java class for encrypt and decrypt .
 * @author luis.f.ronquillo
 */
public class TdesCrypto {

  private KeySpec keySpec; 
  private SecretKey key; 
  private IvParameterSpec iv; 

  /**
   * @param keyString an array with the key
   * @param ivString an array with the IV
   * 
   */
  public TdesCrypto(byte[] keyString, byte[] ivString) { 
	    try { 
	      keySpec = new DESedeKeySpec(keyString); 
	      key = SecretKeyFactory.getInstance("DESede").generateSecret(keySpec);	      
	      iv = new IvParameterSpec(ivString); 
		} catch (Exception e) {
			System.out.print("Error inicializando objeto TDES"+ e.getMessage());
		} 
	  }
  
  /**
   * @param value string to encrypt
   * @return the value encrypt
   */
  public String encrypt(String value) { 
	    try { 
	      Cipher ecipher = Cipher.getInstance("DESede/CBC/PKCS5Padding","SunJCE"); 
	      ecipher.init(Cipher.ENCRYPT_MODE, key, iv); 

	      if(value==null) 
	    return null; 

	      // Encode the string into bytes using utf-8 
	      byte[] utf8 = value.getBytes("UTF8"); 

	      // Encrypt 
	      byte[] enc = ecipher.doFinal(utf8); 

	      // Encode bytes to base64 to get a string 
	      return new String(Base64.encodeBase64(enc),"UTF-8"); 
	    } catch (Exception e) { 
	    	System.out.print("Error generando la encriptacion: "+ e.getMessage());
	    } 
	    return null; 
	  } 
  /**
   * @param value string to decrypt
   * @return the value decrypt
   */
  public String decrypt(String value) { 
	    try { 
	      Cipher dcipher = Cipher.getInstance("DESede/CBC/PKCS5Padding","SunJCE"); 
	      dcipher.init(Cipher.DECRYPT_MODE, key, iv); 

	      if(value==null) 
	    return null; 

	      // Decode base64 to get bytes 
	      byte[] dec = Base64.decodeBase64(value.getBytes()); 

	      // Decrypt 
	      byte[] utf8 = dcipher.doFinal(dec); 

	      // Decode using utf-8 
	      return new String(utf8, "UTF8"); 
	    } catch (Exception e) { 
	    	System.out.print("Error generando la des-encriptacion: "+ e.getMessage());
	    } 
	    return null; 
	  }  
}
