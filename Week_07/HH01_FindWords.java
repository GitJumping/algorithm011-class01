package Week_07;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * all words ---> Trie 构建 prefix
 * board DFS
 * 这个题的时间复杂度计算已经时最高难度要求了，这个题的时间复杂分析比较经典
 *
 * https://www.cnblogs.com/chentianwei/p/11598410.html
 * https://yuepenglei.github.io/2019/01/06/Trie/
 */
public class HH01_FindWords {
    Integer[] dx = new Integer[]{-1, 1, 0, 0};
    Integer[] dy = new Integer[]{0, 0, -1, 1};

    public static void main(String[] args) {
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        HH01_FindWords hh01_findWords = new HH01_FindWords();
        System.out.println(hh01_findWords.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        //构建字典树
        WordTrie wordTrie = new WordTrie();
        TrieNode trieNode = wordTrie.root;
        for (String s : words) {
            wordTrie.insert(s);
        }

        //使用set防止重复
        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        //遍历整个二维数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(board, visited, i, j, m, n, result, trieNode);
            }
        }
//        System.out.println(result);
        return new LinkedList<String>(result);
    }

    private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result, TrieNode cur) {
        //边界是否已经访问判断
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }
        cur = cur.child[board[i][j] - 'a'];
        visited[i][j] = true;
        if (cur == null) {
            //如果单词不匹配，回溯
            visited[i][j] = false;
            return;
        }
        //找到单词加入
        if (cur.isLeaf) {
            result.add(cur.nodeVal);
            //找到单词后不能回溯，因为可能是'aa', 'addd'这样的单词，要继续回溯
            //visited[i][j] = false;
            //return;
        }
        find(board, visited, i + 1, j, m, n, result, cur);
        find(board, visited, i, j + 1, m, n, result, cur);
        find(board, visited, i, j - 1, m, n, result, cur);
        find(board, visited, i - 1, j, m, n, result, cur);
        //最后要回退，因为下一个起点可能用到上一个起点的字符
        visited[i][j] = false;
    }
}

/**
 * 字典树
 */
class WordTrie {
    public TrieNode root = new TrieNode();
    public void insert(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new TrieNode();
                cur = cur.child[c - 'a'];
            } else {
                cur = cur.child[c - 'a'];
            }
        }
        cur.isLeaf = true;
        cur.nodeVal = s;
    }
}

/**
 * 字典树结点
 */
class TrieNode {
    //结点值
    public String nodeVal;
    //结点分叉，最多26个分叉，26叉树
    public TrieNode[] child = new TrieNode[26];
    //是否叶子节点
    public boolean isLeaf = false;
    TrieNode() {

    }
}