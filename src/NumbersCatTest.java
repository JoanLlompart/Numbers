import static org.junit.Assert.assertEquals;

public class NumbersCatTest {
    @org.junit.Test
    public void test1() {
        assertEquals("Zero", NumbersCat.say(0));
        assertEquals("Un", NumbersCat.say(1));
        assertEquals("Set", NumbersCat.say(7));
        assertEquals("Vuit", NumbersCat.say(8));
        assertEquals("Dinou", NumbersCat.say(19));
        assertEquals("Menys quatre", NumbersCat.say(-4));
    }

    @org.junit.Test
    public void test2() {
        assertEquals("Quaranta-quatre", NumbersCat.say(44));
        assertEquals("Cinquanta-sis", NumbersCat.say(56));
        assertEquals("Trenta", NumbersCat.say(30));
        assertEquals("Noranta-nou", NumbersCat.say(99));
        assertEquals("Vint", NumbersCat.say(20));
        assertEquals("Vint-i-set", NumbersCat.say(27));
        assertEquals("Menys seixanta-vuit", NumbersCat.say(-68));
    }

    @org.junit.Test
    public void test3() {
        assertEquals("Cent vint-i-cinc", NumbersCat.say(125));
        assertEquals("Dos-cents tres", NumbersCat.say(203));
        assertEquals("Quatre-cents catorze", NumbersCat.say(414));
        assertEquals("Nou-cents noranta-nou", NumbersCat.say(999));
        assertEquals("Cinc-cents", NumbersCat.say(500));
    }

    @org.junit.Test
    public void test4() {
        assertEquals("Mil un", NumbersCat.say(1001));
        assertEquals("Mil", NumbersCat.say(1000));
        assertEquals("Dos mil", NumbersCat.say(2000));
        assertEquals("Tres mil quatre-cents cinquanta-sis", NumbersCat.say(3456));
        assertEquals("Trenta mil cinc-cents quaranta-tres", NumbersCat.say(30_543));
        assertEquals("Cent mil", NumbersCat.say(100_000));
        assertEquals("Nou-cents noranta-vuit mil vuit-cents vuitanta-nou", NumbersCat.say(998_889));
    }

    @org.junit.Test
    public void test5() {
        assertEquals("Un milió dos-cents trenta-quatre mil cinc-cents seixanta-set",
                NumbersCat.say(1_234_567));
        assertEquals("Vint-i-dos milions cinc-cents quaranta-tres mil",
                NumbersCat.say(22_543_000));
        assertEquals("Nou-cents un milions set",
                NumbersCat.say(901_000_007));
        assertEquals("Nou-cents nou milions nou-cents noranta-nou mil nou-cents noranta-nou",
                NumbersCat.say(909_999_999));
        assertEquals("Mil milions",
                NumbersCat.say(1_000_000_000));
        assertEquals("Quinze mil vint milions noranta-vuit mil cinc-cents quaranta-vuit",
                NumbersCat.say(15_020_098_548L));
        assertEquals("Nou-cents noranta-nou mil milions cinc mil tres-cents noranta-dos",
                NumbersCat.say(999_000_005_392L));
    }

    @org.junit.Test
    public void test6() {
        assertEquals("Un bilió",
                NumbersCat.say(1_000_000_000_000L));
        assertEquals("Mil bilions",
                NumbersCat.say(1_000_000_000_000_000L));
        assertEquals("Cent seixanta-cinc mil quaranta-tres bilions dos-cents disset mil nou-cents vuitanta-set milions cinquanta mil cent sis",
                NumbersCat.say(165_043_217_987_050_106L));
        assertEquals("Nou mil onze bilions sis-cents cinquanta-tres milions vint mil vuit",
                NumbersCat.say(9_011_000_653_020_008L));
        assertEquals("Nou-cents noranta-nou mil bilions",
                NumbersCat.say(999_000_000_000_000_000L));
    }

    @org.junit.Test
    public void test7() {
        assertEquals("Un trilió",
                NumbersCat.say(1_000_000_000_000_000_000L));
        assertEquals("Nou trilions dos-cents vint-i-tres mil tres-cents setanta-dos bilions trenta-sis mil vuit-cents cinquanta-quatre milions set-cents setanta-cinc mil vuit-cents set",
                NumbersCat.say(9_223_372_036_854_775_807L));
    }

    @org.junit.Test
    public void revTest1() {
        assertEquals(0, NumbersCat.words("Zero"));
        assertEquals(10, NumbersCat.words("Deu"));
        assertEquals(19, NumbersCat.words("Dinou"));
        assertEquals(6, NumbersCat.words("Sis"));
        assertEquals(-2, NumbersCat.words("Menys dos"));
    }

    @org.junit.Test
    public void revTest2() {
        assertEquals(66, NumbersCat.words("Seixanta-sis"));
        assertEquals(40, NumbersCat.words("Quaranta"));
        assertEquals(72, NumbersCat.words("Setanta-dos"));
        assertEquals(29, NumbersCat.words("Vint-i-nou"));
        assertEquals(20, NumbersCat.words("Vint"));
        assertEquals(99, NumbersCat.words("Noranta-nou"));
        assertEquals(-61, NumbersCat.words("Menys seixanta-un"));
    }

    @org.junit.Test
    public void revTest3() {
        assertEquals(211, NumbersCat.words("Dos-cents onze"));
        assertEquals(100, NumbersCat.words("Cent"));
        assertEquals(967, NumbersCat.words("Nou-cents seixanta-set"));
    }

