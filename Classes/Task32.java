import java.util.Arrays;
import java.util.Comparator;

public class Task32 {
    public static void main(String[] args) {
        String[] arr = {"Alice", "Sue", "Janet", "Bea"};

        Arrays.sort(arr, StrCmp.ByLenAsc);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, StrCmp.ByLenDesc);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, StrCmp.ByLexAsc);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, StrCmp.ByLexDesc);
        System.out.println(Arrays.toString(arr));

    }
}

enum StrCmp implements Comparator<String> {
    ByLenAsc((s1, s2) -> s1.length() - s2.length()),
    ByLenDesc((s1, s2) -> s2.length() - s1.length()),
    ByLexAsc((s1, s2) -> s1.compareTo(s2)),
    ByLexDesc((s1, s2) -> s2.compareTo(s1));
    Comparator<String> cmp;

    StrCmp(Comparator<String> c) {
        cmp = c;
    }

    public int compare(String s1, String s2) {
        return cmp.compare(s1, s2);
    }
}
