package DataStrucutre;

public class HashTable {
	NodeHash[] hashArray;
	int arraySize;
	int size = 0;

	public int getSize() {
		return arraySize;
	}

	public HashTable(int size) {
		if (isPrime(size)) {
			hashArray = new NodeHash[size];
			arraySize = size;
		} else {
			int prime = getPrimeNumber(size);
			hashArray = new NodeHash[prime];
			arraySize = prime;
		}
		for (int i = 0; i < arraySize; i++) {
			hashArray[i] = new NodeHash();
		}
	}

	private int getPrimeNumber(int x) {
		int i = x;

		while (!isPrime(i)) {
			i++;
		}
		return i;

	}

	private boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private int hashWord(String str) {
		int hashValue = 0, i = 0;
		while (i != str.length()) {
			hashValue = (hashValue << 5) + str.charAt(i++);
		}
		return hashValue % arraySize;
	}

	private int hashFunc(String str) {
		int hashValue = hashWord(str);
		if (hashValue < 0) {
			hashValue += arraySize;
		}
		return hashValue % arraySize;
	}

	private int hashFuncTwo(String str) {
		int hashValue = hashWord(str);
		if (hashValue < 0) {
			hashValue += arraySize;
		}
		return 7 - (hashValue % 7);
	}

	public void insert(Student std) {
		int hashValue = hashFunc(std.getName());
		int stepSize = hashFuncTwo(std.getName());
		if (size > arraySize / 2) {
			ReHash();

		}

		while (hashArray[hashValue] != null) { // not equal null . this mean exist collision
			if (hashArray[hashValue].status == 2 || hashArray[hashValue].status == 0) {
				hashArray[hashValue].data = std;
				hashArray[hashValue].status = 1;
				size++;

				return;
			}
			hashValue = (hashValue + stepSize) % arraySize;
		}
		hashArray[hashValue].data = std;
		hashArray[hashValue].status = 1;

		size++;

	}

	public Student serach(String str) {
		int hashValue = hashFunc(str);
		int stepSize = hashFuncTwo(str);
		while (hashArray[hashValue] != null && hashArray[hashValue].status == 1) {
			if (hashArray[hashValue].data != null && hashArray[hashValue].data.getName().equals(str)) {
				return hashArray[hashValue].data;
			}
			hashValue = (hashValue + stepSize) % arraySize;

		}
		return null;
	}

	public boolean remove(String str) {
		int hashValue = hashFunc(str);
		int stepSize = hashFuncTwo(str);
		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].data != null && hashArray[hashValue].data.getName().equals(str)) {
				hashArray[hashValue].status = 2;
				size--;

				return true;
			}
			hashValue = (hashValue + stepSize) % arraySize;

		}
		return false;
	}

	public void ReHash() {

		int newSize = getPrimeNumber(2 * hashArray.length);
		HashTable newHash = new HashTable(newSize);

		for (int i = 0; i < arraySize; i++) {
			if (hashArray[i] != null && hashArray[i].status == 1) {
				newHash.insert(hashArray[i].data);
			}
		}
		hashArray = newHash.hashArray;
		arraySize = newHash.arraySize;
		size = newHash.size;

	}

	public String printHashTable() {
		String str = "";
		for (int i = 0; i < arraySize; i++) {
			if (hashArray[i].status == 1) {
				str += hashArray[i].data.toString();
				str += "\n############################################################################\n";

			}
		}
		return str;
	}

	public String TOSTRING() {
		String str = "";
		for (int i = 0; i < arraySize; i++) {
			if (hashArray[i].status == 1) {
				str += hashArray[i].data.toString() + "\n";

			}
		}
		return str;
	}

	public String SaveToFile() {
		String str = "";
		for (int i = 0; i < arraySize; i++) {
			if (hashArray[i].status == 1) {
				str += hashArray[i].data.toString() + "\n";

			}
		}
		return str;
	}

	public String printAllHashTable() {
		String str = "";
		for (int i = 0; i < arraySize; i++) {
			str += "\n Location in Array : " + i;
			if (hashArray[i] == null || hashArray[i].data == null) {
				str += "\n Value  : Null ";
				str += "\n Status = 0";

			} else {
				str += "\n Value  :  " + hashArray[i].data.toString();

				str += "\n Status : " + hashArray[i].status;
			}

			str += "\n############################################################################\n";
		}
		return str;
	}

}
