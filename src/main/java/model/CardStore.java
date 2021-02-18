package model;

import java.util.ArrayList;
import java.util.List;

public final class CardStore {

    private static CardStore cardStore;

    private List<WordCard> wordCardList;

    private CardStore(){
        wordCardList = new ArrayList<>();
    }

    public static CardStore getInstance(){
        if(cardStore ==null){
            cardStore = new CardStore();
        }
        return cardStore;
    }

    public void addToCardList(WordCard wordCard){
        if(wordCard!=null) {
            wordCardList.add(wordCard);
        }
    }

    public List<WordCard> getWordCardList() {
        return wordCardList;
    }
}
