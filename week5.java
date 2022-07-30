public class week5 {
    public static void checkSubset(String target, String[] set) {
        String visited = "";

        int ans = 0;

        for (int i = 0; i < target.length(); i++) {
            for (int j = 0; j < set.length; j++) {
                for (int k = 0; k < set[j].length(); k++) {
                    if (target.toUpperCase().charAt(i) == set[j].toUpperCase().charAt(k)
                            && !visited.contains(target.charAt(i) + "")) {
                        visited += target.charAt(i);

                        // System.out.println(target.charAt(i));
                        // System.out.println(set[j]);

                        if (ans <= j + 1) {
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println("-----");

        // for (int i = 0; i < subset.length; i++) {
        // System.out.println(subset[i]);
        // }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        String target = "frog";
        String[] set = { "programming", "For", "developers" };
        checkSubset(target, set);
    }
}
