class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        var result = new ArrayList<String>();
        var hs = new HashSet<String>();
        for(var i: words) { 
            hs.add(i);
        }
        var hm = new HashMap<String, Integer>();
        for(var i: words) {
            if(check(i,hs,hm)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean check(String i, Set<String> hs, Map<String,Integer> hm) {
        if(hm.containsKey(i)) {
            return hm.get(i) == 1;
        }
        for(int z = 0; z < i.length(); z++) {
            if(hs.contains(i.substring(0,z))) {
                var s1 = i.substring(z);
                if (hs.contains(s1) || check(s1,hs,hm)) {
                    hm.put(i, 1);
                    return true;
                }
            }
        }
        hm.put(i, 0);
        return false;
    }
}