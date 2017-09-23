// Trie
// this is only for lowercase - else we'll have to make the node array of size 256 to include uppercase and special chars

class Node{
	Node[] children = new Node[26];

	boolean isLeaf;
	// by default the children Nodes will be set to null and isLeaf = false
}

class Trie{
	Node root = new Node();

	public void insert(String key){
		key = key.toLowerCase();
		Node pCrawl = root;
		
		for(int i = 0; i < key.length(); i++){
			int idx = key.charAt(i) - 'a';
			
			if(pCrawl.children[idx] == null){
				pCrawl.children[idx] = new Node();
			}
			pCrawl = pCrawl.children[idx];
		}
		pCrawl.isLeaf = true;
	}

	// returns true if key present in trie
	public boolean search(String key){
		Node pCrawl = root;
        
		for(int i = 0; i < key.length(); i++){
			int idx = key.charAt(i) - 'a';
			if(pCrawl.children[idx] == null){
				return false;
			}
			pCrawl = pCrawl.children[idx];
		}
		return pCrawl.isLeaf;
	}



}

class Main{
	public static void main(String[] args){
		Trie trie = new Trie();

		String[] keys = {"the","a","there","answer","any","by","bye","their"};
		String[] output = {"not found in trie", "found"};
		
		
		String[] queries = {"the", "these", "their", "thaw", "by", "wrong"};

		for(String key: keys){
			trie.insert(key);
		}
		System.out.println(trie.root.children[19].children[7].children[4].children[8].children[17].isLeaf);

		for(String query: queries){
		    System.out.print(query + " : ");
			if(trie.search(query))
				System.out.println(output[1]);
			else
				System.out.println(output[0]);
		}
		// above code should give true false true false true false

		System.out.println();
		System.out.println("End of queries");

	}
}