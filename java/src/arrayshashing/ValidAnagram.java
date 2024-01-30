package arrayshashing;

// https://leetcode.com/problems/valid-anagram/description/

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
  public static void main(String[] args) {

    System.out.println(isAnagram("anagram", "nagaram")); // true
    System.out.println(isAnagram("rat", "car")); // false
    System.out.println(isAnagram("aacc", "ccac")); // false
  }

  // SOL 1. Using hashmap
  private static boolean isAnagram(String s, String t) {

    int sLen = s.length();
    int tLen = t.length();
    if (sLen != tLen) {
      return false;
    }

    Map<Character, Integer> letters = new HashMap<>();
    s.chars()
        .mapToObj(c -> (char) c)
        .forEach(
            character -> {
              letters.put(character, letters.getOrDefault(character, 0) + 1);
            });

    for (int i = 0; i < tLen; i++) {
      char letter = t.charAt(i);
      if (!letters.containsKey(letter)) {
        return false;
      }
      letters.replace(letter, letters.get(letter) - 1);
    }
    return letters.values().stream().allMatch(n -> n.equals(0));
  }


  // SOL 2. using array for lowercase chars only but faster computation
  private static boolean isAnagram2(String s, String t) {
    int[] letters = new int[26];
    if (s.length() != t.length()) {
      return false;
    }

    for(int i = 0; i < s.length(); i++) {
      letters[s.charAt(i) - 'a']++;
      letters[t.charAt(i) - 'a']--;
    }

    for(int i = 0; i < letters.length; i++) {
      if (letters[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
