package com.example.bmi;

/**
 * Created by ee4093 on 8/3/2015.
 */
public class ChatDB {
    int imvBackground, imvNPC;
    String[] talkContent;
    boolean[] talker;

    public ChatDB(){}

    public ChatDB(int lesson){
        switch(lesson){
            case 1:
                imvBackground = R.drawable.wang_tai_sin;
                imvNPC = R.drawable.npc_wang_tai_sin;
                talkContent = new String[]{"Hello! Welcome Wong Tai Sin!",
                        "Hello!",
                        "Firstly, I would like to give a short introduce about this place.",
                        "Oh, it's really nice of you.",
                        "Wong Tai Sin district is among the 18 districts in Hong Kong.",
                        "And it's well-known for the Wong Tai Sin Temple here.",
                        "That sounds great! May I have a look?",
                        "Yes! Sure! Later, I'll show you around. ",
                        "Thank you very much!"};
                talker = new boolean[]{false, true, false, true, false, false, true, false, true};
                break;
            case 2:
                imvBackground = R.drawable.mong_kok;
                imvNPC = R.drawable.npc_mong_kok;
                talkContent = new String[]{"I've been waiting for you so long, dear!",
                        "Thank you!",
                        "I'm you guide here in Mong Kok.",
                        "Nice to meet you! ",
                        "Is it your first time to come here?",
                        "Yes. I am always looking forward to shopping here.",
                        "You are in the right place. ",
                        "Mong Kok is famous for the numerous stores and shopping malls here.",
                        "Wonderful! "};
                talker = new boolean[]{false, true, false, true, false, true, false, false, true};
                break;

            case 3:
                imvBackground = R.drawable.yau_ma_tei;
                imvNPC = R.drawable.npc_yau_ma_tei;
                talkContent = new String[]{"Now it's Yau Ma Tei. And I'm the guide here.",
                        "Oh, thanks for the trouble.",
                        "Not at all. It's my pleasure.",
                        "I heard that people here still maintain the traditional way of life in Hong Kong to a large extent.",
                        "Yes. You seem to know a lot about Yau Ma Tei.",
                        "Then, what can I do here?",
                        "Here are some century-old teahouses in this area. ",
                        "And roadside stands serve many specialty snacks as well.",
                        "Oh! I can't wait to taste them!"};
                talker = new boolean[]{false, true, false, true, false, true, false, false, true};
                break;

            case 4:
                imvBackground = R.drawable.central;
                imvNPC = R.drawable.npc_central;
                talkContent = new String[]{"Welcome Central-the heart of Hong Kong! ",
                        "The heartland?",
                        "Yes. It's the most prosperous and bustling district in Hong Kong.",
                        "Wow! It must be an excellent place for shopping.",
                        "It is Indeed. There are countless restaurants and fashion brand stores.",
                        "Then, what are you waiting for? Let's go!",
                        "Ok, this way please."};
                talker = new boolean[]{false, true, false, true, false, true, false};
                break;

            case 5:
                imvBackground = R.drawable.causeway_bay;
                imvNPC = R.drawable.npc_causeway_bay;
                talkContent = new String[]{"Welcome Causeway Bay! Have you ever heard it before?",
                        "Yes, of course.",
                        "In this case, I will introduce it briefly.",
                        "Okay.",
                        "There are many large shopping malls in this district, including Sogo, Times Square, Lee Theatre Plaza and World Trade Centre.",
                        "Oh, I fall in love with this place. When we go?",
                        "Are you ready?",
                        "Yes! Let's shopping!"};
                talker = new boolean[]{false, true, false, true, false, true, false, true};
                break;

            case 6:
                imvBackground = R.drawable.disneyland;
                imvNPC = R.drawable.npc_disneyland;
                talkContent = new String[]{"Hot dogs?",
                        "One, please",
                        "Popcorns?",
                        "Sure",
                        "Hong Kong Disneyland ticket?",
                        "Two, just you & me",
                        "Let's  go"};
                talker = new boolean[]{false, true, false, true, false, true, false};
                break;

            case 7:
                imvBackground = R.drawable.yuen_long;
                imvNPC = R.drawable.npc_yuan_long;
                talkContent = new String[]{"From Song, the population become more & more. Why appear the stranger today?",
                        "Hello",
                        "Who are you?",
                        "I just want to look around",
                        "In the past, we mainly produced rice which can sell to far away lands to Southeast Asia.",
                        "That is interesting."};
                talker = new boolean[]{false, true, false, true, false, true};
                break;

            case 8:
                imvBackground = R.drawable.tung_chung;
                imvNPC = R.drawable.npc_tung_chung;
                talkContent = new String[]{"Very one built the two fort at the foot of the Shishi hill",
                        "See also general",
                        "Who? Take him down",
                        "Unjustly accuse"};
                talker = new boolean[]{false, true, false, true};
                break;

            case 9:
                imvBackground = R.drawable.tsuen_wan;
                imvNPC = R.drawable.npc_tsuen_wan;
                talkContent = new String[]{"When you want to make money , just comes to Jinshan. ",
                        "When you want to die, just come to Tsuen Wan",
                        "What?",
                        "The pirate rampant ",
                        "Ok, I will notice",
                        "Be care for hidden weapon "};
                talker = new boolean[]{false, false, true, false, true, false};
                break;

            case 10:
                imvBackground = R.drawable.diamond_hill;
                imvNPC = R.drawable.npc_diamond_hill;
                talkContent = new String[]{"When can I finish all the ore on the mountain?",
                        "Anyway you have next generation.",
                        "!!!!",
                        "!!!!",
                        "You dig",
                        "What the?.."};
                talker = new boolean[]{false, true, false, true, false, true};
                break;

            case 11:
                imvBackground = R.drawable.racecourse;
                imvNPC = R.drawable.npc_racecourse;
                talkContent = new String[]{"I also make lots of money today. Happy~~~",
                        "Ha",
                        "Who are you? If you do not want to gamble, please get out. ",
                        "Why you say that?",
                        "Go away",
                        "Battle"};
                talker = new boolean[]{false, true, false, true, false, true};
                break;
            case 12:
                imvBackground = R.drawable.mtr_back;
                imvNPC = R.drawable.mtr_logo;
                talkContent = new String[]{"...........",
                        "uh..?It seems there is somebody??",
                        "..........",
                        "I can feel,but I can't see.",
                        "uhhhhhhh!!!!! help!!! I am almost covered by garbage",
                        "Battle"};
                talker = new boolean[]{false,true,false,true,false,false};
                break;

        }
    }

    public int getImvBackground() {
        return imvBackground;
    }

    public int getImvNPC() { return imvNPC;  }

    public boolean[] getTalker() {
        return talker;
    }

    public String[] getTalkContent() {
        return talkContent;
    }
}
