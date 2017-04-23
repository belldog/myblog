package com.zjw.blog.utils.encrypt;

import java.util.Map;

public class RSAUtils {

    private String publicKey;
    private String privateKey;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String encryptByPrivateKey(String inputStr) {
        byte[] data = inputStr.getBytes();
        try {
            byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);
            return RSACoder.encryptBASE64(encodedData);
        } catch (Exception e) {
            return null;
        }

    }

    public String decryptByPublicKey(String inputStr) {
        try {
            byte[] encodedData = RSACoder.decryptBASE64(inputStr);
            byte[] decodedData = RSACoder
                    .decryptByPublicKey(encodedData, publicKey);
            return new String(decodedData);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Map<String, Object> keyMap = RSACoder.initKey();

            String publicKey = RSACoder.getPublicKey(keyMap);
            String privateKey = RSACoder.getPrivateKey(keyMap);
            //publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCvjw3HVBb3LeVcJpia++MrLEotpULf50BLxyQutByH1FVjfP/RAnZ6yB55gKfs/PDOWlKVGQirD6faT+rQuV3/aewOP28I+TmDu6U4OLilQGKQmPD5VEgWnd5/1f0rwu07JapPU2jEF31leFTDcoCNrUQpoqe53Yp8TZcrxCHPdwIDAQAB";
            //privateKey= "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK+PDcdUFvct5VwmmJr74yssSi2lQt/nQEvHJC60HIfUVWN8/9ECdnrIHnmAp+z88M5aUpUZCKsPp9pP6tC5Xf9p7A4/bwj5OYO7pTg4uKVAYpCY8PlUSBad3n/V/SvC7Tslqk9TaMQXfWV4VMNygI2tRCmip7ndinxNlyvEIc93AgMBAAECgYBHWAJIc+LVVoBz/3da3GxIGjqW7CcOKMMXSHlqxWUmyeJdiOnI/ZA6e2LvC5qyk2Qk583Rq5e7NKSI8ptBcWNCATMGb+JF4tI9XF+oH6FNLM5nRjv4NTuMmPVrcpgGv8dPcHmcwpT44o5J38JxFyDpcNWrZ1IrLqD5oRoYdlxrCQJBAN+mMcRG42GEy72zYHwoL9+xnNu18+yzzd4yUkx5oqvD8md+X5CiXwuaxkOzBs33TRBivEDl7V3vVrv/cP+o5jUCQQDI9A5NOSSwKuhkjdfIKXxOmHqU6jed0DBKYpfT+XaoAYa5VhLrj9TtNhR2rHmfFga4qw8J8dXfSxgrLZPLpOR7AkEAwbbU8looRuZcBtLg5ol0dgAEinW+cq6GyUey6xSMJtTRGH1oTwGk64tC4Y6mfS4P7Ppobpn5EFznNm0ZtgfYZQJAPmOfSRRzsoovyoBLPSa8JD6s2Cz7hXCMfZusnbA2yaRnqoTxrNbj+Z2vrsSPofeZsJ3TNngxuXi8ETO+ThxsnwJAN6L9wM4X5GEkXxrZitji5yOj9hXqDCwOY8sm9v+xLIxZBiqT5TkKKQSEJzrSRIehciG8B7v+zig+8ZchgRPH0w==";
            System.err.println("公钥: \n\r" + publicKey);
            System.err.println("私钥： \n\r" + privateKey);
        } catch (Exception e) {

        }
    }

}
