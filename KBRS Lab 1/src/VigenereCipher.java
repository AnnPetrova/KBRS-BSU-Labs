public class VigenereCipher implements Runnable {
    private int id;
    private String key;
    private String text;

    public VigenereCipher(int id, String key, String text) {
        this.id = id;
        this.key = key;
        this.text = text;
    }

    private static String encrypt(String text, final String key) {
        StringBuilder res = new StringBuilder();
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') {
                res.append(c);
                continue;
            }
            res.append((char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A'));
            j = ++j % key.length();
        }
        return res.toString();
    }

    private static String decrypt(String text, final String key) {
        StringBuilder res = new StringBuilder();
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') {
                res.append(c);
                continue;
            }
            res.append((char) ((c - key.charAt(j) + 26) % 26 + 'A'));
            j = ++j % key.length();
        }
        return res.toString();
    }

    @Override
    public void run() {
        String enc = encrypt(text, key);
        System.out.println(enc);
        System.out.println(id + " " + TestKasisky.kasiski(enc, 2, 12));
        System.out.println(decrypt(enc, key));
    }
}
