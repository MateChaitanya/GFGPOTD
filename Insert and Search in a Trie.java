static void insert(TrieNode root, String key) 
{
    // Your code here
    TrieNode temp = root;
    for(int i=0;i<key.length();i++){
        if(temp.children[key.charAt(i)-'a']==null){
            temp.children[key.charAt(i)-'a']=new TrieNode();
        }
        temp=temp.children[key.charAt(i)-'a'];
        if(i==key.length()-1)temp.isEndOfWord=true;
    }
}

//Function to use TRIE data structure and search the given string.
static boolean search(TrieNode root, String key)
{
    // Your code here
    TrieNode temp=root;
    for(int i=0;i<key.length();i++){
        if(temp.children[key.charAt(i)-'a']==null)return false;
        temp=temp.children[key.charAt(i)-'a'];
        if(i==key.length()-1 && temp.isEndOfWord)return true;
    }
    return false;
}
