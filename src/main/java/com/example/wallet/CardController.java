package com.example.wallet;

import java.util.Optional;
import java.lang.Integer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CardController
 */
@RestController
@RequestMapping(path = "/card")
public class CardController {
    
    @Autowired   
    private CardRepository cardRepository;
    private UserRepository userRepository;

    CardController(CardRepository cardRepository, UserRepository userRepository){
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("add/{user_id}")
    public Card addUserCard(@PathVariable int user_id, @RequestBody Card card){
        Optional <User> user = userRepository.findById(user_id);
        if(user.isEmpty() || cardRepository.existsById(card.getCardNumber())){
            return null;
        }
        try {
            card.setUser(user.get());
            cardRepository.save(card);
            //TODO: error message in case of duplicated card number
            return card;
        } catch (Exception e) {
            //TODO: handle exception
        }
        //TODO: return a message instead of an object
        return null;
    }

    @GetMapping("all/{user_id}")
    public Iterable<Card> getUserCards(@PathVariable int user_id) {
        Optional<User> user = userRepository.findById(user_id);

        if (user.isEmpty()) {
            return null;
        }
        //TODO: return a message if user doesnt have card
        return user.get().getCards();
    }
    
    
    @DeleteMapping("delete/{id_card}")
    public void removeUserCard(@PathVariable int id_card){
        
        Optional<Card> card = cardRepository.findById(Integer.toString(id_card));

        if (card.isEmpty()) {
            //TODO: 
        }

        cardRepository.delete(card.get());
        //TODO: return a message 
    }
}