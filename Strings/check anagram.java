// check if two strings are anagrams (contain same letters but possibly in different order)

class Main{
	public static void main(String[] args){
		String a = "Trying";
		String b = "irygTn";

		String c = "hello";
		String d = "helloo";

		String e = "fellow";
		String f = "Fellow";

		System.out.println(isAnagram(a, b));
		System.out.println(isAnagram(c, d));
		System.out.println(isAnagram(e, f));
	}

	static booelan isAnagram(String a, String b){
		int[] count = new int[256];

		if(a.length() != b.length())
			return false;

		// maintain only one array for counting: inc char indices of one string, dec the other: if all elements are 0 -> anagram
		for(int i = 0; i < a.length(); i++){
			count[(int)a.charAt(i)]++;
			count[(int)b.charAt(i)]--;
		}

		for(int i = 0; i < count.length; i++){
			if(count[i] != 0){
				return false;
			}
		}
		return true;


	}
}