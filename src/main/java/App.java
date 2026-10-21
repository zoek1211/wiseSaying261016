import java.util.Scanner;

// refactor
// main 에 로직 구현 안함
// Static 안씀
public class App {
    Scanner sc = new Scanner(System.in);

    int lastId = 0;

    WiseSaying[] wiseSayings = new WiseSaying[100];
    int wiseSayingsLastIndex = -1;

    // run app 진입점 시작
    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();

            } else if (cmd.equals("목록")) {  //목록 출력
                actionlist();
            }
        }

        sc.close(); // 진입점 끝
    }

    // 명언 입력받음
    private void actionWrite() {
        System.out.print("명언: ");
        String content = sc.nextLine().trim();

        System.out.print("작가: ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = write(content, author);

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.id);
    }

    // 내부처리 write
    WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.id = ++lastId;
        wiseSaying.content = content;
        wiseSaying.author = author;

        wiseSayings[++wiseSayingsLastIndex] = wiseSaying;
        return wiseSaying;
    }

    // 명언 목록 출력
    void actionlist() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------");

        WiseSaying [] forListWiseSayings = findForList();

        for (WiseSaying wiseSaying : forListWiseSayings) {
            System.out.printf("%d / %s / %s\n",
                    wiseSaying.id, wiseSaying.author, wiseSaying.content);
        }
    }

    // 현재 명언 몇개
    int getSize() {
        return wiseSayingsLastIndex + 1;
    }

    WiseSaying[] findForList() {
        WiseSaying[] forListWiseSayings = new WiseSaying[getSize()];

        int forListWiseSayingIndex = -1;

        for (int i = wiseSayingsLastIndex; i >= 0; i--) {
            forListWiseSayings[++forListWiseSayingIndex] = wiseSayings[i];
        }

        return forListWiseSayings;
    }






}
