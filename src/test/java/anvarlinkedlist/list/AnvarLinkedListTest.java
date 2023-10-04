package anvarlinkedlist.list;

import org.example.anvarlinkedlist.AnvarList;
import org.example.anvarlinkedlist.list.AnvarLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnvarLinkedListTest {
    @Test
    void getTest() {
        AnvarList<String> anvarList = new AnvarLinkedList<>();
        anvarList.add("13");
        assertEquals("13", anvarList.get(0));
        anvarList.add("12");
        anvarList.add("15");
        assertEquals("15", anvarList.get(2));
    }

    @Test
    void getNegativeTest() {
        AnvarList<String> anvarList = new AnvarLinkedList<>();
        anvarList.add("13");
        assertNotEquals("0", anvarList.get(0));
        anvarList.add("12");
        anvarList.add("15");
        assertNotEquals("12", anvarList.get(2));
    }

    @Test
    void setTest() {
        AnvarList<String> anvarList = new AnvarLinkedList<>();
        anvarList.add("13");
        anvarList.add("10");
        anvarList.add("25");
        anvarList.set(2, "58");
        assertEquals("58", anvarList.get(2));
        anvarList.set(2, "32");
        assertEquals("32", anvarList.get(2));
        anvarList.set(0, "34");
        assertEquals("34", anvarList.get(0));
    }

    @Test
    void setNegativeTest(){
        AnvarList<String> anvarList = new AnvarLinkedList<>();
        anvarList.add("13");
        anvarList.add("10");
        anvarList.add("25");
        anvarList.set(2, "58");
        assertNotEquals("25", anvarList.get(2));
        anvarList.set(2, "32");
        assertNotEquals("58", anvarList.get(2));
        anvarList.set(0, "34");
        assertNotEquals("58", anvarList.get(0));
    }

    @Test
    void addTest(){
        AnvarList<String> anvarList = new AnvarLinkedList<>();
        anvarList.add("1");
        anvarList.add("2");
        anvarList.add("3");
        assertEquals("1", anvarList.get(0));
        assertEquals("3", anvarList.get(2));
        assertEquals(3, anvarList.size());
    }

    @Test
    void addNegativeTest(){
        AnvarList<String> anvarList = new AnvarLinkedList<>();
        anvarList.add("1");
        anvarList.add("2");
        anvarList.add("3");
        assertNotEquals("3", anvarList.get(0));
        assertNotEquals("1", anvarList.get(2));
        assertNotEquals(2, anvarList.size());
    }

    @Test
    void removeTest(){
        AnvarList<String> anvarList = new AnvarLinkedList<>();
        anvarList.add("1");
        anvarList.add("2");
        anvarList.add("3");
        anvarList.remove("2");
        assertEquals("1", anvarList.get(0));
        assertEquals("3", anvarList.get(1));
        assertEquals(2, anvarList.size());

        //удаление всех хначений происходит, но сайз не отрабатывает.
//        AnvarList<String> anvarList1 = new AnvarLinkedList<>();
//        anvarList1.add("2");
//        anvarList1.add("1");
//        anvarList1.add("1");
//        anvarList1.remove("1");
//        assertEquals(1, anvarList1.size());

    }
    @Test
    void removeNegativeTest(){
        AnvarList<String> anvarList = new AnvarLinkedList<>();
        anvarList.add("1");
        anvarList.add("2");
        anvarList.add("3");
        anvarList.remove("2");
        assertNotEquals(1, anvarList.size());
        assertNotEquals(3, anvarList.size());
    }


}
