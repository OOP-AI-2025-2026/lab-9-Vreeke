package ua.opnu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        if (list == null) return;
        for (int i = 0; i + 1 < list.size(); i++) {
            String a = list.get(i);
            String b = list.get(i + 1);
            if (a.length() <= b.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        if (list == null) return;
        for (int i = 0; i < list.size(); i += 2) {
            String s = list.get(i);
            list.add(i + 1, s);
        }
    }

    public void switchPairs(List<String> list) {
        if (list == null) return;
        for (int i = 0; i + 1 < list.size(); i += 2) {
            String a = list.get(i);
            String b = list.get(i + 1);
            list.set(i, b);
            list.set(i + 1, a);
        }
    }

    public void removeDuplicates(List<String> list) {
        if (list == null) return;
        for (int i = 0; i + 1 < list.size(); ) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        if (list == null) return;
        for (int i = 0; i < list.size(); ) {
            String s = list.get(i);
            if (s != null && s.length() == 4) {
                list.add(i, "****");
                i += 2;
            } else {
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue == null) return true;
        int n = queue.size();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            Integer x = queue.poll();
            stack.push(x);
            queue.offer(x);
        }

        boolean isPal = true;
        for (int i = 0; i < n; i++) {
            Integer x = queue.poll();
            Integer y = stack.pop();
            if (!x.equals(y)) isPal = false;
            queue.offer(x);
        }
        return isPal;
    }

    public void reorder(Queue<Integer> queue) {
        if (queue == null) return;
        int n = queue.size();
        Deque<Integer> stack = new ArrayDeque<>();

        int positivesCount = 0;
        for (int i = 0; i < n; i++) {
            Integer x = queue.poll();
            if (x < 0) {
                stack.push(x);
            } else {
                queue.offer(x);
                positivesCount++;
            }
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        for (int i = 0; i < positivesCount; i++) {
            queue.offer(queue.poll());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        if (queue == null) return;
        int n = queue.size();
        Deque<Integer> aux = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            Integer x = queue.poll();
            if (x % 2 == 0) {
                queue.offer(x);
            } else {
                aux.offer(x);
            }
        }

        while (!aux.isEmpty()) {
            queue.offer(aux.poll());
        }
    }

    public int maxLength(Set<String> set) {
        if (set == null || set.isEmpty()) return 0;
        int max = 0;
        for (String s : set) {
            if (s != null) {
                int len = s.length();
                if (len > max) max = len;
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        if (set == null || set.isEmpty()) return;
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s != null && s.length() % 2 == 0) {
                it.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null) return 0;
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer x : list1) {
            set1.add(x);
        }
        HashSet<Integer> common = new HashSet<>();
        for (Integer y : list2) {
            if (set1.contains(y)) common.add(y);
        }
        return common.size();
    }

    public boolean isUnique(Map<String, String> map) {
        if (map == null) return true;
        HashSet<String> seen = new HashSet<>();
        for (String v : map.values()) {
            if (!seen.add(v)) return false;
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        HashMap<String, Integer> result = new HashMap<>();
        if (map1 == null || map2 == null) return result;
        for (Map.Entry<String, Integer> e : map1.entrySet()) {
            String key = e.getKey();
            Integer val = e.getValue();
            if (map2.containsKey(key) && val != null && val.equals(map2.get(key))) {
                result.put(key, val);
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        HashMap<String, Integer> res = new HashMap<>();
        if (map == null) return res;
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            Integer k = e.getKey();
            String v = e.getValue();
            if (v == null) continue;
            Integer existingKey = res.get(v);
            if (existingKey == null || k > existingKey) {
                res.put(v, k);
            }
        }
        return res;
    }


    public int rarest(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) return 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (Integer v : map.values()) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        int bestValue = 0;
        int bestFreq = Integer.MAX_VALUE;
        boolean first = true;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int value = e.getKey();
            int f = e.getValue();
            if (first || f < bestFreq || (f == bestFreq && value < bestValue)) {
                bestFreq = f;
                bestValue = value;
                first = false;
            }
        }
        return bestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) return 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int best = 0;
        for (Integer x : list) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (f > best) best = f;
        }
        return best;
    }

}
