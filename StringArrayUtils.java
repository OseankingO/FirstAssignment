 

/**
 * Created by Yang on 1/23/20.
 */
import java.util.ArrayList;
import java.util.List;
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(String str : array) {
            if(str.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] res = new String[array.length]; 
        for(int i = 0; i < array.length; i ++) {
            res[array.length - i - 1] = array[i];
        }
        return res;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        int len;
        if(array.length % 2 == 0) {
            len = array.length / 2;
        } else {
            len = (array.length - 1) / 2;
        }
        for(int i = 0; i < len; i ++) {
            if(!array[i].equals(array[array.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        
        int count = 26;
        boolean[] alph = new boolean[26];
        for(int i = 0; i < alph.length; i ++) {
            alph[i] = false;
        }
        for(String word : array) {
            char[] letters = word.toCharArray();
            for(char letter : letters) {
                if(letter <= 'z' && letter >= 'a') {
                    if(!alph[letter - 'a']) {
                        count -= 1;
                        alph[letter - 'a'] = true;
                    } 
                }
                if(letter <= 'Z' && letter >= 'A') {
                    if(!alph[letter - 'A']) {
                        count -= 1;
                        alph[letter - 'A'] = true;
                    } 
                }
            }
            if(count == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for(String str : array) {
            if(value.equals(str)) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        List<String> res = new ArrayList<>();
        for(String str : array) {
            if(!str.equals(valueToRemove)) {
                res.add(str);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        String pre = null;
        List<String> res = new ArrayList<>();
        for(String str : array) {
            if(!str.equals(pre)) {
                pre = str;
                res.add(str);
            }
        }
        return res.toArray(new String[res.size()]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        String pre = null;
        String currentRes = array[0];
        List<String> res = new ArrayList<>();
        for(int i = 0; i < array.length; i ++) {
            if(!array[i].equals(pre)) {
                if(i != 0) {
                    res.add(currentRes);
                    currentRes = array[i];
                }
                pre = array[i];
            } else {
                currentRes += array[i];
            }
        }
        res.add(currentRes);
        return res.toArray(new String[res.size()]);
    }


}
