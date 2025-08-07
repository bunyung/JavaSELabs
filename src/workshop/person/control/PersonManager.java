package workshop.person.control;

import workshop.person.entity.PersonEntity;

public class PersonManager {

    public PersonManager() {
    }

    public static void main(String[] args) {
        PersonManager pManager = new PersonManager();
        pManager.printTitle("Person Manager Program");
        pManager.printTitleLine();

        PersonEntity[] persons = new PersonEntity[10];
        pManager.fillPersons(persons);
        pManager.showPersons(persons);

        pManager.printTitle("\n[여성 인원 수]");
        int femaleCount = pManager.findByGender(persons, '여');
        System.out.println("여성 수: " + femaleCount);

        pManager.printTitle("\n[김하늘 상세 정보]");
        pManager.showPerson(persons, "김하늘");
    }

    public void fillPersons(PersonEntity[] persons) {
        persons[0] = new PersonEntity("이성호", "7212121028102", "인천 계양구", "032-392-2932");
        persons[1] = new PersonEntity("김하늘", "7302132363217", "서울 강동구", "02-362-1932");
        persons[2] = new PersonEntity("박영수", "7503111233201", "서울 성북구", "02-887-1542");
        persons[3] = new PersonEntity("나인수", "7312041038988", "대전 유성구", "032-384-2223");
        persons[4] = new PersonEntity("홍정수", "7606221021341", "서울 양천구", "02-158-7333");
        persons[5] = new PersonEntity("이미숙", "7502142021321", "서울 강서구", "02-323-1934");
        persons[6] = new PersonEntity("박성구", "7402061023101", "서울 종로구", "02-308-0932");
        persons[7] = new PersonEntity("유성미", "7103282025101", "서울 은평구", "02-452-0939");
        persons[8] = new PersonEntity("황재현", "7806231031101", "인천 중구", "032-327-2202");
        persons[9] = new PersonEntity("최철수", "7601211025101", "인천 계양구", "032-122-7832");
    }

    public void showPersons(PersonEntity[] persons) {
        printItemLine();
        System.out.printf("%-10s %-5s %-15s\n", "이름", "성별", "전화번호");
        printItemLine();
        for (PersonEntity p : persons) {
            System.out.printf("%-10s %-5s %-15s\n", p.getName(), p.getGender(), p.getPhone());
        }
    }

    public int findByGender(PersonEntity[] persons, char gender) {
        int count = 0;
        for (PersonEntity p : persons) {
            if (p.getGender().charAt(0) == gender) {
                count++;
            }
        }
        return count;
    }

    public void showPerson(PersonEntity[] persons, String name) {
        for (PersonEntity p : persons) {
            if (p.getName().equals(name)) {
                printItemLine();
                System.out.println("이름: " + p.getName());
                System.out.println("성별: " + p.getGender());
                System.out.println("전화번호: " + p.getPhone());
                System.out.println("주소: " + p.getAddress());
                return;
            }
        }
        System.out.println("해당 이름을 가진 사람을 찾을 수 없습니다.");
    }

    public void printTitle(String title) {
        System.out.println("\n" + title + "\n");
    }

    public void printTitleLine() {
        for (int i = 0; i < 60; i++) System.out.print("=");
        System.out.println();
    }

    public void printItemLine() {
        for (int i = 0; i < 60; i++) System.out.print("-");
        System.out.println();
    }
}
