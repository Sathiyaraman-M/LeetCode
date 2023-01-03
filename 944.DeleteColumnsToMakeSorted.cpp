class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int index = 0;
        for(int i = 0; i < strs[0].size(); i++) {
            for(int j = 0; j < strs.size() - 1; j++) {
                if(strs[j + 1][i] < strs[j][i]) {
                    index++;
                    break;
                }
            }
        }
        return index;
    }
};