    @org.junit.Test
    public void revTest4() {
        assertEquals(1001, NumbersCat.words("Mil un"));
        assertEquals(2022, NumbersCat.words("Dos mil vint-i-dos"));
        assertEquals(99457, NumbersCat.words("Noranta-nou mil quatre-cents cinquanta-set"));
        assertEquals(100_000, NumbersCat.words("Cent mil"));
        assertEquals(543_432, NumbersCat.words("Cinc-cents quaranta-tres mil quatre-cents trenta-dos"));
    }

    @org.junit.Test
    public void revTest5() {
        assertEquals(1_000_000, NumbersCat.words("Un milió"));
        assertEquals(432_000_432, NumbersCat.words("Quatre-cents trenta-dos milions quatre-cents trenta-dos"));
        assertEquals(76_021_022, NumbersCat.words("Setanta-sis milions vint-i-un mil vint-i-dos"));
        assertEquals(6_000_001, NumbersCat.words("Sis milions un"));
        assertEquals(999_999_991, NumbersCat.words("Nou-cents noranta-nou milions nou-cents noranta-nou mil nou-cents noranta-un"));
        assertEquals(1_000_000_000, NumbersCat.words("Mil milions"));
        assertEquals(889_054_543_982L, NumbersCat.words("Vuit-cents vuitanta-nou mil cinquanta-quatre milions cinc-cents quaranta-tres mil nou-cents vuitanta-dos"));
    }

    @org.junit.Test
    public void revTest6() {
        assertEquals(1_000_000_000_000L, NumbersCat.words("Un bilió"));
        assertEquals(8_888_999_222_111L, NumbersCat.words("Vuit bilions vuit-cents vuitanta-vuit mil nou-cents noranta-nou milions dos-cents vint-i-dos mil cent onze"));
        assertEquals(123_456_789_234_567L, NumbersCat.words("Cent vint-i-tres bilions quatre-cents cinquanta-sis mil set-cents vuitanta-nou milions dos-cents trenta-quatre mil cinc-cents seixanta-set"));
        assertEquals(3_765_200_000_212_007L, NumbersCat.words("Tres mil set-cents seixanta-cinc bilions dos-cents mil milions dos-cents dotze mil set"));
    }

    @org.junit.Test
    public void revTest7() {
        assertEquals(1_000_000_000_000_000_000L, NumbersCat.words("Un trilió"));
        assertEquals(9_223_372_036_854_775_807L,
                NumbersCat.words("Nou trilions dos-cents vint-i-tres mil tres-cents setanta-dos bilions trenta-sis mil vuit-cents cinquanta-quatre milions set-cents setanta-cinc mil vuit-cents set"));
    }

    @org.junit.Test
    public void oper1() {
        assertEquals("Dos", NumbersCat.oper("Un més un"));
        assertEquals("Vint-i-tres", NumbersCat.oper("Cinc més divuit"));
        assertEquals("Quaranta-dos", NumbersCat.oper("Cinquanta-dos menys deu"));
        assertEquals("Cinquanta-quatre", NumbersCat.oper("Sis per nou"));
        assertEquals("Nou", NumbersCat.oper("Divuit dividit dos"));
        assertEquals("Vuit", NumbersCat.oper("Disset dividit dos"));
        assertEquals("Set-cents vint-i-dos mil quatre-cents quaranta-dos",
                NumbersCat.oper("Set-cents vint-i-un per mil dos"));
        assertEquals("Setanta-sis milions cinc-cents seixanta-quatre mil quatre-cents cinquanta-quatre",
                NumbersCat.oper("Cinc-cents quaranta-tres mil quatre-cents trenta-dos més Setanta-sis milions vint-i-un mil vint-i-dos"));
    }

    @org.junit.Test
    public void oper2() {
        assertEquals("Cinc", NumbersCat.oper("Un més un més tres"));
        assertEquals("Vint-i-dos", NumbersCat.oper("Un més un més dos més tres més quatre més cinc més sis"));
        assertEquals("Nou", NumbersCat.oper("Dos més vuit menys un"));
        assertEquals("Quinze", NumbersCat.oper("Set més quatre per dos"));
        assertEquals("Vint-i-cinc", NumbersCat.oper("Nou per dos més quinze dividit dos"));
        assertEquals("Quaranta-quatre mil tres-cents noranta-un milions quatre-cents dotze mil cent trenta",
                NumbersCat.oper("Set-cents setanta-cinc mil vuit-cents set per Cinquanta-set mil dos-cents vint-i-un més Quatre-cents trenta-dos dividit cinc menys Un milió quaranta mil tres-cents tres"));
        assertEquals("Quaranta-sis",
                NumbersCat.oper("Setze per quatre menys deu per dos més vuit dividit tres"));

    }

    @org.junit.Test
    public void oper3() {
        assertEquals("Cinc", NumbersCat.oper("Set menys quatre més dos"));
        assertEquals("Menys tres", NumbersCat.oper("Tres menys tres menys tres menys tres més tres"));
        assertEquals("Menys tretze", NumbersCat.oper("Menys set menys sis"));
        assertEquals("Menys setanta-dos", NumbersCat.oper("Menys divuit per quatre"));
        assertEquals("Menys sis", NumbersCat.oper("Menys quaranta dividit sis"));
        assertEquals("Sis", NumbersCat.oper("Menys quaranta dividit menys sis"));
    }
}