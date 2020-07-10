class Solution {
	public List<String> letterCombinations(String digits) {

		List<String> answer = new ArrayList<>();
		if (digits.equals("")) {
			return answer;
		}

		Map<Character, char[]> map = new HashMap<>();
		map.put('2', new char[] { 'a', 'b', 'c' });
		map.put('3', new char[] { 'd', 'e', 'f' });
		map.put('4', new char[] { 'g', 'h', 'i' });
		map.put('5', new char[] { 'j', 'k', 'l' });
		map.put('6', new char[] { 'm', 'n', 'o' });
		map.put('7', new char[] { 'p', 'q', 'r', 's' });
		map.put('8', new char[] { 't', 'u', 'v' });
		map.put('9', new char[] { 'w', 'x', 'y', 'z' });

		char[] params = digits.toCharArray();
		for (char param : params) {
			if (!map.containsKey(param)) {
				return answer;
			}
		}

		for (int i = 0; i < params.length; i++) {
			char[] target = map.get(params[i]);
			List<String> temp = new ArrayList<>();

			for (char a : target) {
				if (i == 0)
					temp.add(String.valueOf(a));
				for (String s : answer) {
					temp.add(s + String.valueOf(a));
				}
			}

			answer.clear();
			answer.addAll(temp);
		}

		return answer;
	}
}

