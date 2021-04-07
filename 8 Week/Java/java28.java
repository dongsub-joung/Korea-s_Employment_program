public class java28 {
    public static void main(String[] args) {
//        スレッドセーフな可変の文字列。
//        内部バッファがオーバーフローする場合、自動的に容量が増加します。
        StringBuffer html= new StringBuffer();
        html.append("<ul>\n");
        html.append("<li>중식</li>\n");
        html.append("<li>한식</li\n");
        html.append("<ul>\n");

//        넣을 위치 검색
        int li_index= html.lastIndexOf("<li>");
        html.insert(li_index, "<li>양식</li>\n");
//        html.reverse();
//        html.toString();
//        html.ensureCapacity(100);
        html.capacity();
        System.out.println(html.capacity());
    }
}