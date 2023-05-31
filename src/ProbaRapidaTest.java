import static org.junit.Assert.assertEquals;

public class ProbaRapidaTest {
        @org.junit.Test
        public void test1() {
            assertEquals("Zero", ProbaRapida.say(0));
            assertEquals("Un", ProbaRapida.say(1));
            assertEquals("Set", ProbaRapida.say(7));
            assertEquals("Vuit", ProbaRapida.say(8));
            assertEquals("Dinou", ProbaRapida.say(19));
            assertEquals("Menys quatre", ProbaRapida.say(-4));
        }


        @org.junit.Test
        public void test2() {
            assertEquals("Quaranta-quatre", ProbaRapida.say(44));
            assertEquals("Cinquanta-sis", ProbaRapida.say(56));
            assertEquals("Trenta", ProbaRapida.say(30));
            assertEquals("Noranta-nou", ProbaRapida.say(99));
            assertEquals("Vint", ProbaRapida.say(20));
            assertEquals("Vint-i-un", ProbaRapida.say(21));
            assertEquals("Vint-i-set", ProbaRapida.say(27));
            assertEquals("Menys seixanta-vuit", ProbaRapida.say(-68));
        }

        @org.junit.Test
        public void test3() {
            assertEquals("Cent vint-i-cinc", ProbaRapida.say(125));
            assertEquals("Dos-cents tres", ProbaRapida.say(203));
            assertEquals("Quatre-cents catorze", ProbaRapida.say(414));
            assertEquals("Nou-cents noranta-nou", ProbaRapida.say(999));
            assertEquals("Cinc-cents", ProbaRapida.say(500));
            assertEquals("Menys cinc-cents", ProbaRapida.say(-500)); //Afegim test per nombres negatius.
            assertEquals("Menys quatre-cents catorze", ProbaRapida.say(-414));
            assertEquals("Tres-cents trenta", ProbaRapida.say(330));
            assertEquals("Cent vint", ProbaRapida.say(120));


        }

        @org.junit.Test
        public void test4() {
            assertEquals("Mil un", ProbaRapida.say(1001));
            assertEquals("Mil", ProbaRapida.say(1000));
            assertEquals("Mil vint", ProbaRapida.say(1020)); //test propis
            assertEquals("Mil trenta", ProbaRapida.say(1030));//test propis
            assertEquals("Mil quaranta", ProbaRapida.say(1040));//test propis.
            assertEquals("Mil cent quaranta", ProbaRapida.say(1140));//test propis.
            assertEquals("Mil cinc-cents", ProbaRapida.say(1500));//test propis.
            assertEquals("Dos mil", ProbaRapida.say(2000));
            assertEquals("Dos mil vint", ProbaRapida.say(2020)); //test propis
            assertEquals("Tres mil trenta", ProbaRapida.say(3030));//test propis
            assertEquals("Tres mil cent trenta", ProbaRapida.say(3130));//test propis
            assertEquals("Dinou mil quaranta", ProbaRapida.say(19040));//test propis.
            assertEquals("Deu mil vint-i-cinc", ProbaRapida.say(10025));//test propis.
            assertEquals("Tres mil quatre-cents cinquanta-sis", ProbaRapida.say(3456));
            assertEquals("Quaranta-tres mil vint", ProbaRapida.say(43_020));//test propis.
            assertEquals("Quaranta-tres mil vint-i-nou", ProbaRapida.say(43_029));//test propis.
            assertEquals("Trenta mil cinc-cents quaranta-tres", ProbaRapida.say(30_543));
            assertEquals("Cent mil", ProbaRapida.say(100_000));
            assertEquals("Cinc-cents quaranta-tres mil", ProbaRapida.say(543_000));//test propis.
            assertEquals("Nou-cents noranta-vuit mil vuit-cents vuitanta-nou", ProbaRapida.say(998_889));
        }

