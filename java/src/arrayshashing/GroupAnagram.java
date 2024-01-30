package arrayshashing;

// https://leetcode.com/problems/group-anagrams/description/

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {
  public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = new String[] {"", ""};
        String[] strs3 = new String[] {"and", "dan"};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams(strs2));
        System.out.println(groupAnagrams(strs3));

  }

  // SOL 1.

  private static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }
    for (String word : strs) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      map.putIfAbsent(key, new ArrayList<>());
      map.get(key).add(word);
    }
    return new ArrayList<>(map.values());
  }

  // SOL 2. Too slow
  private static List<List<String>> groupAnagrams2(String[] strs) {
    int index = 0;
    Map<String, List<String>> map = new HashMap<>();

    while (index < strs.length) {
      String s1 = strs[index];
      List<String> grouped = new ArrayList<>();
      grouped.add(s1);
      char[] currentWord = s1.toCharArray();
      Arrays.sort(currentWord);
      String key = String.valueOf(currentWord);

      for (int i = index + 1; i < strs.length; i++) {
        String s2 = strs[i];
        if (isAnagram(s1, s2)) {
          grouped.add(s2);
        }
      }
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>(grouped));
      }
      index++;
    }
    return new ArrayList<>(map.values());
  }

  private static boolean isAnagram(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    int[] letters = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      letters[s1.charAt(i) - 'a']++;
      letters[s2.charAt(i) - 'a']--;
    }

    for (int i = 0; i < letters.length; i++) {
      if (letters[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
