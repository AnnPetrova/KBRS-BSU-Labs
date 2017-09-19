import java.util.*;

public class TestKasisky {
    public static int kasiski(String text, int minKeyLength, int maxKeyLength) {
        HashMap<String, Substring> substringMap = new HashMap<String, Substring>();
        text = format(text);
        String sub;

        for (int i = 0; i < text.length() - 2; i++) {
            sub = text.substring(i, i + 3);
            if (substringMap.containsKey(sub)) {
                substringMap.get(sub).addOccurance(i);
            } else {
                substringMap.put(sub, new Substring(sub, i));
            }
        }

        ArrayList<Substring> substrings = new ArrayList<Substring>(
                substringMap.values());

        substrings = Substring.removeSingleOccurrenceSubstrings(substrings);


        HashMap<Integer, Integer> factorOccurances = new HashMap<Integer, Integer>();
        for (Substring substr : substrings) {
            ArrayList<Integer> differences = substr.getDifferences(true);
            for (Integer diff : differences) {
                ArrayList<Integer> factors = calculateFactors(diff);
                for (Integer fact : factors) {
                    if (factorOccurances.containsKey(fact)) {
                        Integer temp = factorOccurances.get(fact);
                        factorOccurances.put(fact, ++temp);
                    } else {
                        factorOccurances.put(fact, 1);
                    }
                }
            }
        }
        int length = estimateKeyLength(factorOccurances, minKeyLength, maxKeyLength);
        tryBreakKey(length, text);
        return length;
    }

    private static void tryBreakKey(int length, String text) {
        StringBuilder tipkey = new StringBuilder();
        for (int j = 0; j < length; j++) {
            StringBuilder s = new StringBuilder();
            for (int i = j; i < text.length(); i += length) {
                s.append(text.charAt(i));
            }
            char[] chars = s.toString().toUpperCase().toCharArray();
            List<Character> characters = new ArrayList<>();
            for (char c : chars) {
                characters.add(new Character(c));
            }
            Map<Character, Integer> realFreq = new HashMap<>();
            int totalSize = 0;
            int tmp;
            for (Character c : Constants.FREQ_MAP.keySet()) {
                tmp = Collections.frequency(characters, new Character(c));
                realFreq.put(c, tmp);
                totalSize += tmp;
            }

            int smallestIndex = 0;
            double[] indexArray = new double[Constants.NUMBER_OF_LETTERS];
            for (int k = 0; k < Constants.NUMBER_OF_LETTERS; k++) {
                realFreq = tryShift(decrypt(chars, k));
                indexArray[k] = findDistance(realFreq, totalSize);
            }

            double currentValue = indexArray[0];
            for (int k = 0; k < Constants.NUMBER_OF_LETTERS; k++) {
                if (indexArray[k] < currentValue) {
                    currentValue = indexArray[k];
                    smallestIndex = k;
                }
            }
            tipkey.append((char) ('A' + smallestIndex));
        }
        System.out.println(tipkey.toString());
    }

    private static Map<Character, Integer> tryShift(String decrypt) {
        Map<Character, Integer> realFreq = new HashMap<>();
        int totalSize = 0;
        int tmp;
        List<Character> characters = new ArrayList<>();
        for (char c : decrypt.toCharArray()) {
            characters.add(new Character(c));
        }
        for (Character c : Constants.FREQ_MAP.keySet()) {
            tmp = Collections.frequency(characters, c);
            realFreq.put(c, tmp);
            totalSize += tmp;
        }
        return realFreq;
    }

    public static double findDistance(Map<Character, Integer> realFreq, int totalSize) {
        double distance = 0.0;
        for (Character c : Constants.FREQ_MAP.keySet()) {
            distance += Math.abs(Constants.FREQ_MAP.get(c) - (realFreq.get(c) / (double) totalSize));
        }
        return distance;
    }

    public static String decrypt(char[] ciphertext, int numberOfPositions) {
        return encrypt(ciphertext, -numberOfPositions);
    }

    public static String encrypt(char[] msg, int offset) {

        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : msg) {
            if (Character.isUpperCase(i)) {
                int h = (i - 'A' + offset) % 26;
                encoded.append((char) (h + 'A'));
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

    public static int estimateKeyLength(HashMap<Integer, Integer> occurances,
                                        int minKeyLength, int maxKeyLength) {
        Set<Integer> keys = occurances.keySet();
        Integer maxKey = 0;
        Integer maxFreq = 0;
        for (Integer key : keys) {
            if (key < minKeyLength)
                continue;
            if (key > maxKeyLength)
                continue;
            Integer freq = occurances.get(key);
            if (freq >= maxFreq && key >= minKeyLength && key <= maxKeyLength) {
                maxFreq = freq;
                maxKey = key;
            }
        }
        if (maxKey < minKeyLength) {
            return minKeyLength;
        } else if (maxKey > maxKeyLength) {
            return maxKeyLength;
        } else {
            return maxKey;
        }
    }

    public static String format(String text) {
        return text.toUpperCase().replaceAll("[^\\p{L}]", "");
    }

    public static ArrayList<Integer> calculateFactors(int num) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        int n = num;
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        int size = factors.size();
        for (int i = size - 1; i >= 0; i--) {
            factors.add(num / factors.get(i));
        }

        return factors;
    }
}