        @org.junit.Test
        public void test5() {
            assertEquals("Un milió dos-cents trenta-quatre mil cinc-cents seixanta-set",
                    ProbaRapida.say(1_234_567));
            assertEquals("Vint-i-dos milions cinc-cents quaranta-tres mil",
                    ProbaRapida.say(22_543_000));
            assertEquals("Nou-cents un milions set",
                    ProbaRapida.say(901_000_007));
            assertEquals("Nou-cents nou milions nou-cents noranta-nou mil nou-cents noranta-nou",
                    ProbaRapida.say(909_999_999));
            assertEquals("Mil milions",
                    ProbaRapida.say(1_000_000_000));
            assertEquals("Quinze mil vint milions noranta-vuit mil cinc-cents quaranta-vuit",
                    ProbaRapida.say(15_020_098_548L));
            assertEquals("Nou-cents noranta-nou mil milions cinc mil tres-cents noranta-dos",
                    ProbaRapida.say(999_000_005_392L));
        }

        @org.junit.Test
        public void test6() {
            assertEquals("Un bilió",
                    ProbaRapida.say(1_000_000_000_000L));
            assertEquals("Mil bilions",
                    ProbaRapida.say(1_000_000_000_000_000L));
            assertEquals("Cent seixanta-cinc mil quaranta-tres bilions dos-cents disset mil nou-cents vuitanta-set milions cinquanta mil cent sis",
                    ProbaRapida.say(165_043_217_987_050_106L));
            assertEquals("Nou mil onze bilions sis-cents cinquanta-tres milions vint mil vuit",
                    ProbaRapida.say(9_011_000_653_020_008L));
            assertEquals("Nou-cents noranta-nou mil bilions",
                    ProbaRapida.say(999_000_000_000_000_000L));
        }

        @org.junit.Test
        public void test7() {
            assertEquals("Un trilió",
                    ProbaRapida.say(1_000_000_000_000_000_000L));
            assertEquals("Nou trilions dos-cents vint-i-tres mil tres-cents setanta-dos bilions trenta-sis mil vuit-cents cinquanta-quatre milions set-cents setanta-cinc mil vuit-cents set",
                    ProbaRapida.say(9_223_372_036_854_775_807L));
        }

        @org.junit.Test
        public void revTest1() {
            assertEquals(-2, ProbaRapida.words("Menys dos"));
            assertEquals(0, ProbaRapida.words("Zero"));
            assertEquals(10, ProbaRapida.words("Deu"));
            assertEquals(19, ProbaRapida.words("Dinou"));
            assertEquals(6, ProbaRapida.words("Sis"));

        }

        @org.junit.Test
        public void revTest2() {
            assertEquals(66, ProbaRapida.words("Seixanta-sis"));
            assertEquals(40, ProbaRapida.words("Quaranta"));
            assertEquals(72, ProbaRapida.words("Setanta-dos"));
            assertEquals(29, ProbaRapida.words("Vint-i-nou"));
            assertEquals(20, ProbaRapida.words("Vint"));
            assertEquals(99, ProbaRapida.words("Noranta-nou"));
            assertEquals(-61, ProbaRapida.words("Menys seixanta-un"));
        }

        @org.junit.Test
        public void revTest3() {
            assertEquals(211, ProbaRapida.words("Dos-cents onze"));
            assertEquals(100, ProbaRapida.words("Cent"));
            assertEquals(967, ProbaRapida.words("Nou-cents seixanta-set"));
        }

        @org.junit.Test
        public void revTest4() {
            assertEquals(1001, ProbaRapida.words("Mil un"));
            assertEquals(2022, ProbaRapida.words("Dos mil vint-i-dos"));
            assertEquals(99457, ProbaRapida.words("Noranta-nou mil quatre-cents cinquanta-set"));
            assertEquals(100_000, ProbaRapida.words("Cent mil"));
            assertEquals(543_432, ProbaRapida.words("Cinc-cents quaranta-tres mil quatre-cents trenta-dos"));
        }

        @org.junit.Test
        public void revTest5() {
            assertEquals(1_000_000, ProbaRapida.words("Un milió"));
            assertEquals(432_000_432, ProbaRapida.words("Quatre-cents trenta-dos milions quatre-cents trenta-dos"));
            assertEquals(76_021_022, ProbaRapida.words("Setanta-sis milions vint-i-un mil vint-i-dos"));
            assertEquals(6_000_001, ProbaRapida.words("Sis milions un"));
            assertEquals(999_999_991, ProbaRapida.words("Nou-cents noranta-nou milions nou-cents noranta-nou mil nou-cents noranta-un"));
            assertEquals(1_000_000_000, ProbaRapida.words("Mil milions"));
            assertEquals(889_054_543_982L, ProbaRapida.words("Vuit-cents vuitanta-nou mil cinquanta-quatre milions cinc-cents quaranta-tres mil nou-cents vuitanta-dos"));
        }

