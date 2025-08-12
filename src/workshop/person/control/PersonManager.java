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

        pManager.printTitle("\n[���� �ο� ��]");
        int femaleCount = pManager.findByGender(persons, '��');
        System.out.println("���� ��: " + femaleCount);

        pManager.printTitle("\n[���ϴ� �� ����]");
        pManager.showPerson(persons, "���ϴ�");
    }

    public void fillPersons(PersonEntity[] persons) {
        persons[0] = new PersonEntity("�̼�ȣ", "7212121028102", "��õ ��籸", "032-392-2932");
        persons[1] = new PersonEntity("���ϴ�", "7302132363217", "���� ������", "02-362-1932");
        persons[2] = new PersonEntity("�ڿ���", "7503111233201", "���� ���ϱ�", "02-887-1542");
        persons[3] = new PersonEntity("���μ�", "7312041038988", "���� ������", "032-384-2223");
        persons[4] = new PersonEntity("ȫ����", "7606221021341", "���� ��õ��", "02-158-7333");
        persons[5] = new PersonEntity("�̹̼�", "7502142021321", "���� ������", "02-323-1934");
        persons[6] = new PersonEntity("�ڼ���", "7402061023101", "���� ���α�", "02-308-0932");
        persons[7] = new PersonEntity("������", "7103282025101", "���� ����", "02-452-0939");
        persons[8] = new PersonEntity("Ȳ����", "7806231031101", "��õ �߱�", "032-327-2202");
        persons[9] = new PersonEntity("��ö��", "7601211025101", "��õ ��籸", "032-122-7832");
    }

    public void showPersons(PersonEntity[] persons) {
        printItemLine();
        System.out.printf("%-10s %-5s %-15s\n", "�̸�", "����", "��ȭ��ȣ");
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
                System.out.println("�̸�: " + p.getName());
                System.out.println("����: " + p.getGender());
                System.out.println("��ȭ��ȣ: " + p.getPhone());
                System.out.println("�ּ�: " + p.getAddress());
                return;
            }
        }
        System.out.println("�ش� �̸��� ���� ����� ã�� �� �����ϴ�.");
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
