package Probas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProbaNum {

    @Test
    public void test1() {
        assertEquals("Zero", ProbaNum.say(0));
        assertEquals("Un", ProbaNum.say(1));
        assertEquals("Set", ProbaNum.say(7));
        assertEquals("Vuit", ProbaNum.say(8));
        assertEquals("Dinou", ProbaNum.say(19));
        assertEquals("Menys quatre", ProbaNum.say(-4));
    }


    @Test
    public void test2() {
        assertEquals("Quaranta-quatre", ProbaNum.say(44));
        assertEquals("Cinquanta-sis", ProbaNum.say(56));
        assertEquals("Trenta", ProbaNum.say(30));
        assertEquals("Noranta-nou", ProbaNum.say(99));
        assertEquals("Vint", ProbaNum.say(20));
        assertEquals("Vint-i-un", ProbaNum.say(21));
        assertEquals("Vint-i-set", ProbaNum.say(27));
        assertEquals("Menys seixanta-vuit", ProbaNum.say(-68));
    }

    @Test
    public void test3() {
        assertEquals("Cent vint-i-cinc", ProbaNum.say(125));
        assertEquals("Dos-cents tres", ProbaNum.say(203));
        assertEquals("Quatre-cents catorze", ProbaNum.say(414));
        assertEquals("Nou-cents noranta-nou", ProbaNum.say(999));
        assertEquals("Cinc-cents", ProbaNum.say(500));
        assertEquals("Menys cinc-cents", ProbaNum.say(-500)); //Afegim test per nombres negatius.
        assertEquals("Menys quatre-cents catorze", ProbaNum.say(-414));
        assertEquals("Tres-cents trenta", ProbaNum.say(330));
        assertEquals("Cent vint", ProbaNum.say(120));


    }

    @Test
    public void test4() {
        assertEquals("Mil un", ProbaNum.say(1001));
        assertEquals("Mil", ProbaNum.say(1000));
        assertEquals("Mil vint", ProbaNum.say(1020)); //test propis
        assertEquals("Mil trenta", ProbaNum.say(1030));//test propis
        assertEquals("Mil quaranta", ProbaNum.say(1040));//test propis.
        assertEquals("Mil cent quaranta", ProbaNum.say(1140));//test propis.
        assertEquals("Mil cinc-cents", ProbaNum.say(1500));//test propis.
        assertEquals("Dos mil", ProbaNum.say(2000));
        assertEquals("Dos mil vint", ProbaNum.say(2020)); //test propis
        assertEquals("Tres mil trenta", ProbaNum.say(3030));//test propis
        assertEquals("Tres mil cent trenta", ProbaNum.say(3130));//test propis
        assertEquals("Dinou mil quaranta", ProbaNum.say(19040));//test propis.
        assertEquals("Deu mil vint-i-cinc", ProbaNum.say(10025));//test propis.
        assertEquals("Tres mil quatre-cents cinquanta-sis", ProbaNum.say(3456));
        assertEquals("Quaranta-tres mil vint", ProbaNum.say(43_020));//test propis.
        assertEquals("Quaranta-tres mil vint-i-nou", ProbaNum.say(43_029));//test propis.
        assertEquals("Trenta mil cinc-cents quaranta-tres", ProbaNum.say(30_543));
        assertEquals("Cent mil", ProbaNum.say(100_000));
        assertEquals("Cinc-cents quaranta-tres mil", ProbaNum.say(543_000));//test propis.
        assertEquals("Nou-cents noranta-vuit mil vuit-cents vuitanta-nou", ProbaNum.say(998_889));
    }

    @Test
    public void test5() {
        assertEquals("Un milió dos-cents trenta-quatre mil cinc-cents seixanta-set",
                ProbaNum.say(1_234_567));
        assertEquals("Vint-i-dos milions cinc-cents quaranta-tres mil",
                ProbaNum.say(22_543_000));
        assertEquals("Nou-cents un milions set",
                ProbaNum.say(901_000_007));
        assertEquals("Nou-cents nou milions nou-cents noranta-nou mil nou-cents noranta-nou",
                ProbaNum.say(909_999_999));
        assertEquals("Mil milions",
                ProbaNum.say(1_000_000_000));
        assertEquals("Quinze mil vint milions noranta-vuit mil cinc-cents quaranta-vuit",
                ProbaNum.say(15_020_098_548L));
        assertEquals("Nou-cents noranta-nou mil milions cinc mil tres-cents noranta-dos",
                ProbaNum.say(999_000_005_392L));
    }

    @Test
    public void test6() {
        assertEquals("Un bilió",
                ProbaNum.say(1_000_000_000_000L));
        assertEquals("Mil bilions",
                ProbaNum.say(1_000_000_000_000_000L));
        assertEquals("Cent seixanta-cinc mil quaranta-tres bilions dos-cents disset mil nou-cents vuitanta-set milions cinquanta mil cent sis",
                ProbaNum.say(165_043_217_987_050_106L));
        assertEquals("Nou mil onze bilions sis-cents cinquanta-tres milions vint mil vuit",
                ProbaNum.say(9_011_000_653_020_008L));
        assertEquals("Nou-cents noranta-nou mil bilions",
                ProbaNum.say(999_000_000_000_000_000L));
    }

    @Test
    public void test7() {
        assertEquals("Un trilió",
                ProbaNum.say(1_000_000_000_000_000_000L));
        assertEquals("Nou trilions dos-cents vint-i-tres mil tres-cents setanta-dos bilions trenta-sis mil vuit-cents cinquanta-quatre milions set-cents setanta-cinc mil vuit-cents set",
                ProbaNum.say(9_223_372_036_854_775_807L));
    }

    @Test
    public void revTest1() {
        assertEquals(-2, ProbaNum.words("Menys dos"));
        assertEquals(0, ProbaNum.words("Zero"));
        assertEquals(10, ProbaNum.words("Deu"));
        assertEquals(19, ProbaNum.words("Dinou"));
        assertEquals(6, ProbaNum.words("Sis"));

    }

    @Test
    public void revTest2() {
        assertEquals(66, ProbaNum.words("Seixanta-sis"));
        assertEquals(40, ProbaNum.words("Quaranta"));
        assertEquals(72, ProbaNum.words("Setanta-dos"));
        assertEquals(29, ProbaNum.words("Vint-i-nou"));
        assertEquals(20, ProbaNum.words("Vint"));
        assertEquals(99, ProbaNum.words("Noranta-nou"));
        assertEquals(-61, ProbaNum.words("Menys seixanta-un"));
    }

    @Test
    public void revTest3() {
        assertEquals(211, ProbaNum.words("Dos-cents onze"));
        assertEquals(100, ProbaNum.words("Cent"));
        assertEquals(967, ProbaNum.words("Nou-cents seixanta-set"));
    }

    @Test
    public void revTest4() {
        assertEquals(1001, ProbaNum.words("Mil un"));
        assertEquals(2022, ProbaNum.words("Dos mil vint-i-dos"));
        assertEquals(99457, ProbaNum.words("Noranta-nou mil quatre-cents cinquanta-set"));
        assertEquals(100_000, ProbaNum.words("Cent mil"));
        assertEquals(543_432, ProbaNum.words("Cinc-cents quaranta-tres mil quatre-cents trenta-dos"));
    }

    @Test
    public void revTest5() {
        assertEquals(1_000_000, ProbaNum.words("Un milió"));
        assertEquals(432_000_432, ProbaNum.words("Quatre-cents trenta-dos milions quatre-cents trenta-dos"));
        assertEquals(76_021_022, ProbaNum.words("Setanta-sis milions vint-i-un mil vint-i-dos"));
        assertEquals(6_000_001, ProbaNum.words("Sis milions un"));
        assertEquals(999_999_991, ProbaNum.words("Nou-cents noranta-nou milions nou-cents noranta-nou mil nou-cents noranta-un"));
        assertEquals(1_000_000_000, ProbaNum.words("Mil milions"));
        assertEquals(889_054_543_982L, ProbaNum.words("Vuit-cents vuitanta-nou mil cinquanta-quatre milions cinc-cents quaranta-tres mil nou-cents vuitanta-dos"));
    }

    @Test
    public void revTest6() {
        assertEquals(1_000_000_000_000L, ProbaNum.words("Un bilió"));
        assertEquals(8_888_999_222_111L, ProbaNum.words("Vuit bilions vuit-cents vuitanta-vuit mil nou-cents noranta-nou milions dos-cents vint-i-dos mil cent onze"));
        assertEquals(123_456_789_234_567L, ProbaNum.words("Cent vint-i-tres bilions quatre-cents cinquanta-sis mil set-cents vuitanta-nou milions dos-cents trenta-quatre mil cinc-cents seixanta-set"));
        assertEquals(3_765_200_000_212_007L, ProbaNum.words("Tres mil set-cents seixanta-cinc bilions dos-cents mil milions dos-cents dotze mil set"));
    }

    @org.junit.Test
    public void revTest7() {
        assertEquals(1_000_000_000_000_000_000L, ProbaNum.words("Un trilió"));
        assertEquals(9_223_372_036_854_775_807L,
                ProbaNum.words("Nou trilions dos-cents vint-i-tres mil tres-cents setanta-dos bilions trenta-sis mil vuit-cents cinquanta-quatre milions set-cents setanta-cinc mil vuit-cents set"));
    }

    @Test
    public void oper1() {
        assertEquals("Dos", ProbaNum.oper("Un més un"));
        assertEquals("Vint-i-tres", ProbaNum.oper("Cinc més divuit"));
        assertEquals("Quaranta-dos", ProbaNum.oper("Cinquanta-dos menys deu"));
        assertEquals("Cinquanta-quatre", ProbaNum.oper("Sis per nou"));
        assertEquals("Nou", ProbaNum.oper("Divuit dividit dos"));
        assertEquals("Vuit", ProbaNum.oper("Disset dividit dos"));
        assertEquals("Set-cents vint-i-dos mil quatre-cents quaranta-dos",
                ProbaNum.oper("Set-cents vint-i-un per mil dos"));
        assertEquals("Setanta-sis milions cinc-cents seixanta-quatre mil quatre-cents cinquanta-quatre",
                ProbaNum.oper("Cinc-cents quaranta-tres mil quatre-cents trenta-dos més Setanta-sis milions vint-i-un mil vint-i-dos"));
    }

    @Test
    public void oper2() {
        assertEquals("Cinc", ProbaNum.oper("Un més un més tres"));
        assertEquals("Vint-i-dos", ProbaNum.oper("Un més un més dos més tres més quatre més cinc més sis"));
        assertEquals("Nou", ProbaNum.oper("Dos més vuit menys un"));
        assertEquals("Quinze", ProbaNum.oper("Set més quatre per dos"));
        assertEquals("Vint-i-cinc", ProbaNum.oper("Nou per dos més quinze dividit dos"));
        assertEquals("Quaranta-quatre mil tres-cents noranta-un milions quatre-cents dotze mil cent trenta",
                ProbaNum.oper("Set-cents setanta-cinc mil vuit-cents set per Cinquanta-set mil dos-cents vint-i-un més Quatre-cents trenta-dos dividit cinc menys Un milió quaranta mil tres-cents tres"));
        assertEquals("Quaranta-sis",
                ProbaNum.oper("Setze per quatre menys deu per dos més vuit dividit tres"));

    }

    @Test
    public void oper3() {
        assertEquals("Cinc", ProbaNum.oper("Set menys quatre més dos"));
        assertEquals("Menys tres", ProbaNum.oper("Tres menys tres menys tres menys tres més tres"));
        assertEquals("Menys tretze", ProbaNum.oper("Menys set menys sis"));
        assertEquals("Menys setanta-dos", ProbaNum.oper("Menys divuit per quatre"));
        assertEquals("Menys sis", ProbaNum.oper("Menys quaranta dividit sis"));
        assertEquals("Sis", ProbaNum.oper("Menys quaranta dividit menys sis"));
    }
}
