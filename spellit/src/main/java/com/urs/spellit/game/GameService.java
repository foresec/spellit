package com.urs.spellit.game;

import com.urs.spellit.game.entity.CardEntity;
import com.urs.spellit.game.entity.DeckEntity;
import com.urs.spellit.game.entity.GameCharacterEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    final private CardRepository cardRepository;
    final private DeckRepository deckRepository;
    final private GameCharacterRepository gameCharacterRepository;

    public List<CardEntity> getAllCards() {
        List<CardEntity> allCards = cardRepository.findAll();
        return allCards;
    }
    public List<GameCharacterEntity> getAllCharacter() {
        List<GameCharacterEntity> allCharacters = gameCharacterRepository.findAll();
        return allCharacters;
    }
    public List<CardEntity> getUserDeck(long memberId) {
        List<DeckEntity> deckEntities = deckRepository.findByMemberId(memberId);
        List<CardEntity> deck = new ArrayList<>();
        for(DeckEntity d : deckEntities) {
            deck.add(d.getCard());
        }
        return deck;
    }
    public GameCharacterEntity getCharacter(long characterId)
    {
        GameCharacterEntity gameCharacterEntity=gameCharacterRepository.findById(characterId);
        return gameCharacterEntity;
    }

}