        @org.junit.Test
        public void revTest6() {
            assertEquals(1_000_000_000_000L, ProbaRapida.words("Un bilió"));
            assertEquals(8_888_999_222_111L, ProbaRapida.words("Vuit bilions vuit-cents vuitanta-vuit mil nou-cents noranta-nou milions dos-cents vint-i-dos mil cent onze"));
            assertEquals(123_456_789_234_567L, ProbaRapida.words("Cent vint-i-tres bilions quatre-cents cinquanta-sis mil set-cents vuitanta-nou milions dos-cents trenta-quatre mil cinc-cents seixanta-set"));
            assertEquals(3_765_200_000_212_007L, ProbaRapida.words("Tres mil set-cents seixanta-cinc bilions dos-cents mil milions dos-cents dotze mil set"));
        }

        @org.junit.Test
        public void revTest7() {
            assertEquals(1_000_000_000_000_000_000L, ProbaRapida.words("Un trilió"));
            assertEquals(9_223_372_036_854_775_807L,
                    ProbaRapida.words("Nou trilions dos-cents vint-i-tres mil tres-cents setanta-dos bilions trenta-sis mil vuit-cents cinquanta-quatre milions set-cents setanta-cinc mil vuit-cents set"));
        }

        @org.junit.Test
        public void oper1() {
            assertEquals("Dos", ProbaRapida.oper("Un més un"));
            assertEquals("Vint-i-tres", ProbaRapida.oper("Cinc més divuit"));
            assertEquals("Quaranta-dos", ProbaRapida.oper("Cinquanta-dos menys deu"));
            assertEquals("Cinquanta-quatre", ProbaRapida.oper("Sis per nou"));
            assertEquals("Nou", ProbaRapida.oper("Divuit dividit dos"));
            assertEquals("Vuit", ProbaRapida.oper("Disset dividit dos"));
            assertEquals("Set-cents vint-i-dos mil quatre-cents quaranta-dos",
                    ProbaRapida.oper("Set-cents vint-i-un per mil dos"));
            assertEquals("Setanta-sis milions cinc-cents seixanta-quatre mil quatre-cents cinquanta-quatre",
                    ProbaRapida.oper("Cinc-cents quaranta-tres mil quatre-cents trenta-dos més Setanta-sis milions vint-i-un mil vint-i-dos"));
        }

        @org.junit.Test
        public void oper2() {
            assertEquals("Cinc", ProbaRapida.oper("Un més un més tres"));
            assertEquals("Vint-i-dos", ProbaRapida.oper("Un més un més dos més tres més quatre més cinc més sis"));
            assertEquals("Nou", ProbaRapida.oper("Dos més vuit menys un"));
            assertEquals("Quinze", ProbaRapida.oper("Set més quatre per dos"));
            assertEquals("Vint-i-cinc", ProbaRapida.oper("Nou per dos més quinze dividit dos"));
            assertEquals("Quaranta-quatre mil tres-cents noranta-un milions quatre-cents dotze mil cent trenta",
                    ProbaRapida.oper("Set-cents setanta-cinc mil vuit-cents set per Cinquanta-set mil dos-cents vint-i-un més Quatre-cents trenta-dos dividit cinc menys Un milió quaranta mil tres-cents tres"));
            assertEquals("Quaranta-sis",
                    ProbaRapida.oper("Setze per quatre menys deu per dos més vuit dividit tres"));

        }

        @org.junit.Test
        public void oper3() {
            assertEquals("Cinc", ProbaRapida.oper("Set menys quatre més dos"));
            assertEquals("Menys tres", ProbaRapida.oper("Tres menys tres menys tres menys tres més tres"));
            assertEquals("Menys tretze", ProbaRapida.oper("Menys set menys sis"));
            assertEquals("Menys setanta-dos", ProbaRapida.oper("Menys divuit per quatre"));
            assertEquals("Menys sis", ProbaRapida.oper("Menys quaranta dividit sis"));
            assertEquals("Sis", ProbaRapida.oper("Menys quaranta dividit menys sis"));
        }
    }
