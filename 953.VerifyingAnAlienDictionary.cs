public class Solution {
    public bool IsAlienSorted(string[] words, string order) {
        var alphabet = Enumerable.Range(0, 26).ToDictionary(i => order[i], i => (char)('a' + i));
        var translated = words.Select(w => string.Concat(w.Select(c => alphabet[c])));
        return translated.OrderBy(x => x).SequenceEqual(translated);
    }
}