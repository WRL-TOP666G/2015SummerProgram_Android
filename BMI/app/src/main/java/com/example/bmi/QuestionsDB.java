package com.example.bmi;


public class QuestionsDB {
    int imvSrc = 0, totalNum = 0, imvBackground = 0;
    String question, ans1, ans2, ans3; //ans1 is the correct answer
    boolean state;

    public QuestionsDB(){

    }

    public QuestionsDB(int lessonNum, int quesNum){
        switch (lessonNum){
            case 1:
                totalNum = 2;
                imvBackground = R.drawable.wang_tai_sin;
                switch (quesNum){
                    case 1:
                        imvSrc = R.drawable.wang_tai_sin_1;
                        question = "Wong Tai Sin who is called Wong Tai Sin in next generation born in Zhejiang Province for China. What is his religion?";
                        ans1 = "Taoism";
                        ans2 = "Buddhism";
                        ans3 = "Allah";
                        state = true;
                        break;
                    case 2:
                        imvSrc = R.drawable.wang_tai_sin_2;
                        question = "When we go to the temple to pray, we worship with offerings. Which of the offerings can not worship?";
                        ans1 = "Fresh eel";
                        ans2 = "Durian";
                        ans3 = "Whole chicken";
                        state = true;
                        break;
                    default:
                        state = false;
                }
                break;
            case 2:
                imvBackground = R.drawable.mong_kok;
                totalNum = 2;
                switch (quesNum){
                    case 1:
                        imvSrc = R.drawable.mong_kok_1;
                        question = "MongKok is one of the famous tourist and shopping, so the traffic is developed. There are many characteristic streets. Which of the street name is located in this region?";
                        ans1 = "Tung Choi Street";
                        ans2 = "Temple Street";
                        ans3 = "Ap Liu Street";
                        state = true;
                        break;
                    case 2:
                        imvSrc = R.drawable.mong_kok_2;
                        question = "There has been lived in ancient, so there are many ancient pottery and ceramics. Which of the dynasty is discovered in this region? ";
                        ans1 = "Eastern Han Dynasty";
                        ans2 = "Western Han Dynasty";
                        ans3 = "Stone Age";
                        state = true;
                        break;
                    default:
                        state = false;
                }
                break;
            case 3:
                imvBackground = R.drawable.yau_ma_tei;
                totalNum = 2;
                switch (quesNum){
                    case 1:
                        imvSrc = R.drawable.yau_ma_tei_1;
                        question = "In 1875, Why people called  Ma Tei ?";
                        ans1 = "Fishermen sun-dry hemp rope";
                        ans2 = "Local people product a mass of sesame oil";
                        ans3 = "Businessmen trade hemp rope";
                        state = true;
                        break;
                    case 2:
                        imvSrc = R.drawable.yau_ma_tei_2;
                        question = "The following options, which is the region's first hospital which be founded in 1911?";
                        ans1 = "Kwong Wah Hospital";
                        ans2 = "Queen Elizabeth Hospital";
                        ans3 = "Kowloon Hospital";
                        state = true;
                        break;
                    default:
                        state = false;
                }
                break;
            case 4:
                imvBackground = R.drawable.central;
                totalNum = 3;
                switch (quesNum){
                    case 1:
                        imvSrc = R.drawable.central_1;
                        question = "Central was heyday from 1970 to 1980. Which profession promote Central";
                        ans1 = "Finance";
                        ans2 = "Industry";
                        ans3 = "High-tech ";
                        state = true;
                        break;
                    case 2:
                        imvSrc = R.drawable.central_2;
                        question = "Central has a famous sights which is Central-Mid-Levels Escalator and Walkway System. Original plan is build six. Why the government only build one?";
                        ans1 = "Overruns";
                        ans2 = "Environmental issues";
                        ans3 = "Political Factors";
                        state = true;
                        break;
                    case 3:
                        imvSrc = R.drawable.central_3;
                        question = "Hong Kong Club is a private club, which of the building  near by Hong Kong Club ?";
                        ans1 = "Statue Square";
                        ans2 = "Before the Legislative Council Building";
                        ans3 = "Queen's Pier";
                        state = true;
                        break;
                    default:
                        state = false;
                }
                break;
            case 5:
                imvBackground = R.drawable.causeway_bay;
                totalNum = 3;
                switch (quesNum){
                    case 1:
                        imvSrc = R.drawable.causeway_bay_1;
                        question = "Causeway Bay is located in a cape of Victoria City. So, its former name is";
                        ans1 = "East Point";
                        ans2 = "South Point";
                        ans3 = "North Point";
                        state = true;
                        break;
                    case 2:
                        imvSrc = R.drawable.causeway_bay_2;
                        question = "There are several large shopping malls in Causeway Bay, including Times Square, Lee Theatre Plaza and World Trade Centre. Which of the following is not in Causeway Bay?";
                        ans1 = "HARBOUR CITY";
                        ans2 = "LEE GARDENS";
                        ans3 = "SOGO";
                        state = true;
                        break;
                    case 3:
                        imvSrc = R.drawable.causeway_bay_3;
                        question = "Causeway Bay lies across two regions, not including";
                        ans1 = "South Area";
                        ans2 = "East Area";
                        ans3 = "Wan chai";
                        state = true;
                        break;

                    default:
                        state = false;
                }
                break;
            case 6:
                imvBackground = R.drawable.disneyland;
                totalNum = 3;
                switch (quesNum){
                    case 1:
                        imvSrc = R.drawable.disneyland_1;
                        question = "The Transfer Station of Disneyland metro line is";
                        ans1 = "Sunny Bay";
                        ans2 = "Tung Chung";
                        ans3 = "Tsing Yi";
                        state = true;
                        break;
                    case 2:
                        imvSrc = R.drawable.disneyland_2;
                        question = "Hong Kong Disneyland is the world _____ Disneyland";
                        ans1 = "5th";
                        ans2 = "7th";
                        ans3 = "8th";
                        state = true;
                        break;
                    case 3:
                        imvSrc = R.drawable.disneyland_3;
                        question = "The theme song of Hong Kong Disneyland 'let it fly' is sung by the Honorary ambassador of Hong Kong Disneyland, he is";
                        ans1 = "Jacky Cheung";
                        ans2 = "TWINS";
                        ans3 = "Fahrenheit";
                        state = true;
                        break;

                    default:
                        state = false;
                }
                break;
            case 7:
                imvBackground = R.drawable.yuen_long;
                totalNum = 3;
                switch (quesNum){
                    case 1:
                        imvSrc = R.drawable.yuen_long_1;
                        question = "Yuen Long is a ____in terms of landforms.";
                        ans1 = "alluvial plain";
                        ans2 = "aggraded flood plain";
                        ans3 = "delta";
                        state = true;
                        break;
                    case 2:
                        imvSrc = R.drawable.yuen_long_2;
                        question = "Yuen Long District is the only district in Hong Kong which has two towns, which of the following is not included?";
                        ans1 = "Fanling-Sheung Shui New Town";
                        ans2 = "Tin Shui Wai New Town";
                        ans3 = "Yuen Long new town";
                        state = true;
                        break;
                    case 3:
                        imvSrc = R.drawable.yuen_long_3;
                        question = "The first large housing estate in Yuen Long is _____in Nam Sang Wai.";
                        ans1 = "Fairview Park";
                        ans2 = "Sun Yuen Long Centre";
                        ans3 = "The Reach";
                        state = true;
                        break;

                    default:
                        state = false;
                }
                break;
            case 8:
                imvBackground = R.drawable.tung_chung;
                totalNum = 3;
                switch (quesNum){
                    case 1:
                        imvSrc = R.drawable.tung_chung_1;
                        question = "Tung Chung Cable Car has another name____.";
                        ans1 = "Ngong Ping 360";
                        ans2 = "Mount Parker Cable Car";
                        ans3 = "Hong Kong Ocean Park Cable Car";
                        state = true;
                        break;
                    case 2:
                        imvSrc = R.drawable.tung_chung_2;
                        question = "Recreational facility in Tung Chung don't include";
                        ans1 = "Swimming pool";
                        ans2 = "Library";
                        ans3 = "basketball field";
                        state = true;
                        break;
                    case 3:
                        imvSrc = R.drawable.tung_chung_3;
                        question = "The battery in Tung Chung fort barbette is used to";
                        ans1 = "Decoration";
                        ans2 = "Fight";
                        ans3 = "Defense";
                        state = true;
                        break;

                    default:
                        state = false;
                }
                break;
            case 9:
                imvBackground = R.drawable.tsuen_wan;
                totalNum = 4;
                switch (quesNum){
                    case 1:
                        imvSrc = R.drawable.tsuen_wan_1;
                        question = "In ancient, which is not  people referred to call?";
                        ans1 = "Song Bay";
                        ans2 = "Thieves Bay";
                        ans3 = "Shallow Bay";
                        state = true;
                        break;
                    case 2:
                        imvSrc = R.drawable.tsuen_wan_2;
                        question = "Tsuen Wan Residents primary language is?";
                        ans1 = "Hakka";
                        ans2 = "Minnan dialect";
                        ans3 = "Cantonese";
                        state = true;
                        break;
                    case 3:
                        imvSrc = R.drawable.tsuen_wan_3;
                        question = "Which  industry in the fifties is the center of this area?";
                        ans1 = "Textile Industry";
                        ans2 = "Business";
                        ans3 = "Arms";
                        state = true;
                        break;
                    case 4:
                        imvSrc = R.drawable.tsuen_wan_4;
                        question = "Which is the only university in this area?";
                        ans1 = "Zhuhai College";
                        ans2 = "Liao Baoshan Memorial College";
                        ans3 = "Holy Cross Lutheran School";
                        state = true;
                        break;

                    default:
                        state = false;
                }
                break;
            case 10:
                imvBackground = R.drawable.diamond_hill;
                totalNum = 4;
                switch (quesNum){
                    case 1:
                        imvSrc = R.drawable.diamond_hill_1;
                        question = "Why it is called the Diamond Hill?";
                        ans1 = "Stone mineral";
                        ans2 = "Diamond";
                        ans3 = "Ancient numerous transactions of diamonds";
                        state = true;
                        break;
                    case 2:
                        imvSrc = R.drawable.diamond_hill_2;
                        question = "Which the following is Diamond Hill Attractions?";
                        ans1 = "Nan Lian Garden";
                        ans2 = "Zoological and Botanical Gardens";
                        ans3 = "Promenade";
                        state = true;
                        break;
                    case 3:
                        imvSrc = R.drawable.diamond_hill_3;
                        question = "When did Nan Lian Garden completed?";
                        ans1 = "2006";
                        ans2 = "2004";
                        ans3 = "2008";
                        state = true;
                        break;
                    case 4:
                        imvSrc = R.drawable.diamond_hill_4;
                        question = "What is dynasty architecture in Nan Lian Garden? ";
                        ans1 = "Tang Dynasty";
                        ans2 = "Song Dynasty";
                        ans3 = "Qing Dynasty";
                        state = true;
                        break;

                    default:
                        state = false;
                }
                break;

            case 11:
                imvBackground = R.drawable.racecourse;
                break;


            default:
                state = false;
        }
    }

    public String getAns1() {
        return ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public int getImvSrc() {
        return imvSrc;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isState() {
        return state;
    }

    public int getTotalNum() { return totalNum;  }

    public int getImvBackground() { return imvBackground;  }
}
